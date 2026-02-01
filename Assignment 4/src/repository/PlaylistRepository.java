package repository;

import model.Playlist;
import repository.interfaces.CrudRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistRepository implements CrudRepository<Playlist> {
    private final Connection connection;

    public PlaylistRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Playlist playlist) {
        String sql = "INSERT INTO playlists (name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, playlist.getName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error saving playlist", e);
        }
    }

    @Override
    public Playlist findById(int id) {
        String sql = "SELECT * FROM playlists WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Playlist(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding playlist", e);
        }
        return null;
    }

    @Override
    public List<Playlist> findAll() {
        List<Playlist> playlists = new ArrayList<>();
        String sql = "SELECT * FROM playlists";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                playlists.add(new Playlist(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching playlists", e);
        }
        return playlists;
    }

    @Override
    public void update(Playlist playlist) {
        String sql = "UPDATE playlists SET name=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, playlist.getName());
            stmt.setInt(2, playlist.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating playlist", e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM playlists WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting playlist", e);
        }
    }
}