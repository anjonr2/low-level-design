package com.lld.behavioral.iterator.observer.fitnesstrackerapp.withpattern;

public class FitnessAppObserverDemo {
    public static void main(String [] args){
        FitnessData fitnessData = new FitnessData();

        LiveActivityDisplay display = new LiveActivityDisplay();
        ProgressLogger logger = new ProgressLogger();
        GoalNotifier notifier = new GoalNotifier();

        //Register observers
        fitnessData.registerObserver(display);
        fitnessData.registerObserver(logger);
        fitnessData.registerObserver(notifier);

        fitnessData.newFitnessDataPushed(500, 5, 20);
        fitnessData.newFitnessDataPushed(9800, 85, 350);
        fitnessData.newFitnessDataPushed(10100, 90, 380);

        //Remove logger
        fitnessData.registerObserver(logger);
        notifier.reset();
        fitnessData.dailyReset();
    }
}
