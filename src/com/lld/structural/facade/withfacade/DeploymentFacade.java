package com.lld.structural.facade.withfacade;

import com.lld.structural.facade.withoutfacade.BuildSystem;
import com.lld.structural.facade.withoutfacade.DeploymentTarget;
import com.lld.structural.facade.withoutfacade.TestingFramework;
import com.lld.structural.facade.withoutfacade.VersionControlSystem;

/**
 * Implementing the Facade
 *
 * DeploymentFacade class serves as a single, unified interface to the
 * complex set of operations involved in application deployment
 *
 * Internally, it holds references to the core building blocks of the
 * deployment pipeline:
 *
 * VersionControlSystem - Fetches the latest code from a Git branch
 * BuildSystem - Compiles the code and generates the deployable artifact
 * TestingFramework - Runs automated tests (unit, integration)
 * DeploymentTarget - Transfers the artifact and activates it on the target
 * server
 *
 * Rather than forcing the client to call each of these subsystems
 * in the correct order, the facade abstracts this coordination logic
 * and offers a clean, high-level method like deployApplication()
 * that executes the full workflow
 *
 * The client makes one call. The facade handles the entire orchestration
 * internally. If any step fails, the facade returns false and the client
 * never has to know which subsystem caused the problem
 */
public class DeploymentFacade {
    private VersionControlSystem vcs = new VersionControlSystem();
    private BuildSystem buildSystem = new BuildSystem();
    private TestingFramework testingFramework = new TestingFramework();
    private DeploymentTarget deploymentTarget = new DeploymentTarget();


    public boolean deployApplication(String branch, String serverAddress){
        System.out.println("\nFACADE: --- Initiating FULL DEPLOYMENT for branch: "+ branch + " to " + serverAddress + " ---");
        boolean success = true;

        try {
            vcs.pullLatestChanges(branch);
            if(!buildSystem.compileProject()){
                System.err.println("FACADE: DEPLOYMENT FAILED - Build compilation failed.");
                return false;
            }

            String artifactPath = buildSystem.getArtifactPath();
            if(!testingFramework.runIntegrationTests()){
                System.err.println("FACADE: DEPLOYMENT FAILED - Unit tests failed. ");
                return false;
            }
            if(!testingFramework.runIntegrationTests()){
                System.err.println("FACADE: DEPLOYMENT FAILED - Integration tests failed.");
                return false;
            }

            deploymentTarget.transferArtifact(artifactPath, serverAddress);
            deploymentTarget.activateNewVersion(serverAddress);

            System.out.println("FACADE: APPLICATION DEPLOYED SUCCESSFULLY to "+ serverAddress + "!");
        }catch (Exception e){
            System.err.println("FACADE: DEPLOYMENT FAILED - An unexpected error occurred: "+ e.getMessage());
            e.printStackTrace();
            success = false;
        }

        return success;
    }
}

/**
 *So client now no longer needs to understand or interact with individual subsystems
 * It does not worry about the sequence of operations, error handling, or internal logic
 * It simply calls one expressive method: deployApplication()
 */