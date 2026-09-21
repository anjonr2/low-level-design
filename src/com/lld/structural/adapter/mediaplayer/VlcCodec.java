package com.lld.structural.adapter.mediaplayer;

/**
 * External codec libraries (Adaptees)
 */
public class VlcCodec {
    public void playVlc(String fileName){
        System.out.println("VLC Codec: Decoding and playing "+ fileName);
    }
}
