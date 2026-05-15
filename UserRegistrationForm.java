import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegistrationForm extends JFrame implements ActionListener {
    // Components of the Form
    private Container container;
    private JLabel titleLabel;
    private JLabel userLabel;
    private JTextField userNameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JLabel phoneLabel;
    private JTextField phoneTextField;
    private JButton registerButton;
    private JLabel resultLabel;

    // Constructor to setup the GUI components and event handling
    public UserRegistrationForm() {
        setTitle("User Registration Form");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container = getContentPane();
        container.setLayout(null);

        // Title label
        titleLabel = new JLabel("Register");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        titleLabel.setBounds(150, 10, 100, 30);
        container.add(titleLabel);

        // Username label and text field
        userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 60, 100, 30);
        container.add(userLabel);

        userNameField = new JTextField();
        userNameField.setBounds(150, 60, 150, 30);
        container.add(userNameField);  // Fixed: was userTextField incorrectly

        // Password label and field (missing passwordLabel)
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 30);
        container.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 150, 30);
        container.add(passwordField);

        // Email label and text field
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 140, 100, 30);
        container.add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setBounds(150, 140, 150, 30);
        container.add(emailTextField);

        // Phone label and text field
        phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(50, 180, 100, 30);
        container.add(phoneLabel);

        phoneTextField = new JTextField();
        phoneTextField.setBounds(150, 180, 150, 30);
        container.add(phoneTextField);

        // Register button
        registerButton = new JButton("Register");
        registerButton.setBounds(150, 220, 100, 30);
        registerButton.addActionListener(this);
        container.add(registerButton);

        // Result label
        resultLabel = new JLabel("");
        resultLabel.setBounds(50, 260, 300, 30);
        container.add(resultLabel);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Method to handle register button click event
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userNameField.getText();  // Fixed: was userTextField
        String password = new String(passwordField.getPassword());
        String email = emailTextField.getText();
        String phone = phoneTextField.getText();

        // Display entered information
        resultLabel.setText("Registered: " + username + ", " + email + ", " + phone);
    }

    public static void main(String[] args) {
        new UserRegistrationForm();
    }
}