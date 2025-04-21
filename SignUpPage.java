import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;

public class SignUpPage extends JFrame{

	
	private static final long serialVersionUID = 1L;

	public SignUpPage() {
         

        JFrame signUpFrame = new JFrame("Sign Up");
        signUpFrame.setTitle("Sign Up v0.2.7");
        signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signUpFrame.getContentPane().setBackground(new Color(192, 192, 192));
        signUpFrame.getContentPane().setLayout(null);

        JLabel signUpLabel = new JLabel("Sign Up");
        signUpLabel.setFont(new Font("Arial", Font.BOLD, 18));
        signUpLabel.setBounds(130, 20, 100, 30);
        signUpFrame.getContentPane().add(signUpLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        usernameLabel.setBounds(50, 70, 80, 30);
        signUpFrame.getContentPane().add(usernameLabel);

        JTextField signUpUsernameField = new JTextField();
        signUpUsernameField.setBounds(140, 70, 150, 30);
        signUpFrame.getContentPane().add(signUpUsernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        passwordLabel.setBounds(50, 120, 80, 30);
        signUpFrame.getContentPane().add(passwordLabel);

        JPasswordField signUpPasswordField = new JPasswordField();
        signUpPasswordField.setBounds(140, 120, 150, 30);
        signUpFrame.getContentPane().add(signUpPasswordField);

        JCheckBox ageConfirmationCheckBox = new JCheckBox("I confirm that I am older than 18 years old");
        ageConfirmationCheckBox.setBounds(50, 170, 268, 30);
        signUpFrame.getContentPane().add(ageConfirmationCheckBox);

        JButton signUpConfirmButton = new JButton("Sign Up");
        signUpConfirmButton.setFont(new Font("Arial", Font.BOLD, 12));
        signUpConfirmButton.setBounds(120, 220, 100, 30);
        signUpFrame.getContentPane().add(signUpConfirmButton);

        signUpConfirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newUsername = signUpUsernameField.getText();
                String newPassword = new String(signUpPasswordField.getPassword());
                boolean isConfirmed = ageConfirmationCheckBox.isSelected();

                if (isConfirmed) {
                   if(newUsername.equals("")|| newPassword.equals("")) {
                	   
                	   JOptionPane.showMessageDialog(null, "Please create username and password.");
                	   
                   }
                	
                   else {
                	   
                	   FileManagement.validateSignUp(newUsername, newPassword);
                       signUpFrame.dispose(); 
                       new WelcomePage(); 
                   }
                } else {
                    JOptionPane.showMessageDialog(null, "Please confirm that you are older than 18 years old");
                }
            }
        });

        signUpFrame.setSize(350, 300);
        signUpFrame.setLocationRelativeTo(null);
        signUpFrame.setVisible(true);
        signUpFrame.setResizable(false);
       
    }
	
}
