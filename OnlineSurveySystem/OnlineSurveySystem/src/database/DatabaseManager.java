package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String DATABASE_URL = "C:\\Users\\HP\\IdeaProjects\\Online Survey System\\Database.db";
    private Connection connection;

    public DatabaseManager() {
        try {
            // Load SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");
            // Connect to the database
            connection = DriverManager.getConnection(DATABASE_URL);
            System.out.println("Connected to SQLite database.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Closed connection to SQLite database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
