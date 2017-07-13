package com.tddair.casservices;

/**
 * Created by agrawm2 on 7/13/2017.
 */
public interface PaymentDao {
    public abstract boolean chargeCreditCard(int cardNumber, int seatQuantity, int costPerSeat);
}
