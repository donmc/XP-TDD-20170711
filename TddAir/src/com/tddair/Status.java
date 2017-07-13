package com.tddair;

public enum Status {
  Gold(75000, 7000), Blue(50000, 8000), Green(25000, 9000), Red(0, 10000);
  
  private int threshold;
  private int milesCost;

  private Status(int threshold, int milesCost) {
    this.threshold = threshold;
    this.milesCost = milesCost;
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
}
