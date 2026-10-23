package behavioural.iterator.iterator;

import behavioural.iterator.song.Song;

public interface Iterator
{
    public void addSong(Song song);
    public boolean hasNext();
    public void getNext();
}