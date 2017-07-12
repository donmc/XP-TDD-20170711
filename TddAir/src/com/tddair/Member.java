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
    
    setStatus(MembershipStatus.calculateStatus(getYtdMiles()));
  }

  
}
