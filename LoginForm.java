import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {
    // Components of the Form
    private Container container;
    private JLabel userLabel;
    private JTextField userTextField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel resultLabel;

    // Constructor to setup the GUI components and event handling
    public LoginForm() {
        setTitle("Login Form");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the frame on the screen
        setLocationRelativeTo(null);

        container = getContentPane();
        container.setLayout(null);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 30, 100, 30);
        container.add(userLabel);

        userTextField = new JTextField();
        userTextField.setBounds(150, 30, 150, 30);
        container.add(userTextField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 70, 100, 30);
        container.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 30);
        container.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 110, 100, 30);
        loginButton.addActionListener(this);
        container.add(loginButton);

        resultLabel = new JLabel("");
        resultLabel.setBounds(50, 150, 300, 30);
        container.add(resultLabel);

        setVisible(true);
    }

    // Method to handle login button click event
    @Override
    public void actionPerformed(ActionEvent e) {
        String userText = userTextField.getText();
        String passwordText = new String(passwordField.getPassword());

        // Check if username and password are correct
        if (userText.equals("admin") && passwordText.equals("password123")) {
            resultLabel.setText("Login successful!");
        } else {
            resultLabel.setText("Invalid username or password.");
        }
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}