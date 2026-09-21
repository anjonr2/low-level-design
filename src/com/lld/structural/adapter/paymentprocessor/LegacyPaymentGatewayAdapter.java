package com.lld.structural.adapter.paymentprocessor;

public class LegacyPaymentGatewayAdapter implements PaymentProcessor{
    private final LegacyPaymentGateway legacyPaymentGateway;
    private long currentRef;

    public LegacyPaymentGatewayAdapter(LegacyPaymentGateway legacyPaymentGateway){
        this.legacyPaymentGateway = legacyPaymentGateway;
    }


    @Override
    public void processPayment(double amount, String currency) {
        System.out.println("Adapter: Translating processPayment() for " + amount + " " + currency);
        legacyPaymentGateway.executeTransaction(amount, currency);
        currentRef = legacyPaymentGateway.getReferenceNumber();
    }

    @Override
    public boolean isPaymentSuccessful() {
        return legacyPaymentGateway.checkStatus(currentRef);
    }

    @Override
    public String getTransactionId() {
        return "LEGACY_TXN_"+ currentRef;
    }
}
