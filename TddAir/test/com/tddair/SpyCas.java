package com.tddair;

public class SpyCas implements Cas {

  public static final String VALID_CC = "11111111111";
  private int amountCharged;
  
  public int getAmountCharged() {
    return amountCharged;
  }
  
  /* (non-Javadoc)
   * @see com.tddair.Cas#charge(int, java.lang.String)
   */
  @Override
  public boolean charge(int amt, String cc) {
    return false;
  }

}
