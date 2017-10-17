package com.tddair;

public class Member {

  private String username;
  private String email;
  private Status status;
  private int ytdMiles;
  private int balanceMiles;
  private int seatUpgradeBalance;
  private Cas cas;

  public Member(String username, String email) {
    this.username = username;
    this.email = email;
    this.status = Status.Red;
    this.ytdMiles = 0;
    this.balanceMiles = 10000;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public Status getStatus() {
    return status;
  }

  public int getYtdMiles() {
    return ytdMiles;
  }

  public int getBalanceMiles() {
    return balanceMiles;
  }

  public void completeFlight(Flight flight) {
    ytdMiles += flight.getMileage();
    balanceMiles += flight.getMileage();

    status = Status.calculateStatus(ytdMiles);

  }

  public void purchaseSeatUpgradesWithMiles(int quantity) {
    int totalCost = status.getMilesCost() * quantity;

    if (totalCost <= balanceMiles) {
      seatUpgradeBalance += quantity;
      balanceMiles -= status.getMilesCost() * quantity;
    } else {
      throw new CantAffordException();
    }
  }

  public int getSeatUpgradeBalance() {
    return seatUpgradeBalance;
  }

  public void setCas(Cas cas) {
    this.cas = cas;
  }

  public boolean purchaseSeatUpgradesWithCC(String cc, int quantity) {

    int amount = status.getDollarCost() * quantity;

    boolean valid = cas.charge(amount, cc);
    if (valid) {
      seatUpgradeBalance += quantity;
    }

    return valid;

  }

}
