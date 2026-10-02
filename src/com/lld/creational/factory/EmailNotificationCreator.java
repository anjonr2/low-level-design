package com.lld.creational.factory;

/**
 * Define the concrete creators
 */
public class EmailNotificationCreator extends NotifactionCreator{
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
