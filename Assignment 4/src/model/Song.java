package model;

public class Song extends MediaBase {
    private String artist;
    private String genre;

    public Song(int id, String name, double duration, String artist, String genre) {
        super(id, name, duration);
        this.artist = artist;
        this.genre = genre;
    }

    @Override
    public void play() {
        System.out.println("Playing song: " + getName() + " by " + artist);
    }

    @Override
    public void validate() {
        if (artist == null || artist.isEmpty()) {
            throw new IllegalArgumentException("Artist cannot be empty");
        }
        if (genre == null || genre.isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be empty");
        }
    }

    public String getArtist() { return artist; }
    public String getGenre() { return genre; }
}