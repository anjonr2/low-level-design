package com.lld.creational.singleton;

/**
 * This approach creates the singleton instance only when it is needed,
 * saving resources if the singleton is never used in the application
 */
public class LazySingleton {

    //Holds the single shared instance initially not created
    private static LazySingleton instance;

    //private constructor prevents creating objects from outside the class
    private LazySingleton(){}

    //Global access point to get the Singleton instance
    public static LazySingleton getInstance(){
        //Create instance only when first requested (lazy initialization)
        if(instance == null){
            instance = new LazySingleton();
        }

        //return the shared instance
        return instance;
    }

}

/**
 * Not thread-safe
 *
 * This implementation is not thread-safe. If multiple threads
 * call getInstance() simultaneously when instance is null , it's possible to
 * create multiple instances
 */