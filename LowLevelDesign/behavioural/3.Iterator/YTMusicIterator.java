package behavioural.iterator.iterator;

import behavioural.iterator.song.*;
import java.util.*;

public class YTMusicIterator implements Iterator
{
    private List<Song> song_list;
    private int current_index;

    public YTMusicIterator()
    {
        song_list = new ArrayList<>();
        current_index = -1;
    }

    public void addSong(Song song)
    {
        song_list.add(song);
        current_index++;
    }

    @Override
    public boolean hasNext()
    {
        return current_index>-1;
    }

    public void getNext()
    {
        if(!this.hasNext())
        {
            System.out.println("No song available");
            return;
        }
        Song next_song = song_list.get(current_index--);
        System.out.println("YTMusic Next song returned: "+ next_song.name);
    }
}