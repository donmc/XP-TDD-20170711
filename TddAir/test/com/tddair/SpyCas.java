package com.tddair;

public class SpyCas implements Cas {

  public static final String VALID_CC = "11111111111";
  public static final String INVALID_CC = "99999999999";
  private int amountCharged;

  public int getAmountCharged() {
    return amountCharged;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.tddair.Cas#charge(int, java.lang.String)
   */
  @Override
  public boolean charge(int amount, String cc) {
    boolean valid = cc.equals(VALID_CC);
    if (valid) {
      this.amountCharged = amount;
    }
    
    return valid;
  }

}
