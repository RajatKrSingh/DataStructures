package behavioural.iterator.runner;

import behavioural.iterator.iterator.*;
import behavioural.iterator.song.Song;

public class Runner
{
    public static void main(String args[])
    {
        Iterator song_iterator = new SpotifyIterator();
        populateSongs(song_iterator);
        song_iterator.getNext();
        song_iterator.getNext();
        song_iterator.getNext();
        song_iterator.getNext();

        song_iterator = new YTMusicIterator();
        populateSongs(song_iterator);
        song_iterator.getNext();
        song_iterator.getNext();
        song_iterator.getNext();
        song_iterator.getNext();
    }

    public static void populateSongs(Iterator song_iterator)
    {
        String[] song_name_list = {"Song 1", "Song 2", "Song 3"};
        for(String song_name : song_name_list)
            song_iterator.addSong(new Song(song_name));
    }
}