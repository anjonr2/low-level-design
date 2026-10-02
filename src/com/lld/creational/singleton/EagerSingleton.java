package com.lld.creational.singleton;

public class EagerSingleton {
    //Holds the single shared instance (created immediately at class load time)
    private static final EagerSingleton instance = new EagerSingleton();

    //private constructor prevents creating objects from outside the class
    private EagerSingleton(){}

    //Global access point to get the singleton instance
    public static EagerSingleton getInstance(){
        //return the already-created shared instance
        return instance;
    }
}
