package com.lld.structural.facade.hometheater;

/**
 * Facade class
 */
public class HomeTheaterFacade {
    private Amplifier amplifier;
    private DvdPlayer dvdPlayer;
    private Projector projector;
    private SmartLights smartLights;
    private StreamingService streamingService;

    public HomeTheaterFacade(Amplifier amplifier, DvdPlayer dvdPlayer, Projector projector, SmartLights smartLights, StreamingService streamingService) {
        this.amplifier = amplifier;
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.smartLights = smartLights;
        this.streamingService = streamingService;
    }

    public void watchMovie(String movie){
        System.out.println("\n--- Preparing to play: "+ movie + " ---");
        smartLights.dim(15);
        projector.on();
        projector.wideScreenMode();
        amplifier.on();
        amplifier.setVolume(20);
        streamingService.connect();
        streamingService.stream(movie);
        System.out.println("---Started playing--- \n");
    }

    public void endMovie(){
        System.out.println("\n--- Shutting down home theater ---");
        streamingService.disconnect();
        amplifier.off();
        projector.off();
        smartLights.on();
        System.out.println("--- Home theater off ---\n");
    }
}
