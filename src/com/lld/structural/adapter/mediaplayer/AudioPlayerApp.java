package com.lld.structural.adapter.mediaplayer;

//Client
public class AudioPlayerApp {
    public void playFile(String fileName){
            MediaPlayer mediaPlayer;
            String extension = fileName.substring(fileName.lastIndexOf('.')+1).toLowerCase();

            switch (extension){
                case "mp3" :
                    mediaPlayer = new Mp3Player();
                    break;
                case "vlc" :
                    mediaPlayer = new VlcPlayerAdapter(new VlcCodec());
                    break;
                case "mp4" :
                    mediaPlayer = new Mp4PlayerAdapter(new Mp4Codec());
                    break;
                default:
                    System.out.println("Unsupported format: "+ extension);
                    return;
            }

            mediaPlayer.play(fileName);
    }
}
