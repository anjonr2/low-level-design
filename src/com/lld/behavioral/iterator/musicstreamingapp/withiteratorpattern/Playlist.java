package com.lld.behavioral.iterator.musicstreamingapp.withiteratorpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Playlist is the concrete collection implementation
 * It will no longer expose its internal list . Instead
 * it provides controlled access methods that the iterator will use
 */
public class Playlist implements IterableCollection<String>{
    private final List<String> songs = new ArrayList<>();

    public void addSong(String song){
        songs.add(song);
    }

    public String getSongAt(int index){
        return songs.get(index);
    }

    public int getSize(){
        return songs.size();
    }

    @Override
    public Iterator<String> createIterator() {
        return new PlaylistIterator(this);
    }
}

/**
 * The key change : getSongs() is gone. Clients cannot get the
 * raw list anymore. Instead getSongsAt() and getSize() provide the minimum
 * access the iterator needs, while keeping the internal structure private
 */