import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        // Establish database connection
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:path_to_your_database_file.db");
            System.out.println("Connected to the database.");

            // Call methods to perform database operations
            createSurveyTable(connection);
            createQuestionTable(connection);
            createResponseTable(connection);
            createUserTable(connection);

            // Other application logic
            // ...
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        } finally {
            // Close the database connection
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Disconnected from the database.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Methods to create database tables
    private static void createSurveyTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Survey (" +
                "id INTEGER PRIMARY KEY," +
                "title TEXT);";
        connection.createStatement().executeUpdate(createTableSQL);
    }

    private static void createQuestionTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Question (" +
                "id INTEGER PRIMARY KEY," +
                "survey_id INTEGER," +
                "text TEXT," +
                "FOREIGN KEY (survey_id) REFERENCES Survey(id));";
        connection.createStatement().executeUpdate(createTableSQL);
    }

    private static void createResponseTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Response (" +
                "id INTEGER PRIMARY KEY," +
                "survey_id INTEGER," +
                "question_id INTEGER," +
                "user_id INTEGER," +
                "answer TEXT," +
                "FOREIGN KEY (survey_id) REFERENCES Survey(id)," +
                "FOREIGN KEY (question_id) REFERENCES Question(id)," +
                "FOREIGN KEY (user_id) REFERENCES User(id));";
        connection.createStatement().executeUpdate(createTableSQL);
    }

    private static void createUserTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS User (" +
                "id INTEGER PRIMARY KEY," +
                "username TEXT," +
                "password TEXT);";
        connection.createStatement().executeUpdate(createTableSQL);
    }
}
