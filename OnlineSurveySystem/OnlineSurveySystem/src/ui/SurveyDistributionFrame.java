package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SurveyDistributionFrame extends JFrame {
    private JPanel mainPanel;
    private JTextField emailTextField;
    private JButton sendEmailButton;
    private JButton distributeWebButton;

    public SurveyDistributionFrame() {
        setTitle("Survey Distribution");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 200));

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));

        JLabel emailLabel = new JLabel("Recipient's Email:");
        emailTextField = new JTextField();

        sendEmailButton = new JButton("Send Email");
        distributeWebButton = new JButton("Distribute via Web");

        mainPanel.add(emailLabel);
        mainPanel.add(emailTextField);
        mainPanel.add(sendEmailButton);
        mainPanel.add(distributeWebButton);

        add(mainPanel);
        pack();
        setVisible(true);

        // Action listeners for buttons
        sendEmailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to send email
            }
        });

        distributeWebButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to distribute via web
            }
        });
    }
}
