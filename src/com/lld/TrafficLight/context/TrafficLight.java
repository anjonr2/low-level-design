package com.lld.TrafficLight.context;

import com.lld.TrafficLight.state.ITrafficLightState;
import com.lld.TrafficLight.state.RedState;

public class TrafficLight {
    private ITrafficLightState state;

    public TrafficLight() {
        this.state = new RedState();
    }

    public void setState(ITrafficLightState state) {
        this.state = state;
    }

    public void change(){
        state.change(this);
    }

}
