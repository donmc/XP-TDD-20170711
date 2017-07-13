package com.tddair.casservices;

/**
 * Created by agrawm2 on 7/13/2017.
 */
public class FakePaymentDao implements PaymentDao{

    @Override
    public boolean chargeCreditCard(int cardNumber, int amount) {
        return false;
    }
}
