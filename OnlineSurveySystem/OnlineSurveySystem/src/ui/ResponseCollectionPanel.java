package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResponseCollectionPanel extends JPanel {
    private JTextField nameTextField;
    private JButton submitButton;

    public ResponseCollectionPanel() {
        setLayout(new GridLayout(2, 1));

        JLabel nameLabel = new JLabel("Your Name:");
        nameTextField = new JTextField();

        submitButton = new JButton("Submit");

        add(nameLabel);
        add(nameTextField);
        add(submitButton);

        // Action listener for submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to handle submission of response
            }
        });
    }
}

