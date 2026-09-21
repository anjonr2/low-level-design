package com.lld.structural.adapter.mediaplayer;

public class Mp4PlayerAdapter implements MediaPlayer{
    private final Mp4Codec mp4Codec;

    public Mp4PlayerAdapter(Mp4Codec mp4Codec){
        this.mp4Codec = mp4Codec;
    }

    @Override
    public void play(String fileName) {
        mp4Codec.playMp4(fileName);
    }
}
