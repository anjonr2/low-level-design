package com.lld.structural.facade.withoutfacade;

/**
 * Executes unit and integration tests
 * Could also integrate E2E or security scans in real-world setup
 */
public class TestingFramework {
    public boolean runUnitTests(){
        System.out.println("Testing: Running unit tests...");
        simulateDelay(1500);
        System.out.println("Testing: Unit tests passed...");
        return true;
    }

    public boolean runIntegrationTests(){
        System.out.println("Testing: Running integration tests...");
        simulateDelay(3000);
        System.out.println("Testing: Integration tests passed...");
        return true;
    }
    private void simulateDelay(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
