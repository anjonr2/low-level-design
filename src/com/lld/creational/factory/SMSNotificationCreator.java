package com.lld.creational.factory;

public class SMSNotificationCreator extends NotifactionCreator{
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}
