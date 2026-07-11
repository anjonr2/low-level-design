package com.lld.TrafficLight.state;

import com.lld.TrafficLight.context.TrafficLight;

public interface ITrafficLightState {
    void change(TrafficLight context);
}
