package com.tddair;

public enum MembershipStatus {

  GOLD("Gold", 75000, 7000, 60), BLUE("Blue", 50000, 8000, 75), GREEN("Green", 25000, 9000, 90), RED("Red", 0, 10000,
      100);

  private String label;
  private int threshold;
  private int milesCost;
  private int dollarsCost;

  MembershipStatus(String label2, int threshold2, int milesCost2, int dollarsCost2) {
    label = label2;
    threshold = threshold2;
    milesCost = milesCost2;
    dollarsCost = dollarsCost2;
  }

  public String getStatusLabel() {
    return label;
  }

  public int getThreshold() {
    return threshold;
  }

  public int getMilesCost() {
    return milesCost;
  }

  public int getDollarsCost() {
    return dollarsCost;
  }

  /**
   * 
   * @param mileage
   * @return
   */
  public static MembershipStatus calculateStatus(int mileage) {

    MembershipStatus status = MembershipStatus.RED;

    for (MembershipStatus statusType : MembershipStatus.values()) {
      if (mileage >= statusType.getThreshold()) {
        status = statusType;
        break;
      }
    }

    return status;
  }

  public int calculateMilesCost(int qty) {
    return getMilesCost() * qty;
  }

}
