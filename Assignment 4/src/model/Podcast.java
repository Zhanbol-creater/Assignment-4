

package model;

public class Podcast extends MediaBase {
    private String host;
    private int episodeNumber;

    public Podcast(int id, String name, double duration, String host, int episodeNumber) {
        super(id, name, duration);
        this.host = host;
        this.episodeNumber = episodeNumber;
    }

    @Override
    public void play() {
        System.out.println("Playing podcast: " + getName() + " hosted by " + host);
    }

    @Override
    public void validate() {
        if (host == null || host.isEmpty()) {
            throw new IllegalArgumentException("Host cannot be empty");
        }
        if (episodeNumber <= 0) {
            throw new IllegalArgumentException("Episode number must be positive");
        }
    }

    public String getHost() { return host; }
    public int getEpisodeNumber() { return episodeNumber; }
}