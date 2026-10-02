package com.lld.creational.factory;

/**
 * We create an abstract class that declares the factory
 * method createNotification(), and optionally includes
 * shared behavior like send() that defines the high level logic
 * of sending a notification by using whatever object
 * createNotification() provides
 */
public abstract class NotifactionCreator {
    //Factory method - subclasses decide what to create
    public abstract Notification createNotification();

    //Shared logic that uses the factory method
    public void send(String message){
        Notification notification = createNotification();
        notification.send(message);
    }
}

/**
 * Think of this class as a template: it does not know what notification it is sending
 * but it knows how to send it. It defers the choice of notification type to its subclasses
 *
 */