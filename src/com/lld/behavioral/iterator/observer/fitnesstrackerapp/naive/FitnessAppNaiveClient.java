package com.lld.behavioral.iterator.observer.fitnesstrackerapp.naive;

public class FitnessAppNaiveClient {
    public static void main(String [] args){
        FitnessData fitnessData = new FitnessData();

        fitnessData.newFitnessDataPushed(500, 5, 20);
        fitnessData.newFitnessDataPushed(9800,85,350);
        fitnessData.newFitnessDataPushed(10100, 90,380);
        fitnessData.dailyReset();
    }
}

/**
 * This works initially, but let us think what happens as the application grows
 *
 * Problems with this approach
 * 1. Tight Coupling:
 * FitnessData holds direct references to LiveActivityDisplay, ProgressLogger and
 * NotificationService. It knows their concrete types, their method signatures, and their
 * construction logic
 *
 * If any of these classes change their interface, or if you want to replace
 * one with a different implementation, you must modify FitnessData
 *
 * 2. Violates the Open/Closed principle :
 * What happens when you want to add
 * a WeeklySummaryGenerator? Or a SocialSharingService that posts achievements to social media
 *
 * Each new feature requires you to
 *
 * Add a new field to FitnessData
 * Modify the newFitnessDataPushed() method
 * Potentially update the constructor
 *
 * This class is open for modification when it should be closed
 *
 * 3. Inflexible and static design
 *
 * Modules like
 * the NotificationService or ProgressLogger can't be added or removed at runtime
 * What if the user disables notifications in their settings?
 *
 * You will need to add conditionals to manually enable/disable parts of the code, making things
 * fragile and error-prone
 *
 * 4. Responsibility Bloat :
 * FitnessData should have one job : managing fitness metrics.
 * Instead, it is now responsible for UI updates, database logging, and notification logic
 * This violates the single responsibility principle
 *
 * 5. Scalability bottlenecks :
 *
 * As the number of dependents grows, newFitnessDataPushed() becomes a lengthy sequence of
 * method calls, each with different parameters and error handling requirements
 *
 * What we Really need :
 *
 * We need a better, scalable way to solve this problem, something that allows
 * 1.FitnessData to broadcast changes to multiple listeners, without knowing who they are
 * 2.Each module to subscribe or unsubscribe dynamically
 * 3.Loose coupling between subject and observers
 * 4.Each module to decide for itself how to respond to changes
 *
 * This is exactly what the Observer pattern provides
 */
