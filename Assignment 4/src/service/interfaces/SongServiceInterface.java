package service.interfaces;

import model.Song;
import java.util.List;

public interface SongServiceInterface {
    void addSong(Song song);
    Song getSongById(int id);
    List<Song> getAllSongs();
    void updateSong(Song song);
    void deleteSong(int id);
}