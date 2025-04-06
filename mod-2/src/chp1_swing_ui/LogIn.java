package chp1_swing_ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
	
    JLabel userLabel, passLabel;
    JTextField userText;
    JPasswordField passText;
    JButton loginButton;

    public Login() {
        setTitle("Login Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        userLabel = new JLabel("Username:");
        passLabel = new JLabel("Password:");
        userText = new JTextField();
        passText = new JPasswordField();
        loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticate();
            }
        });

        add(userLabel);
        add(userText);
        add(passLabel);
        add(passText);
        add(loginButton);
    }

    private void authenticate() {
        String username = userText.getText();
        String password = new String(passText.getPassword());

        if ("SDAC".equals(username) && "SDAC".equals(password)) {
            JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            new Dashboard(); // Open the dashboard after successful login
            dispose(); // Close the login window
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Credentials!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
    	
        SwingUtilities.invokeLater(() -> {
            Login loginForm = new Login();
            loginForm.setVisible(true);
        });
    }
}

class Dashboard extends JFrame {
	
    public Dashboard() {
        setTitle("Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel welcomeLabel = new JLabel("Welcome to the Dashboard!");
        add(welcomeLabel);

        setVisible(true);
        
    }
}
