package com.chetan.petDetails.UI;

import com.chetan.petDetails.ejb.User;
import com.chetan.petDetails.service.UserService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private final UserService service;

    public LoginForm(final UserService service) {
        super("Login Form");
        this.service = service;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Username"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        panel.add(new JPanel());
        loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            User user = service.login(username, password);
            if (null != user) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                // TODO: navigate to main form
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        });
        panel.add(loginButton);
        setContentPane(panel);
        pack();
        setVisible(true);
    }
}

