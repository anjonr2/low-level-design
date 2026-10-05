package com.lld.behavioral.strategy.paymentProcessing;

public class PaymentApp {
    public static void main(String [] args){
        CheckoutService checkout = new CheckoutService(new CreditCardPayment("4111344565780987", "12/76"));
        checkout.checkout(99.99);

        checkout.setPaymentStrategy(new PayPalPayment("user@example.com"));
        checkout.checkout(49.99);
    }
}

/**
 * The CheckoutService has no idea whether it is charging a credit card,
 * sending a PayPal request, or initiating a crypto transfer
 * It just calls pay() on whatever strategy is plugged in
 * Adding a new payment method (bank transfer,Apple pay, buy-now-pay-later)
 * means creating one new class. Nothing else existing changes
 */