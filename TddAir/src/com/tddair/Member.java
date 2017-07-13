package com.tddair;

public class Member {

  private String userName;
  private String email;
  private MembershipStatus status;
  private int ytdMiles;
  private int balance;
  private int seatUpgradesAvailable;
  private ICas cas;

  public Member(String userName2, String email2) {
    userName = userName2;
    email = email2;

    setStatus(MembershipStatus.RED);
    setYtdMiles(0);
    setBalance(10000);
    setSeatUpgradesAvailable(0);
  }

  public void setCas(ICas cas2) {
    cas = cas2;
  }

  public ICas getCas() {
    return cas;
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

  public int getSeatUpgradesAvailable() {
    return seatUpgradesAvailable;
  }

  public void setSeatUpgradesAvailable(int seatUpgradesAvailable) {
    this.seatUpgradesAvailable = seatUpgradesAvailable;
  }

  /**
   * 
   * @param mileage
   */
  public void completeFlight(int mileage) {

    // update YTD miles
    setYtdMiles(getYtdMiles() + mileage);

    // update Balance
    setBalance(getBalance() + mileage);

    setStatus(MembershipStatus.calculateStatus(getYtdMiles()));
  }

  public void purchaseSeatUpgradeWithMiles(int qty) throws SeatUpgradePurchaseFailedException {
    int requiredMiles = getStatus().calculateMilesCost(qty);
    if (requiredMiles > getBalance()) {
      throw new SeatUpgradePurchaseFailedException("Member miles not enough");
    }
    int updatedBalance = getBalance() - requiredMiles;
    setBalance(updatedBalance);
    setSeatUpgradesAvailable(getSeatUpgradesAvailable() + qty);

  }

  public boolean purchaseSeatUpgradeWithCC(String creditCard, int qty) throws SeatUpgradePurchaseFailedException {
    
     int totalAmount = getStatus().getDollarsCost() * qty;
     boolean result = getCas().charge(creditCard, totalAmount);
     if(result){
       setSeatUpgradesAvailable(getSeatUpgradesAvailable() + qty);
     }
     return result;
  }

}
