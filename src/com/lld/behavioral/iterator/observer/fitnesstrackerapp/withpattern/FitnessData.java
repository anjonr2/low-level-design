package com.lld.behavioral.iterator.observer.fitnesstrackerapp.withpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * FitnessData implements the subject interface. It manages
 * the observer list and calls notifyObservers() automatically
 * whenever new data arrives
 */
public class FitnessData implements FitnessDataSubject{
    private int steps;
    private int activeMinutes;
    private int calories;

    private final List<FitnessDataObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(FitnessDataObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(FitnessDataObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(FitnessDataObserver observer : observers){
            observer.update(this);
        }
    }

    public void newFitnessDataPushed(int steps, int activeMinutes, int calories){
        this.steps = steps;
        this.activeMinutes = activeMinutes;
        this.calories = calories;

        System.out.println("\nFitnessData: New Data received - Steps: " + steps
            + ", Active Minutes: "+ activeMinutes + ", Calories: "+ calories);

        notifyObservers();
    }

    public void dailyReset(){
        this.steps = 0;
        this.activeMinutes = 0;
        this.calories = 0;

        System.out.println("\nFitnessData: Daily reset performed. ");
        notifyObservers();
    }

    public int getSteps() {
        return steps;
    }

    public int getActiveMinutes() {
        return activeMinutes;
    }

    public int getCalories() {
        return calories;
    }
}

/**
 * Notice : FitnessData no longer imports, creates or references any concrete observer
 *It just maintains a list of FitnessDataObserver references and iterates through them
 * The class has gone from knowing about three specific modules to knowing about zero
 */