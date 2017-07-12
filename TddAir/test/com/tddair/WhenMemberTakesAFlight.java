package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenMemberTakesAFlight {

  String userName = "bob";
  TddAirApplication app = new TddAirApplication();

  @Before
  public void setUp() throws Exception {
    app.registerMember(userName, "bob@example.com");
  }

  private void takesLongFlight(String flightNumber, int noOfTimes) {
    for (int i = 0; i < noOfTimes; i++) {
      app.membersTakesFlight(userName, flightNumber);
    }
  }

  @Test
  public void testMemberStatusShouldNotChange() {
    app.membersTakesFlight(userName, "AA242");

    Member member = app.lookupMember(userName);
    assertEquals(MembershipStatus.RED.getStatusLabel(), member.getStatusLabel());
  }

  @Test
  public void testMemberYTDMilesUpdated() {
    app.membersTakesFlight(userName, "AA242");
    Member member = app.lookupMember(userName);

    assertEquals(924, member.getYtdMiles());
  }

  @Test
  public void testMemberBalanceMilesUpdated() {
    app.membersTakesFlight(userName, "AA242");
    Member member = app.lookupMember(userName);

    assertEquals(10924, member.getBalance());
  }

  @Test
  public void testMemberStatusUpgradedToGreen() {
    // SETUP
    takesLongFlight("QF271", 2);

    app.membersTakesFlight(userName, "QF191");

    Member member = app.lookupMember(userName);
    assertEquals(MembershipStatus.GREEN.getStatusLabel(), member.getStatusLabel());
  }

  @Test
  public void testMemberStatusUpgradedToBlue() {
    // SETUP
    takesLongFlight("QF271", 4);
    takesLongFlight("QF191", 1);

    app.membersTakesFlight(userName, "QF191");

    Member member = app.lookupMember(userName);
    assertEquals(MembershipStatus.BLUE.getStatusLabel(), member.getStatusLabel());
  }

  @Test
  public void testMemberStatusUpgradedToGold() {
    // SETUP
    takesLongFlight("QF271", 7);

    app.membersTakesFlight(userName, "QF191");

    Member member = app.lookupMember(userName);
    assertEquals(MembershipStatus.GOLD.getStatusLabel(), member.getStatusLabel());
  }
}
