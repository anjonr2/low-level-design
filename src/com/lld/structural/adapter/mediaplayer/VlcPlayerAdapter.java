package com.lld.structural.adapter.mediaplayer;

public class VlcPlayerAdapter implements MediaPlayer{
    private final VlcCodec vlcCodec;

    public VlcPlayerAdapter(VlcCodec vlcCodec){
        this.vlcCodec = vlcCodec;
    }

    @Override
    public void play(String fileName) {
        vlcCodec.playVlc(fileName);
    }
}
