package com.lld.structural.facade.withoutfacade;

/**
 * Without a facade,
 * the client must directly interact with each subsystem, knowing exactly which methods to call
 * and in what order. The client is tightly coupled to every subsystem
 */
public class DeploymentClient {
    public static void main(String[] args){
        String branch = "main";
        String prodServer = "prod.server.example.com";

        //client must create and manage all subsystems
        VersionControlSystem vcs = new VersionControlSystem();
        BuildSystem buildSystem = new BuildSystem();
        TestingFramework testFramework = new TestingFramework();
        DeploymentTarget deployTarget = new DeploymentTarget();

        System.out.println("\n[Client] Starting deployment for branch: "+ branch);

        //Step 1 : Pull latest code
        vcs.pullLatestChanges(branch);

        //Step 2 : Build the project
        if(!buildSystem.compileProject()){
            System.out.println("\n[Client] Build failed. Deployment aborted.");
            return;
        }

        String artifact = buildSystem.getArtifactPath();

        //Step 3 : Run tests
        if(!testFramework.runIntegrationTests()){
            System.out.println("[Client] Unit tests failed. Deployment aborted.");
            return;
        }
        if(!testFramework.runIntegrationTests()){
            System.out.println("[Client] Integration tests failed. Deployment aborted.");
            return;
        }

        //Step 4: Deploy to production;
        deployTarget.transferArtifact(artifact,prodServer);
        deployTarget.activateNewVersion(prodServer);

        System.out.println("[Client] Deployment successful! ");
    }
}

/**
 * Now imagine you need to deploy this from another part of your application
 * a scheduled job, or a different service. You would have to duplicate this entire
 * sequence of calls, along with all the error handling logic
 *
 * What's wrong with this design
 * While this works, it leads to several problems as your system grows
 *
 * 1. High Client Complexity
 * The client must be aware of every subsystem: what classes to instantiate, what methods to call
 * in what sequence, and what to do on success or failure. This bloats the client's responsibility
 * and tightly couples it to the internal workings of the deployment pipeline
 *
 * 2.Tight Coupling
 * The client directly depends on
 * VersionControlSystem, BuildSystem, TestingFramework and DeploymentSystem
 *
 * A change in any one of them will ripple through every client that performs
 * deployments
 *
 * 3. Poor Maintainability
 * Want to add a code quality scan before deployment? Send slack notification
 * after deployment? Integrate a rollback mechanism?
 *
 * You will need to update every place that performs deployments, bloating them with
 * more logic and increasing chance of inconsistency
 *
 * What we need?
 * We need a way to hide the complexity of the underlying subsystems, expose a simple
 * and unified interface to perform deployments, decouple client code from the internal
 * workflow and make the system easier to maintain, test and evolve
 *
 * The Facade Design Pattern
 *
 * The Facade Pattern introduces a high-level interface that hides the complexities of one
 * or more subsystems and exposes only the functionality needed by the client
 */