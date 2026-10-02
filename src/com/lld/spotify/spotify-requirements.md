Functional requirements : 
1. User can play, pause songs
2. User can create playlists, add songs to playlists
3. Play entire playlists sequential or in random manner or individual songs or user should be able to create a custom playlist by adding songs to a queue
4. App should support multiple output devices(Bluetooth speakers, wired speakers, headphones etc..)

Non functional requirements :
Entire design should be easily scalable
New features (new output device, new way to play songs from playlist) should be easily added without modifying/altering the existing code

In bottom up approach 
1. we first make small objects
2. then integrate those small objects together to form bigger objects

Song is the important object in musicplayer application. It should have the following attributes:
1. String name
2. String artist
3. String path (where the song will be stored)

and songs can have getters and setters

1. feature:A user should be able to  Play, Pause, Stop, Seek, Shuffle, Repeat the song or playlist
to implement this we have to create an output device object or interface

interface IAudioOutputDevice{
    playAudio(Song song);
}