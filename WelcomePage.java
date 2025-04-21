import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;



public class WelcomePage extends JFrame {
    
	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signUpButton;

    public WelcomePage() {
    	getContentPane().setBackground(new Color(192, 192, 192));
    	setBackground(new Color(192, 192, 192));
        setTitle("Kai-Bet v0.2.7");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome to Kai-Bet");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setBounds(50, 50, 300, 30);
        getContentPane().add(welcomeLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 100, 80, 30);
        getContentPane().add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(140, 100, 150, 30);
        getContentPane().add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 150, 80, 30);
        getContentPane().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 150, 150, 30);
        getContentPane().add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(50, 200, 100, 30);
        getContentPane().add(loginButton);

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(190, 200, 100, 30);
        getContentPane().add(signUpButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
               
        
            
                if (username.equals("Bugra") && password.equals("123")) {
                 
                    String[] options = {"Admin Page", "Todays Matches Page"};
                    int choice = JOptionPane.showOptionDialog(null, "Admin selection, which page do you want to go?", "Admin Options",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    if (choice == 0) {
                        
                        new AdminPage();
                        dispose(); 
                    } else if (choice == 1) {
                       
                        if (FileManagement.validateLogin(username, password)) {
                            var person = FileManagement.getPerson(username, password);
                            new TodaysMatchesPage(person);
                            dispose(); 
                        }
                    }
                } else {
                    if (FileManagement.validateLogin(username, password)) {
                        var person = FileManagement.getPerson(username, password);
                        new TodaysMatchesPage(person);
                        dispose(); 
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                    }
                }
            }
        });


        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SignUpPage();
                dispose();
            }
        });

        setSize(350, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    

    
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WelcomePage();
            }
        });
    }
}