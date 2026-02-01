package controller;

import model.Song;
import model.Podcast;
import model.Playlist;
import service.SongService;
import service.PodcastService;
import service.PlaylistService;

import java.util.List;
import java.util.Scanner;

public class MainController {
    private final SongService songService;
    private final PodcastService podcastService;
    private final PlaylistService playlistService;
    private final Scanner scanner;

    public MainController(SongService songService, PodcastService podcastService, PlaylistService playlistService) {
        this.songService = songService;
        this.podcastService = podcastService;
        this.playlistService = playlistService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n=== Music Library Menu ===");
            System.out.println("1. Add Song");
            System.out.println("2. List Songs");
            System.out.println("3. Add Podcast");
            System.out.println("4. List Podcasts");
            System.out.println("5. Create Playlist");
            System.out.println("6. List Playlists");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addSong();
                case 2 -> listSongs();
                case 3 -> addPodcast();
                case 4 -> listPodcasts();
                case 5 -> createPlaylist();
                case 6 -> listPlaylists();
                case 7 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void addSong() {
        System.out.print("Enter song title: ");
        String title = scanner.nextLine();
        System.out.print("Enter duration: ");
        double duration = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter artist: ");
        String artist = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();

        Song song = new Song(0, title, duration, artist, genre);
        songService.addSong(song);
        System.out.println("Song added successfully!");
    }

    private void listSongs() {
        List<Song> songs = songService.getAllSongs();
        System.out.println("=== Songs ===");
        for (Song s : songs) {
            System.out.println(s.getInfo() + " | Artist: " + s.getArtist() + " | Genre: " + s.getGenre());
        }
    }

    private void addPodcast() {
        System.out.print("Enter podcast title: ");
        String title = scanner.nextLine();
        System.out.print("Enter duration: ");
        double duration = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter host: ");
        String host = scanner.nextLine();
        System.out.print("Enter episode number: ");
        int episode = scanner.nextInt();
        scanner.nextLine();

        Podcast podcast = new Podcast(0, title, duration, host, episode);
        podcastService.addPodcast(podcast);
        System.out.println("Podcast added successfully!");
    }

    private void listPodcasts() {
        List<Podcast> podcasts = podcastService.getAllPodcasts();
        System.out.println("=== Podcasts ===");
        for (Podcast p : podcasts) {
            System.out.println(p.getInfo() + " | Host: " + p.getHost() + " | Episode: " + p.getEpisodeNumber());
        }
    }

    private void createPlaylist() {
        System.out.print("Enter playlist name: ");
        String name = scanner.nextLine();
        Playlist playlist = new Playlist(0, name);
        playlistService.addPlaylist(playlist);
        System.out.println("Playlist created successfully!");
    }

    private void listPlaylists() {
        List<Playlist> playlists = playlistService.getAllPlaylists();
        System.out.println("=== Playlists ===");
        for (Playlist pl : playlists) {
            System.out.println(pl.getName());
        }
    }
}