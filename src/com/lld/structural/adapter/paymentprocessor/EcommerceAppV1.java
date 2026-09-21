package com.lld.structural.adapter.paymentprocessor;

public class EcommerceAppV1 {
    public static void main(String [] args){
        PaymentProcessor processor = new InHousePaymentProcessor();
        CheckoutService checkout = new CheckoutService(processor);
        checkout.checkout(199.99, "USD");
    }
}

/**
 * Everything works smoothly. You've decoupled your checkout
 * business logic from the underlying payment implementation
 * allowing future flexibility
 *
 * Now management drops a new requirement: integrate with a legacy
 * third party payment provider. Its interface is different from PaymentProcessor
 */
