package utils;

import model.Song;
import model.Podcast;

public class ValidatorUtils {

    public static boolean validateSong(Song song) {
        return song.getArtist() != null && !song.getArtist().isEmpty()
                && song.getGenre() != null && !song.getGenre().isEmpty()
                && song.getDuration() > 0;
    }

    public static boolean validatePodcast(Podcast podcast) {
        return podcast.getHost() != null && !podcast.getHost().isEmpty()
                && podcast.getEpisodeNumber() > 0
                && podcast.getDuration() > 0;
    }
}