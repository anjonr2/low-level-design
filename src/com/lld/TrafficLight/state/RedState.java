package com.lld.TrafficLight.state;

import com.lld.TrafficLight.context.TrafficLight;

public class RedState implements ITrafficLightState{
    @Override
    public void change(TrafficLight context) {
        System.out.println("RED light - Stop");
        context.setState(new GreenState());
    }
}
