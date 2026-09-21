package com.lld.structural.proxy.databasecache;

import java.util.HashMap;
import java.util.Map;

public class CachingDatabaseProxy implements DatabaseService{
    private RealDatabaseService realService;
    private Map<String, String> cache = new HashMap<>();

    public CachingDatabaseProxy(){
        this.realService = new RealDatabaseService();
    }

    @Override
    public String query(String sql) {
        if(cache.containsKey(sql)){
            System.out.println("CachingProxy: Cache HIT for: "+ sql);
            return cache.get(sql);
        }
        System.out.println("CachingProxy: Cache MISS for: "+sql);
        String result = realService.query(sql);
        cache.put(sql, result);
        return result;
    }

    public void clearCache(){
        System.out.println("CachingProxy: Cache cleared. ");
        cache.clear();
    }
}
