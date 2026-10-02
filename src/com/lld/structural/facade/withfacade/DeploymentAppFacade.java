package com.lld.structural.facade.withfacade;

/**
 * Using the facade from the client
 */
public class DeploymentAppFacade {
    public static void main(String [] args){
        DeploymentFacade deploymentFacade = new DeploymentFacade();
        //Deploy to production
        deploymentFacade.deployApplication("main", "prod.server.example.com");

    }
}
