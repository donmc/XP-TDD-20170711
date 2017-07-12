package com.tddair;

public enum MembershipStatus {
  RED("Membership Status Red");

  private String status;

  MembershipStatus(String value) {
    status = value;
  }

  public String getStatusLabel() {
    return status;
  }
}
