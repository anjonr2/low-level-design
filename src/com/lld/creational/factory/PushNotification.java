package com.lld.creational.factory;

/**
 * Concrete products
 */
public class PushNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println("PushNotification: sending push notification "+ message);
    }
}
