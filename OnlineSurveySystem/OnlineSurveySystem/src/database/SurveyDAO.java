package database;


import model.Question;
import model.Survey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SurveyDAO {
    private final DatabaseManager databaseManager;

    public SurveyDAO(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public boolean createSurvey(Survey survey) {
        String insertSurveyQuery = "INSERT INTO surveys (name) VALUES (?)";

        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertSurveyQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {

            // Set parameters for the insert query
            statement.setString(1, survey.getName());

            // Execute the insert query
            int rowsInserted = statement.executeUpdate();

            // Check if the insert was successful
            if (rowsInserted > 0) {
                // Get the generated survey ID
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    int surveyId = resultSet.getInt(1);
                    // Insert questions associated with the survey
                    for (Question question : survey.getQuestions()) {
                        createQuestion(question, surveyId, connection);
                    }
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void createQuestion(Question question, int surveyId, Connection connection) throws SQLException {
        String insertQuestionQuery = "INSERT INTO questions (survey_id, text, type) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(insertQuestionQuery)) {
            // Set parameters for the insert query
            statement.setInt(1, surveyId);
            statement.setString(2, question.getText());
            statement.setString(3, question.getType().toString());

            // Execute the insert query
            statement.executeUpdate();
        }
    }

    // Add methods for retrieving, updating, and deleting surveys as needed
}
