package com.lld.behavioral.iterator.observer.fitnesstrackerapp.withpattern;

/**
 * The subject interface provides methods for managing observers :
 * registering, removing and notifying them
 */
public interface FitnessDataSubject {
    void registerObserver(FitnessDataObserver observer);

    void removeObserver(FitnessDataObserver observer);

    void notifyObservers();
}
