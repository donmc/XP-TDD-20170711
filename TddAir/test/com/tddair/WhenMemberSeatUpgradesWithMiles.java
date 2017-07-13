package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenMemberSeatUpgradesWithMiles {

  TddAirApplication app = new TddAirApplication();
  MembershipMother memberMother = new MembershipMother();

  @Test
  public void testRedMemberSingleSeatUpgradesAvailable() throws SeatUpgradePurchaseFailedException {

    // SETUP
    Member redMember = memberMother.createMember(app, MembershipStatus.RED, 10000);
    redMember.purchaseSeatUpgradeWithMiles(1);

    // TEST

    assertEquals(1, redMember.getSeatUpgradesAvailable());
    assertEquals(0, redMember.getBalance());
  }

  @Test
  public void testRedMemberUpgradesFailsSeatUpgradesAndBalanceNotAffected() {

    Member redMember = memberMother.createMember(app, MembershipStatus.RED, 10000);

    try {
      redMember.purchaseSeatUpgradeWithMiles(2);
      fail();
    } catch (SeatUpgradePurchaseFailedException ex) {
      assertEquals("Member miles not enough", ex.getMessage());
      Member member = app.lookupMember(redMember.getUserName());
      assertEquals(0, member.getSeatUpgradesAvailable());
      assertEquals(10000, member.getBalance());
    }
  }

  @Test
  public void testRedMemberUpgradesFailsForInsufficentBalance() {

    Member redMember = memberMother.createMember(app, MembershipStatus.RED, 0);

    try {
      redMember.purchaseSeatUpgradeWithMiles(1);
      fail();
    } catch (SeatUpgradePurchaseFailedException ex) {
      assertEquals("Member miles not enough", ex.getMessage());
      assertEquals(0, redMember.getSeatUpgradesAvailable());
      assertEquals(0, redMember.getBalance());
    }
  }

  @Test
  public void testGoldMemberSingleSeatUpgradesAvailable() throws SeatUpgradePurchaseFailedException {

    // SETUP
    Member redMember = memberMother.createMember(app, MembershipStatus.GOLD, 80000);
    redMember.purchaseSeatUpgradeWithMiles(2);

    assertEquals(2, redMember.getSeatUpgradesAvailable());
    assertEquals(66000, redMember.getBalance());
  }
}
