package com.lld.behavioral.iterator.musicstreamingapp.withoutiteratorpattern;

public class MusicPlayer{
    public void playAll(Playlist playlist){
        for (String song : playlist.getSongs()){
            System.out.println("Playing song: "+song);
        }
    }
}

/**
 * this looks clean enough
 * The player gets the list of songs
 * and iterates through them
 *
 * But why this becomes a problem?
 *As the application grows, several issues emerge :
 *
 * Breaks Encapsulation :
 *
 * By returning internal list, you allow clients to do more than just read. They can
 * add songs, remove songs, clear the list or even replace it entirely.
 * Nothing prevents a client from calling playlist.getSongs().clear() and wiping
 * out the entire playlist
 *
 * 2.Tightly couples Client to implementation
 *
 * Your player assumes the playlist uses a list. What if you decide to change the internal
 * structure? Perhaps you want to store songs in a database and load them lazily.Or may be
 * you want to use a set to prevent duplicates
 *
 * Every change to internal structure ripples through all client code
 *
 * 3. Limited traversal options
 *
 * What if you need to play songs in reverse order? Or shuffle them? or skip songs
 * that user has marked as disliked?
 *
 * Each of these requires writing new loop logic in the client. The playlist has no
 * control over how its contents are accessed
 *
 * What we really need
 *
 * We need a way for clients to traverse the playlist that:
 *
 * Does not expose the internal data structure
 * Provides a consistent interface regardless of how songs are stored
 * Allows the playlist to control how iteration happens
 * Supports different traversal strategies without modifying client code
 */