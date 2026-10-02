Imagine you have a home theater with multiple components 
1. An amplifier
2. a DVD player
3. a projector
4. a streaming service
5. smart lights

Watching a movie requires turning on the projector
dimming the lights
powering up the amplifier
Setting the volume
Starting the movie

That is five subsystems with specific sequencing requirements

Without a facade, every part of my smart hometheater app that wants to play
a movie ( a remote control app, a voice assistant integration, a scheduled movie night feature)
needs to know all those steps
A home theater app wraps them into watchMovie() and endMovie()