package com.lld.jirasystem.observer;

public class User implements Observer{

    private final String id;
    private final String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(String message) {
        System.out.println("User "+name+" notified : "+message);
    }
}
