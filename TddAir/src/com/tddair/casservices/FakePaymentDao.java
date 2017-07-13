package com.tddair.casservices;

/**
 * Created by agrawm2 on 7/13/2017.
 */
public class FakePaymentDao implements PaymentDao{

    @Override
    public boolean chargeCreditCard(int cardNumber, int seatQuantity, int costPerSeat) {
        if(cardNumber != 999999999){
            int totalAmountCharged = seatQuantity * costPerSeat;
            return true;
        }
        return false;
    }
}
