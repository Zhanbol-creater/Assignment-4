package model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private int id;
    private String name;
    private List<MediaBase> mediaList;

    public Playlist(int id, String name) {
        this.id = id;
        this.name = name;
        this.mediaList = new ArrayList<>();
    }

    public void addMedia(MediaBase media) {
        mediaList.add(media);
    }

    public void removeMedia(MediaBase media) {
        mediaList.remove(media);
    }

    public void playAll() {
        System.out.println("Playing playlist: " + name);
        for (MediaBase media : mediaList) {
            media.play();
        }
    }

    public List<MediaBase> getMediaList() { return mediaList; }
    public int getId() { return id; }
    public String getName() { return name; }
}