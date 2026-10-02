package com.lld.creational.factory;

public class SimpleNotificationFactory {
    public static Notification createNotification(String type){
        switch (type){
            case "EMAIL":
                return new EmailNotification();
            case "SMS" :
                return new SMSNotification();
            case "PUSH" :
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown type");
        }
    }
}
