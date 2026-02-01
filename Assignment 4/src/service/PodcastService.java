package service;

import exception.InvalidInputException;
import exception.ResourceNotFoundException;
import model.Podcast;
import repository.interfaces.CrudRepository;

import java.util.List;

public class PodcastService {
    private final CrudRepository<Podcast> repository;

    public PodcastService(CrudRepository<Podcast> repository) {
        this.repository = repository;
    }

    public void addPodcast(Podcast podcast) {
        try {
            podcast.validate();
            repository.save(podcast);
        } catch (IllegalArgumentException e) {
            throw new InvalidInputException("Invalid podcast data: " + e.getMessage());
        }
    }

    public Podcast getPodcastById(int id) {
        Podcast podcast = repository.findById(id);
        if (podcast == null) {
            throw new ResourceNotFoundException("Podcast not found with id: " + id);
        }
        return podcast;
    }

    public List<Podcast> getAllPodcasts() {
        return repository.findAll();
    }

    public void updatePodcast(Podcast podcast) {
        repository.update(podcast);
    }

    public void deletePodcast(int id) {
        repository.delete(id);
    }
}