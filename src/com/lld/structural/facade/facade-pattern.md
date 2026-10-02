**1. The Problem: Deployment Complexity**

Let's say you're building a deployment automation tool for your development
team

On the surface, deploying an application many seem like a striaghtforward task,
but in reality, it involves a sequence of coordinated, error-prone steps

1. Pull the latest code from a Git Repository
2. Build the project using a tool like Maven or Gradle
3. Run automated tests (unit, integration, maybe end-to-end)
4. Deploy the build artifact to a production environment

Each of these steps might be handled by a separate module or class,
each with its own specific API and configuration

Facade(e.g., DeploymentFacade)
Knows which subsystem classes to use and in what order
Delegates requests to appropriate subsystems method without exposing
internal details to the client

SubSystems classes (e.g: VersionControlSystem, BuildSystem)

Provides the actual business logic to handle a specific task.
Do not know about the facade. Can still be used independently if needed

Client(e.g., our main application or a script)
Uses the Facade to initiate a deployment, instead of interacting with the
subsystems classes directly