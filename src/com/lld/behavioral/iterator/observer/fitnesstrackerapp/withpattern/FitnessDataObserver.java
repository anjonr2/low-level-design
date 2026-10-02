package com.lld.behavioral.iterator.observer.fitnesstrackerapp.withpattern;

/**
 * Define the Observer interface
 */
public interface FitnessDataObserver {
    void update(FitnessData data);
}

/**
 * Each observer receives a reference to the subject and can pull
 * whatever data it needs. This keeps the interface stable as FitnessData
 * gains new fields
 */