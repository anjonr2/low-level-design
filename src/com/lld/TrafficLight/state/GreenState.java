package com.lld.TrafficLight.state;

import com.lld.TrafficLight.context.TrafficLight;

public class GreenState implements ITrafficLightState{
    @Override
    public void change(TrafficLight context) {
        System.out.println("GREEN light - GO");
        context.setState(new YellowState());
    }
}
