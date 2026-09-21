package com.lld.structural.adapter.mediaplayer;

public class MediaPlayerDemo {
    public static void main(String [] args){
        AudioPlayerApp player = new AudioPlayerApp();
        player.playFile("song.mp3");
        player.playFile("movie.mp4");
        player.playFile("documentary.vlc");
        player.playFile("image.png");
    }
}
