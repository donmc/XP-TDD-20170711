package com.tddair;

public enum MembershipStatus {
  
  GOLD("Gold", 75000),
  BLUE("Blue", 50000),
  GREEN("Green", 25000),
  RED("Red", 0);
  

  private String label;
  private int threshold;
  
  MembershipStatus(String label2, int threshold2) {
    label = label2;
    threshold = threshold2;
  }

  public String getStatusLabel() {
    return label;
  }
  public int getThreshold() {
    return threshold;
  }
  
  public static MembershipStatus calculateStatus(int mileage) {
    
    MembershipStatus status = MembershipStatus.RED;
    
    for(MembershipStatus statusType: MembershipStatus.values()) {
      if(mileage >= statusType.getThreshold()) {
        status = statusType;
        break;
      }
    }
  
    return status;
  }
}
