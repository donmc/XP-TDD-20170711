package com.tddair;

public class SpyCas implements Cas {

  public int getAmountCharged() {
    // TODO Auto-generated method stub
    return 0;
  }
  
  /* (non-Javadoc)
   * @see com.tddair.Cas#charge(int, java.lang.String)
   */
  @Override
  public boolean charge(int amt, String cc) {
    return false;
  }

}
