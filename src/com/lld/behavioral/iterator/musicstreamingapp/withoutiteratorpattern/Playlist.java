package com.lld.behavioral.iterator.musicstreamingapp.withoutiteratorpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * first implementation might look like this
 */
public class Playlist {
    private List<String> songs = new ArrayList<>();

    public void addSong(String song){
        songs.add(song);
    }

    public List<String> getSongs(){
        return songs;
    }
}
