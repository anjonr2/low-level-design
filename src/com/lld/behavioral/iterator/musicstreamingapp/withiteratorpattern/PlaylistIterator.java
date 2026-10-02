package com.lld.behavioral.iterator.musicstreamingapp.withiteratorpattern;

/**
 * Iterator maintains its position and knows how to traverse the playlist
 */
public class PlaylistIterator implements Iterator<String>{

    private final Playlist playlist;
    private int index = 0;

    public PlaylistIterator(Playlist playlist){
        this.playlist = playlist;
    }

    @Override
    public boolean hasNext() {
        return index < playlist.getSize();
    }

    @Override
    public String next() {
        return playlist.getSongAt(index++);
    }
}

/**
 * The iterator is simple by design
 *
 * It holds a reference to the playlist and an index that starts at zero. Each call
 * to the next() returns the current song and advances the index.
 * Each call to hasNext() checks whether the index has reached the end
 *
 */