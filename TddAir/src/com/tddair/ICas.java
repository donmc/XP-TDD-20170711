package com.tddair;

public interface ICas {

  boolean charge(String creditCard, int amount) throws SeatUpgradePurchaseFailedException;

}
