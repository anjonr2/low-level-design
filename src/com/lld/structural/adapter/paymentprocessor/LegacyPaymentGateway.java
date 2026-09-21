package com.lld.structural.adapter.paymentprocessor;

/**
 * Here's what legacy payment class looks like
 */
public class LegacyPaymentGateway {
    private long transactionReference;
    private boolean paymentSuccessful;

    public void executeTransaction(double totalAmount, String currency){
        System.out.println("LegacyPaymentGateway: Executing " + currency + " " + totalAmount);
        transactionReference = System.nanoTime();
        paymentSuccessful = true;
        System.out.println("LegacyPaymentGateway: Success. Txn Ref: "+ transactionReference);
    }

    public boolean checkStatus(long ref){
        System.out.println("LegacyPaymentGateway: Checking status for Txn Ref: "+ ref);
        return paymentSuccessful;
    }

    public long getReferenceNumber(){
        return transactionReference;
    }
}


/**
 * So now you have two interfaces: that do the same thing but speak different languages
 *
 * PaymentProcessor
 * LegacyInterface (LegacyPaymentGateway)
 *
 * PaymentProcessor interface has processPayment(double, string) whereas
 * LegacyPaymentGateway has executeTransaction(double, string) Different method names
 *
 * isPaymentSuccessful() vs checkStatus(long) Different method names and different parameters
 *
 * getTransactionId()  returns string vs getReferenceNumber() returns long , different method names
 * + different return types
 *
 * And here is the constraint we cannot change CheckoutService, it is used system-wide
 * and depends on PaymentProcessor
 *
 * You cannot modify LegacyGateway, it is from an external vendor
 *
 * But you must make them work together
 *
 * What you need is a translator,
 * a class that sits between CheckoutService and LegacyPaymentGateway, adapting the incompatible
 * interface into one that works with your system
 *
 * Adapter pattern lets classes work together that otherwise could not because of incompatible interfaces
 *
 * Two characteristics define the pattern :
 *
 * 1. Interface translator : The adapter maps method calls from one interface to another
 * handling differences in method names, parameter types, return types and calling conventions
 *
 * 2. No source modification : Neither the client's expected interface nor the incompatible class is changed
 * The adapter wraps the incompatible class and presents the expected interface to the client
 *
 *
 * Adapter has four participants:
 *
 * Target interface
 * The interface that the client code depends on. Every method call from the client code
 * goes through this interface
 *
 * In our payment example, PaymentProcessor is the target
 * The checkout service only knows about processPayment(), isPaymentSuccessful()
 * and getTransactionId()
 *
 * Adaptee
 * The existing class with a useful implementation but an incompatible interface
 * In our example LegacyGateway is the Adaptee. It can process payments
 * but its methods executeTransaction(), checkStatus(), getReferenceNumber() do not match
 * what the checkout service expects
 *
 * Adapter
 * The translator. It implements the Target interface and holds a reference
 * to the Adaptee, delegating calls with necessary translation
 *
 */