package service;

import exception.ResourceNotFoundException;
import model.Playlist;
import repository.interfaces.CrudRepository;

import java.util.List;

public class PlaylistService {
    private final CrudRepository<Playlist> repository;

    public PlaylistService(CrudRepository<Playlist> repository) {
        this.repository = repository;
    }

    public void addPlaylist(Playlist playlist) {
        repository.save(playlist);
    }

    public Playlist getPlaylistById(int id) {
        Playlist playlist = repository.findById(id);
        if (playlist == null) {
            throw new ResourceNotFoundException("Playlist not found with id: " + id);
        }
        return playlist;
    }

    public List<Playlist> getAllPlaylists() {
        return repository.findAll();
    }

    public void updatePlaylist(Playlist playlist) {
        repository.update(playlist);
    }

    public void deletePlaylist(int id) {
        repository.delete(id);
    }
}