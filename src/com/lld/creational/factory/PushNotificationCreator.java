package com.lld.creational.factory;

public class PushNotificationCreator extends NotifactionCreator{

    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}

/**
 * No more conditionals. Each class knows what it needs to create, and the core system
 * does not need to care
 *
 * EmailNotificationCreator returns new EmailNotification()
 * SMSNotificationCreator returns new SmsNotification()
 *
 * the mapping is one to one and is explicit
 */