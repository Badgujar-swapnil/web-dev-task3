package ui;


import database.DatabaseManager;
import database.SurveyDAO;
import model.Question;
import model.QuestionType;
import model.Survey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SurveyCreation extends JFrame {
    private JPanel mainPanel;
    private JTextField surveyNameTextField;
    private JButton addQuestionButton;
    private JButton saveSurveyButton;
    private List<Question> questions;

    public SurveyCreation() {
        setTitle("Survey Creation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 200));

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));

        JLabel surveyNameLabel = new JLabel("Survey Name:");
        surveyNameTextField = new JTextField();

        addQuestionButton = new JButton("Add Question");
        saveSurveyButton = new JButton("Save Survey");

        mainPanel.add(surveyNameLabel);
        mainPanel.add(surveyNameTextField);
        mainPanel.add(addQuestionButton);
        mainPanel.add(saveSurveyButton);

        add(mainPanel);
        pack();
        setVisible(true);

        questions = new ArrayList<>();

        // Action listeners for buttons
        addQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open dialog to add question
                String text = JOptionPane.showInputDialog("Enter question text:");
                if (text != null && !text.isEmpty()) {
                    QuestionType type = (QuestionType) JOptionPane.showInputDialog(
                            SurveyCreation.this,
                            "Select question type:",
                            "Question Type",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            QuestionType.values(),
                            QuestionType.MULTIPLE_CHOICE);

                    if (type != null) {
                        Question question = new Question(text, type);
                        questions.add(question);
                        JOptionPane.showMessageDialog(SurveyCreation.this, "Question added successfully!");
                    } else {
                        JOptionPane.showMessageDialog(SurveyCreation.this, "Question type not selected!");
                    }
                } else {
                    JOptionPane.showMessageDialog(SurveyCreation.this, "Question text cannot be empty!");
                }
            }
        });

        saveSurveyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String surveyName = surveyNameTextField.getText();
                if (surveyName.isEmpty()) {
                    JOptionPane.showMessageDialog(SurveyCreation.this, "Survey name cannot be empty!");
                    return;
                }

                Survey survey = new Survey(surveyName);
                survey.setQuestions(questions);

                DatabaseManager databaseManager = new DatabaseManager();
                SurveyDAO surveyDAO = new SurveyDAO(databaseManager);
                boolean success = surveyDAO.createSurvey(survey);
                if (success) {
                    JOptionPane.showMessageDialog(SurveyCreation.this, "Survey created successfully!");
                } else {
                    JOptionPane.showMessageDialog(SurveyCreation.this, "Failed to create survey!");
                }
                databaseManager.closeConnection();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SurveyCreation();
            }
        });
    }
}
