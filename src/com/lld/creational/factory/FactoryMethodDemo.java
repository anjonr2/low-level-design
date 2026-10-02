package com.lld.creational.factory;

public class FactoryMethodDemo {
    public static void main(String [] args){
        NotifactionCreator creator;

        //send email
        creator = new EmailNotificationCreator();
        creator.send("Welcome to our platform!");

        creator = new SMSNotificationCreator();
        creator.send("Your OTP is 123456");

        creator = new PushNotificationCreator();
        creator.send("You have a new follower");
    }
}


/**
 * Each line creates the appropriate creator, calls the shared send() method
 * and right notification type is created and used internally. The client never
 * touches concrete product classes directly
 */