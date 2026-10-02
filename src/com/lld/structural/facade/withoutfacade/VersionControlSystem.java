package com.lld.structural.facade.withoutfacade;

/**
 * Handles interactions with Git or another VCS
 * Responsible for fetching the latest code
 */
public class VersionControlSystem {
    public void pullLatestChanges(String branch){
        System.out.println("VCS: Pulling latest changes from "+ branch);
        simulateDelay();
        System.out.println("VCS: Pull complete. ");
    }

    private void simulateDelay(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
