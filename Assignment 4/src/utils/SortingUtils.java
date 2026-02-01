package utils;

import model.Song;
import model.Podcast;

import java.util.Comparator;
import java.util.List;

public class SortingUtils {

    public static void sortSongsByTitle(List<Song> songs) {
        songs.sort(Comparator.comparing(Song::getName));
    }

    public static void sortSongsByArtist(List<Song> songs) {
        songs.sort(Comparator.comparing(Song::getArtist));
    }

    public static void sortPodcastsByHost(List<Podcast> podcasts) {
        podcasts.sort(Comparator.comparing(Podcast::getHost));
    }

    public static void sortPodcastsByEpisode(List<Podcast> podcasts) {
        podcasts.sort(Comparator.comparingInt(Podcast::getEpisodeNumber));
    }
}