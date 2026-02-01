import controller.MainController;
import repository.SongRepository;
import repository.PodcastRepository;
import repository.PlaylistRepository;
import service.SongService;
import service.PodcastService;
import service.PlaylistService;
import utils.DatabaseConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();

        SongRepository songRepo = new SongRepository(connection);
        PodcastRepository podcastRepo = new PodcastRepository(connection);
        PlaylistRepository playlistRepo = new PlaylistRepository(connection);

        SongService songService = new SongService(songRepo);
        PodcastService podcastService = new PodcastService(podcastRepo);
        PlaylistService playlistService = new PlaylistService(playlistRepo);

        MainController controller = new MainController(songService, podcastService, playlistService);
        controller.start();
    }
}