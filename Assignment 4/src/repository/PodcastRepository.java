package repository;

import model.Podcast;
import repository.interfaces.CrudRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PodcastRepository implements CrudRepository<Podcast> {
    private final Connection connection;

    public PodcastRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Podcast podcast) {
        String sql = "INSERT INTO podcasts (title, duration, host, episode_number) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, podcast.getName());
            stmt.setDouble(2, podcast.getDuration());
            stmt.setString(3, podcast.getHost());
            stmt.setInt(4, podcast.getEpisodeNumber());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error saving podcast", e);
        }
    }

    @Override
    public Podcast findById(int id) {
        String sql = "SELECT * FROM podcasts WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Podcast(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getDouble("duration"),
                        rs.getString("host"),
                        rs.getInt("episode_number")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding podcast", e);
        }
        return null;
    }

    @Override
    public List<Podcast> findAll() {
        List<Podcast> podcasts = new ArrayList<>();
        String sql = "SELECT * FROM podcasts";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                podcasts.add(new Podcast(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getDouble("duration"),
                        rs.getString("host"),
                        rs.getInt("episode_number")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching podcasts", e);
        }
        return podcasts;
    }

    @Override
    public void update(Podcast podcast) {
        String sql = "UPDATE podcasts SET title=?, duration=?, host=?, episode_number=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, podcast.getName());
            stmt.setDouble(2, podcast.getDuration());
            stmt.setString(3, podcast.getHost());
            stmt.setInt(4, podcast.getEpisodeNumber());
            stmt.setInt(5, podcast.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating podcast", e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM podcasts WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting podcast", e);
        }
    }
}