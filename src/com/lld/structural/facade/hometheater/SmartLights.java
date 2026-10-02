package com.lld.structural.facade.hometheater;

public class SmartLights {
    public void dim(int level){
        System.out.println("Lights: Dimmed to "+ level + "%.");
    }

    public void on(){
        System.out.println("Lights: Full brightness.");
    }
}
