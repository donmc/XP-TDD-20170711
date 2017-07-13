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
    mom.redGuy.purchaseSeatUpgradesWithCC("111111111", 1);
    
    assertEquals(1, mom.redGuy.getSeatUpgradeBalance());
    assertEquals(100, spy.getAmountCharged());
  }

  @Ignore
  @Test
  public void shouldNotPurchaseWithInvalidCC() {

  }

  @Ignore
  @Test
  public void shouldPayCorrectAmountByStatus() {

  }
}
