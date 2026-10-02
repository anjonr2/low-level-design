package com.lld.behavioral.iterator.musicstreamingapp.withiteratorpattern;

/**
 * This interface ensures that any collection can
 * provide an iterator
 * Any class implementing this interface
 * promises to provide an iterator for traversing
 * its elements
 * @param <T>
 */
public interface IterableCollection <T>{
    Iterator<T> createIterator();
}
