package com.lld.structural.adapter.mediaplayer;

public class Mp3Player implements MediaPlayer{
    @Override
    public void play(String fileName) {
        System.out.println("MP3 Player: Playing "+ fileName);
    }
}
