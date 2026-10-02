package com.lld.behavioral.iterator.musicstreamingapp.withiteratorpattern;

/**
 * Client code
 */
public class MusicPlayerApp {
    public static void main(String [] args){
        Playlist playlist = new Playlist();
        playlist.addSong("Song 1");
        playlist.addSong("Song 2");
        playlist.addSong("Song 3");

        Iterator<String> iterator = playlist.createIterator();

        System.out.println("Now playing: ");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

/**
 * Client code is clean and focused
 * It does not know or care whether the playlist uses an ArrayList, LinkedList or any
 * other structure internally
 *
 * What we gained
 *
 * Encapsulation is Preserved
 *
 * The internal list is no longer exposed. Clients cannot accidentally or intentionally
 * modify the playlist's contents through the iterator. The playlist maintains full control
 * over its data
 *
 * Implementation independence
 *
 * The client code works with the iterator interface. If we later change the playlist
 * to use a linked list, a database or a streaming buffer, the client code remains
 * unchanged.We only need to update the iterator implementation
 *
 * Single Responsibility Principle
 *
 * The playlist class focuses on managing songs. The playlist iterator class
 * focuses on traversal logic. Each class has one reason to change
 *
 * Foundation for extensions
 *
 * We can now easily add new types of iterators (reverse, filtered) without modifying the Playlist
 * class or existing code
 *
 * One of the most powerful aspects of the iterator pattern is how easily you can
 * add new traversal behaviors without modifying the collection or client code
 *
 * Suppose tomorrow product team wants new features :
 * play songs in reverse order
 */
