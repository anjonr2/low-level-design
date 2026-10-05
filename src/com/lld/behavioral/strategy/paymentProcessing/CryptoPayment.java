package com.lld.behavioral.strategy.paymentProcessing;

public class CryptoPayment implements PaymentStrategy{
    private final String walletAddress;

    public CryptoPayment(String walletAddress){
        this.walletAddress = walletAddress;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Transferring $" + amount + " in crypto to " + walletAddress);
        return true;
    }
}
