package com.tddair;

public class Member {

  private String userName;
  private String email;
  private MembershipStatus status;
  private int ytdMiles;
  private int balance;

  public Member(String userName2, String email2) {
    userName = userName2;
    email = email2;
    // TODO Auto-generated constructor stub
  }

  public String getStatusLabel() {
    return status.getStatusLabel();
  }

  public void setStatus(MembershipStatus status) {
    this.status = status;
  }

  public MembershipStatus getStatus() {
    return status;
  }

  public int getYtdMiles() {
    return ytdMiles;
  }

  public void setYtdMiles(int ytdMiles) {
    this.ytdMiles = ytdMiles;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public String getUserName() {
    // TODO Auto-generated method stub
    return userName;
  }
  
  public void completeFlight(int mileage) {

    // update YTD miles
    setYtdMiles(getYtdMiles() + mileage);
    
    // update Balance
    setBalance(getBalance() + mileage);
    
    updateMembershipStatus();
  }

  private void updateMembershipStatus() {
    // TODO Auto-generated method stub
    int currentYtdMiles = getYtdMiles();
    
    MembershipStatus status = getStatus();
    if (currentYtdMiles >= 25000 && currentYtdMiles < 50000) {
      status = MembershipStatus.GREEN;
    } else if (currentYtdMiles >= 50000 && currentYtdMiles < 75000) {
      status = MembershipStatus.BLUE;
    } else if (currentYtdMiles >= 75000) {
      status = MembershipStatus.GOLD;
    }
  
    setStatus(status);
  }
}
