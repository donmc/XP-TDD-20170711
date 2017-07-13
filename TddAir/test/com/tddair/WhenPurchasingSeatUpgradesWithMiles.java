package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenPurchasingSeatUpgradesWithMiles {

  private MemberMother mom;

  @Before
  public void setup() {
    mom = new MemberMother();
  }

  @Test
  public void shouldIncreaseSeatUpgradeBalance() {
    int quantity = 1;
    mom.redGuy.purchaseSeatUpgradesWithMiles(quantity);

    assertEquals(1, mom.redGuy.getSeatUpgradeBalance());
  }

  @Test
  public void shouldDecreaseBalanceMiles() {
    int startBalance = mom.redGuy.getBalanceMiles();
    mom.redGuy.purchaseSeatUpgradesWithMiles(1);
    int difference = startBalance - mom.redGuy.getBalanceMiles();

    assertEquals(10000, difference);
  }

  @Test
  public void shouldPurchaseMultipleSeatUpgrades() {

    int quantity = 2;
    mom.redGuy.completeFlight(new Flight("XXX", "YYY", 10000));
    int startBalance = mom.redGuy.getBalanceMiles();
    mom.redGuy.purchaseSeatUpgradesWithMiles(quantity);
    int difference = startBalance - mom.redGuy.getBalanceMiles();

    assertEquals(2, mom.redGuy.getSeatUpgradeBalance());
    assertEquals(20000, difference);
  }

  @Test(expected = CantAffordException.class)
  public void shouldNotPurchaseSeatUpgradesWithInsufficientBalanceMiles() {
    mom.redGuy.purchaseSeatUpgradesWithMiles(2);
  }
  
  @Test
  public void shouldDecreaseBalanceBy9000ForGreen() {
    int startBalance = mom.greenGuy.getBalanceMiles();
    mom.greenGuy.purchaseSeatUpgradesWithMiles(1);
    int difference = startBalance - mom.greenGuy.getBalanceMiles();
    assertEquals(difference, 9000);
  }
  
  @Test
  public void shouldDecreaseBalanceBy8000ForBlue() {
    int startBalance = mom.blueGuy.getBalanceMiles();
    mom.blueGuy.purchaseSeatUpgradesWithMiles(1);
    int difference = startBalance - mom.blueGuy.getBalanceMiles();
    assertEquals(difference, 8000);
  }
}
