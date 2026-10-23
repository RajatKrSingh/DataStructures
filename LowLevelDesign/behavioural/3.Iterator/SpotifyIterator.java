package behavioural.iterator.iterator;

import behavioural.iterator.song.*;
import java.util.*;

public class SpotifyIterator implements Iterator
{
    private List<Song> song_list;
    private int current_index;
    public SpotifyIterator()
    {
        song_list = new ArrayList<>();
        current_index = 0;
    }

    public void addSong(Song song)
    {
        song_list.add(song);
    }

    @Override
    public boolean hasNext()
    {
        return current_index < song_list.size();
    }

    @Override
    public void getNext()
    {
        if(!this.hasNext())
        {
            System.out.println("No song available");
            return;
        }
        Song next_song =  song_list.get(current_index++);
        System.out.println("Spotify Next song returned: "+ next_song.name);
    }
}