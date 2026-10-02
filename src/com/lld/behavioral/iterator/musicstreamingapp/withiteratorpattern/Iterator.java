package com.lld.behavioral.iterator.musicstreamingapp.withiteratorpattern;

/**
 * The interface is generic, allowing it work
 * with any element type. Two methods are sufficient
 * for basic iteration
 * @param <T>
 */
public interface Iterator <T>{
    boolean hasNext();
    T next();
}
