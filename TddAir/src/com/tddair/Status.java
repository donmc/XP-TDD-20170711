package com.tddair;

public enum Status {
  Gold(75000), Blue(50000), Green(25000), Red(0);
  
  private int threshold;

  private Status(int threshold) {
    this.threshold = threshold;
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
}
