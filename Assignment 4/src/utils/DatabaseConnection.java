package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/music_library";
    private static final String USER = "postgres";   // өзіңнің PostgreSQL user енгіз
    private static final String PASSWORD = "0000";  // өзіңнің пароль енгіз

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to database", e);
        }
    }
}