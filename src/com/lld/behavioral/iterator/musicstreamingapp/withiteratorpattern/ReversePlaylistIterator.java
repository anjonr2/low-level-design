package com.lld.behavioral.iterator.musicstreamingapp.withiteratorpattern;

public class ReversePlaylistIterator implements Iterator<String>{
    private final Playlist playlist;
    private int index;

    public ReversePlaylistIterator(Playlist playlist){
        this.playlist = playlist;
        this.index = playlist.getSize() - 1;
    }
    @Override
    public boolean hasNext() {
        return index>=0;
    }

    @Override
    public String next() {
        return playlist.getSongAt(index--);
    }
}
