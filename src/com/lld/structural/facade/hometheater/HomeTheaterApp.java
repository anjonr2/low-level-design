package com.lld.structural.facade.hometheater;

public class HomeTheaterApp {
    public static void main(String [] args){
        Amplifier amp = new Amplifier();
        DvdPlayer dvd = new DvdPlayer();
        Projector projector = new Projector();
        SmartLights lights = new SmartLights();
        StreamingService streaming = new StreamingService();

        HomeTheaterFacade theater = new HomeTheaterFacade(amp, dvd, projector, lights,streaming);

        theater.watchMovie("Interstellar");
        theater.endMovie();
    }
}

/**
 * As we can see client does not care about order of operation
 * which devices to power on first or how to properly sht everything down
 * The facade handles all of that
 */