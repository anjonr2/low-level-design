package com.lld.structural.proxy.databasecache;

public class DatabaseCacheDemo {
    public static void main(String[] args){
        DatabaseService db = new CachingDatabaseProxy();

        System.out.println("--- First query (cache miss) ---");
        System.out.println(db.query("SELECT * FROM users"));

        System.out.println("\n--- Same query again (cache hit)--- ");
        System.out.println(db.query("SELECT * FROM users"));
    }
}

/**
 * The first query takes a full 100 ms ( simulated database latency)
 * The identical second query returns instantly from cache
 * client code is using Same DatabaseService interface throughout
 * unware that caching is happening behind the scenes
 */