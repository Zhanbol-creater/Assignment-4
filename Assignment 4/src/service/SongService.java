package service;

import exception.InvalidInputException;
import exception.ResourceNotFoundException;
import model.Song;
import repository.interfaces.CrudRepository;
import service.interfaces.SongServiceInterface;

import java.util.List;

public class SongService implements SongServiceInterface {
    private final CrudRepository<Song> repository;

    public SongService(CrudRepository<Song> repository) {
        this.repository = repository;
    }

    @Override
    public void addSong(Song song) {
        try {
            song.validate();
            repository.save(song);
        } catch (IllegalArgumentException e) {
            throw new InvalidInputException("Invalid song data: " + e.getMessage());
        }
    }

    @Override
    public Song getSongById(int id) {
        Song song = repository.findById(id);
        if (song == null) {
            throw new ResourceNotFoundException("Song not found with id: " + id);
        }
        return song;
    }

    @Override
    public List<Song> getAllSongs() {
        return repository.findAll();
    }

    @Override
    public void updateSong(Song song) {
        repository.update(song);
    }

    @Override
    public void deleteSong(int id) {
        repository.delete(id);
    }
}
