package com.lld.TrafficLight.state;

import com.lld.TrafficLight.context.TrafficLight;

public class YellowState implements ITrafficLightState{
    @Override
    public void change(TrafficLight context) {
        System.out.println("YELLOW light - Slow Down");
        context.setState(new RedState());
    }
}
