package com.lld.TrafficLight.application;

import com.lld.TrafficLight.context.TrafficLight;

public class TrafficLightApplication {
    public static void main(String []args){
        TrafficLight light = new TrafficLight();
        light.change(); //RED light - Stop
        light.change(); //GREEN light - Go
        light.change(); //YELLOW light - slow down
        light.change(); //RED light - Stop
        light.change(); //GREEN light - Go
    }
}
