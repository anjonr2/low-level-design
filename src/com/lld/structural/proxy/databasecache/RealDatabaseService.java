package com.lld.structural.proxy.databasecache;

public class RealDatabaseService implements DatabaseService{
    @Override
    public String query(String sql) {
        System.out.println("RealDatabase: Executing query: "+ sql);
        try {
            Thread.sleep(200);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        return "Result for [" + sql + "]";
    }
}
