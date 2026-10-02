package com.lld.structural.facade.withoutfacade;

/**
 * Compiles the codebase
 * creates an artifact (like a .jar)
 * and returns its location
 */
public class BuildSystem {
    public boolean compileProject(){
        System.out.println("BuildSystem: Compiling project...");
        simulateDelay(2000);
        System.out.println("BuildSystem: Build successful... ");
        return true;
    }

    public String getArtifactPath(){
        String path = "target/myapp-1.0.jar";
        System.out.println("BuildSystem: Artifact located at "+ path);
        return path;
    }
    private void simulateDelay(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
