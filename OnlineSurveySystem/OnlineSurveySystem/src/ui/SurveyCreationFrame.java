package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SurveyCreationFrame extends JFrame {
    private JPanel mainPanel;
    private JTextField surveyNameTextField;
    private JButton addQuestionButton;
    private JButton saveSurveyButton;

    public SurveyCreationFrame() {
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

        // Action listeners for buttons
        addQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to handle adding questions
                // This can open a new window or dialog for adding questions
            }
        });

        saveSurveyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to save survey
            }
        });
    }
}
