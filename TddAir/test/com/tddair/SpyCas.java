package com.tddair;

public class SpyCas implements ICas {

  public static String GOOD_CC = "111-111-111";
  public static String BAD_CC = "999-999-999";
  private int amount;

  public int getAmount() {
    return amount;
  }

  @Override
  public boolean charge(String creditCard, int chargedAmount) throws SeatUpgradePurchaseFailedException {
    if (GOOD_CC.equals(creditCard)) {
      amount = chargedAmount;
      return true;
    } else if (BAD_CC.equals(creditCard)) {
      amount = 0;
      throw new SeatUpgradePurchaseFailedException("Bad Creditcard Number");

    }
    return false;
  }

}
