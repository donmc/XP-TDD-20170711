package com.tddair;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenMemberSeatUpgradesWithCC {

  TddAirApplication app = new TddAirApplication();
  MembershipMother memberMother = new MembershipMother();

  @Test
  public void testRedMemberSingleSeatUpgradesAvailable() throws SeatUpgradePurchaseFailedException {

    Member redMember = memberMother.createMember(app, MembershipStatus.RED, 10000);
    SpyCas spycas = new SpyCas();
    redMember.setCas(spycas);

    redMember.purchaseSeatUpgradeWithCC(SpyCas.GOOD_CC, 1);

    assertEquals(1, redMember.getSeatUpgradesAvailable());
    assertEquals(100, spycas.getAmount());
  }

  @Test
  public void testRedMemberMultipleSeatUpgradesAvailable() throws SeatUpgradePurchaseFailedException {

    Member redMember = memberMother.createMember(app, MembershipStatus.RED, 10000);
    SpyCas spycas = new SpyCas();
    redMember.setCas(spycas);

    redMember.purchaseSeatUpgradeWithCC(SpyCas.GOOD_CC, 5);

    assertEquals(5, redMember.getSeatUpgradesAvailable());
    assertEquals(500, spycas.getAmount());
  }

  @Test
  public void testRedMemberSingleSeatUpgradeForInvalidCCFails() {

    Member redMember = memberMother.createMember(app, MembershipStatus.RED, 10000);
    SpyCas spycas = new SpyCas();
    redMember.setCas(spycas);

    try {
      redMember.purchaseSeatUpgradeWithCC(SpyCas.BAD_CC, 1);
      fail();
    } catch (SeatUpgradePurchaseFailedException ex) {
      assertEquals(0, redMember.getSeatUpgradesAvailable());
    }
  }

  @Test
  public void testGoldMemberMultipleSeatUpgradesAvailable() throws SeatUpgradePurchaseFailedException {

    Member redMember = memberMother.createMember(app, MembershipStatus.GOLD, 80000);
    SpyCas spycas = new SpyCas();
    redMember.setCas(spycas);

    redMember.purchaseSeatUpgradeWithCC(SpyCas.GOOD_CC, 2);

    assertEquals(2, redMember.getSeatUpgradesAvailable());
    assertEquals(120, spycas.getAmount());
  }
}
