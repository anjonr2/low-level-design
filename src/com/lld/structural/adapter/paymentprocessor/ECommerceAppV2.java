package com.lld.structural.adapter.paymentprocessor;

public class ECommerceAppV2 {
    public static void main(String[] args){
        //Modern processor
        PaymentProcessor processor = new InHousePaymentProcessor();
        CheckoutService modernCheckout = new CheckoutService(processor);
        System.out.println("--- Using Modern Processor ---");
        modernCheckout.checkout(199.99, "USD");

        //Legacy gateway through Adapter
        System.out.println("\n--- Using Legacy Gateway via Adapter ---");
        LegacyPaymentGateway legacy = new LegacyPaymentGateway();
        processor = new LegacyPaymentGatewayAdapter(legacy);
        CheckoutService legacyCheckout = new CheckoutService(processor);
        legacyCheckout.checkout(75.50, "USD");
    }
}
