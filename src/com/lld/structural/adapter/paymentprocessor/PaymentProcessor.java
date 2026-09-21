package com.lld.structural.adapter.paymentprocessor;

/**
 * Here's the contract that CheckoutService expects any payment provider to follow
 * This abstraction makes it easy to swap payment providers without changing any core
 * business logic
 */
public interface PaymentProcessor {
    void processPayment(double amount, String currency);
    boolean isPaymentSuccessful();
    String getTransactionId();
}
