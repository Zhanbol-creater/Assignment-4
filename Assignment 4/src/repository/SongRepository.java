package repository;

import model.Song;
import repository.interfaces.CrudRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongRepository implements CrudRepository<Song> {
    private final Connection connection;

    public SongRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Song song) {
        String sql = "INSERT INTO songs (title, duration, artist, genre) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, song.getName());
            stmt.setDouble(2, song.getDuration());
            stmt.setString(3, song.getArtist());
            stmt.setString(4, song.getGenre());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error saving song", e);
        }
    }

    @Override
    public Song findById(int id) {
        String sql = "SELECT * FROM songs WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Song(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getDouble("duration"),
                        rs.getString("artist"),
                        rs.getString("genre")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding song", e);
        }
        return null;
    }

    @Override
    public List<Song> findAll() {
        List<Song> songs = new ArrayList<>();
        String sql = "SELECT * FROM songs";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                songs.add(new Song(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getDouble("duration"),
                        rs.getString("artist"),
                        rs.getString("genre")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching songs", e);
        }
        return songs;
    }

    @Override
    public void update(Song song) {
        String sql = "UPDATE songs SET title=?, duration=?, artist=?, genre=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, song.getName());
            stmt.setDouble(2, song.getDuration());
            stmt.setString(3, song.getArtist());
            stmt.setString(4, song.getGenre());
            stmt.setInt(5, song.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating song", e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM songs WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting song", e);
        }
    }
}