package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenPurchasingSeatUpgradesWithCC {

  private MemberMother mom;

  @Before
  public void setup() {
    mom = new MemberMother();
  }

  @Test
  public void shouldPurchaseWithValidCC() {
    SpyCas spy = new SpyCas();
    mom.redGuy.setCas(spy);
    mom.redGuy.purchaseSeatUpgradesWithCC(SpyCas.VALID_CC, 1);
    
    assertEquals(1, mom.redGuy.getSeatUpgradeBalance());
    assertEquals(100, spy.getAmountCharged());
  }

  @Test
  public void shouldNotPurchaseWithInvalidCC() {
    SpyCas spy = new SpyCas();
    mom.redGuy.setCas(spy);
    boolean valid = mom.redGuy.purchaseSeatUpgradesWithCC(SpyCas.INVALID_CC, 1);
 
    assertFalse(valid);
    assertEquals(0, mom.redGuy.getSeatUpgradeBalance());
  }

  @Ignore
  @Test
  public void shouldPayCorrectAmountByStatus() {

  }
}
