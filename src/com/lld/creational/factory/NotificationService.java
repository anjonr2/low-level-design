package com.lld.creational.factory;


public class NotificationService {

    public void sendNotification(String type, String message){
        /**
         * All creation logic is in one place in SimpleNotificationFactory
         * Now NotificationService is cleaner
         */
        Notification notification = SimpleNotificationFactory.createNotification(type);
        notification.send(message);

        /**
         * This is better. The service only uses the notification, it does not construct it
         * Adding new types is easier since you only modify the factory, not every service
         * that uses notification
         *
         * But as your product grows and you keep adding new notification types
         * This SimpleNotificationFactory is beginning to look like if else block check
         *
         * Every time you introduce a new type, you are right back to modifying the factory's
         * switch or if-else statement
         *
         * This is still not Open/Closed
         *
         * Your system is better, but it is still not open to extension without
         * modification. You're still hardcoding decision logic and centralizing creation
         * in one place
         * You need to give each type of notification its own responsibility for knowing
         * how to create itself
         *
         * The Factory Method Pattern takes the idea of object creation and hands it off
         * to subclasses. Instead of one central factory deciding what to create, you delegate
         * the responsibility to specialized classes that know exactly what they need to produce
         *
         * Each subclass defines its own way of instantiating an object
         *
         * So now, instead of having :
         * if type == "EMAIL" → return new EmailNotification()
         * if type == "SMS" → return new SMSNotification()
         *
         * You have :
         *
         * //EmailNotificationCreator knows it should return new EmailNotification
         * SMSNotificationCreator knows it should return new SMSNotification
         *
         *your object creation logic is decentralized
         *
         * Product :
         *
         * The interface or abstract class that defines the contract for all objects the factory
         * method creates. Every concrete product implements this interface, which means the rest of the
         * system can work with any product without knowing its concrete type
         *
         * Concrete product :
         * The actual classes that implement the Product interface
         * Each one provides its own behavior
         *
         * With the Factory Method pattern, instead of putting the burden of decision-making
         * in a single place we distribute the object creation responsibilities across the system
         * in a clean, organized way
         */
    }
}
