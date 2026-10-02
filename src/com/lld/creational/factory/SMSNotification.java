package com.lld.creational.factory;

/**
 * Define concrete products
 */
public class SMSNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println("SMSNotification: sending sms notification "+ message);
    }
}
