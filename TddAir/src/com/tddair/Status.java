package com.tddair;

public enum Status {
  Gold(75000, 7000, 60), Blue(50000, 8000, 75), Green(25000, 9000, 90), Red(0, 10000, 100);
  
  private int threshold;
  private int milesCost;
  private int dollarCost; 

  private Status(int threshold, int milesCost, int dollarCost) {
    this.threshold = threshold;
    this.milesCost = milesCost;
    this.dollarCost = dollarCost;
  }

  public static Status calculateStatus(int ytdMiles) {
    Status status = Status.Red;
    for (Status currentStatus : Status.values()) {
      if (ytdMiles >= currentStatus.getThreshold()) {
        status = currentStatus;
        break;
      }
    }

    return status;
  }
  
  public int getThreshold() {
    return threshold;
  }

  public int getMilesCost() {
    return milesCost;
  }
  
  public int getDollarCost() {
    return dollarCost;
  }
}
