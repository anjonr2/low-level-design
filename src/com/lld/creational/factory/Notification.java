package com.lld.creational.factory;

/**
 * Define the product interface
 * This is the contract that all notification types must follow
 * Any code that works with notifications only depends on this interface
 */
public interface Notification {
    public void send(String message);
}
