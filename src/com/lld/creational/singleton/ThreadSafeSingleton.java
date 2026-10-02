package com.lld.creational.singleton;

/**
 * This approach extends lazy initialization by ensuring the
 * Singleton is safe to use in multi-threaded environments
 *
 * When multiple threads try to access the instance at the same time
 * synchronization (or locking) ensures that only one thread can create the
 * object, while others wait
 */
public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){}

    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}

/**
 * The instance is created only when first requested (lazy initialization)
 * The method that returns the instance uses a lock synchronization mechanism
 * When a thread enters the protected section, it acquires the lock. Other threads
 * must wait until the lock is released
 * This guarantees that only instance is created even under concurrent access
 */