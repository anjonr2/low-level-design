package com.lld.creational.factory;

/**
 * Concrete product
 */
public class EmailNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println("EmailNotifiaction: sending email notification "+message);
    }
}
