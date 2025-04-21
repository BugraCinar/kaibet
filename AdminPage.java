import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class AdminPage extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JComboBox<Integer> leagueCBox;
    private JComboBox<Integer> matchCBox;
	private JTextField homeTeamField;
	private JTextField awayTeamField;
	private JTextField homeWinField;
	private JTextField drawField;
	private JTextField awayWinField;
	private JTextField underField;
	private JTextField aboveField;
	private JButton saveUpdateBttn;
	
	public AdminPage() {
		getContentPane().setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(850,600);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Admin Page v0.2.7");
			
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN PANEL");
		lblNewLabel.setBounds(48, 32, 301, 50);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Match Info Editor ");
		lblNewLabel_1.setBounds(48, 118, 211, 32);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		getContentPane().add(lblNewLabel_1);
		
		JLabel leagueLbl = new JLabel("League ID");
		leagueLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		leagueLbl.setBounds(50, 173, 71, 25);
		getContentPane().add(leagueLbl);
		
		JLabel matchLbl = new JLabel("Match ID");
		matchLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		matchLbl.setBounds(175, 173, 71, 25);
		getContentPane().add(matchLbl);
		
		JLabel homeTLbl = new JLabel("Home Team");
		homeTLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		homeTLbl.setBounds(300, 173, 71, 25);
		getContentPane().add(homeTLbl);
		
		JLabel awayTLbl = new JLabel("Away Team");
		awayTLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		awayTLbl.setBounds(425, 173, 71, 25);
		getContentPane().add(awayTLbl);
		
		JLabel homeWLbl = new JLabel("Home Win");
		homeWLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		homeWLbl.setBounds(550, 173, 71, 25);
		getContentPane().add(homeWLbl);
		
		JLabel drawLbl = new JLabel("Draw");
		drawLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		drawLbl.setBounds(50, 277, 71, 25);
		getContentPane().add(drawLbl);
		
		JLabel awayWLbl = new JLabel("Away Win");
		awayWLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		awayWLbl.setBounds(175, 277, 71, 25);
		getContentPane().add(awayWLbl);
		
		JLabel underLbl = new JLabel("Under 3.5");
		underLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		underLbl.setBounds(300, 277, 71, 25);
		getContentPane().add(underLbl);
		
		JLabel aboveLbl = new JLabel("Above 3.5");
		aboveLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		aboveLbl.setBounds(425, 277, 71, 25);
		getContentPane().add(aboveLbl);
		
		leagueCBox = new JComboBox<Integer>();
		leagueCBox.addItem(1);
		leagueCBox.setBounds(50, 215, 50, 21);
		getContentPane().add(leagueCBox);
		
		matchCBox = new JComboBox<Integer>();
		populateMatchComboBox();
		matchCBox.setBounds(175, 215, 50, 21);
		getContentPane().add(matchCBox);
		
		homeTeamField = new JTextField();
		homeTeamField.setBounds(300, 216, 71, 19);
		getContentPane().add(homeTeamField);
		homeTeamField.setColumns(10);
		
		awayTeamField = new JTextField();
		awayTeamField.setColumns(10);
		awayTeamField.setBounds(425, 216, 71, 19);
		getContentPane().add(awayTeamField);
		
		homeWinField = new JTextField();
		homeWinField.setBounds(550, 216, 50, 19);
		getContentPane().add(homeWinField);
		homeWinField.setColumns(10);
		
		drawField = new JTextField();
		drawField.setColumns(10);
		drawField.setBounds(48, 312, 50, 19);
		getContentPane().add(drawField);
		
		awayWinField = new JTextField();
		awayWinField.setColumns(10);
		awayWinField.setBounds(175, 312, 50, 19);
		getContentPane().add(awayWinField);
		
		underField = new JTextField();
		underField.setColumns(10);
		underField.setBounds(300, 312, 50, 19);
		getContentPane().add(underField);
		
		aboveField = new JTextField();
		aboveField.setColumns(10);
		aboveField.setBounds(425, 312, 50, 19);
		getContentPane().add(aboveField);
		
		JButton saveUpdateBttn = new JButton("SAVE/UPDATE");
		saveUpdateBttn.setFont(new Font("Arial", Font.BOLD, 12));
		saveUpdateBttn.setBounds(652, 361, 137, 39);
		getContentPane().add(saveUpdateBttn);
		
		JButton logOutBttn = new JButton("Log Out");
		logOutBttn.setFont(new Font("Arial", Font.BOLD, 12));
		logOutBttn.setBounds(652, 424, 137, 39);
		getContentPane().add(logOutBttn);
		
		
		matchCBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedMatchID = (int) matchCBox.getSelectedItem();
                displayMatchDetails(selectedMatchID);
            }
        });

        saveUpdateBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveOrUpdateMatchDetails();
                JOptionPane.showMessageDialog(null, "Progress is finished");
            }
        });
        
        logOutBttn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new WelcomePage();
        		dispose();
        	}
        	
        });
    }

    private void populateMatchComboBox() {
        ArrayList<Matches> matchesList = FileManagement.readMatchesFromFile();
        int nextMatchID = matchesList.isEmpty() ? 1 : matchesList.get(matchesList.size() - 1).getMatchID() + 1;
        for (Matches match : matchesList) {
            matchCBox.addItem(match.getMatchID());
        }
        matchCBox.addItem(nextMatchID);
    }

    private void displayMatchDetails(int matchID) {
        ArrayList<Matches> matchesList = FileManagement.readMatchesFromFile();
        for (Matches match : matchesList) {
            if (match.getMatchID() == matchID) {
                homeTeamField.setText(match.getHomeTeam());
                awayTeamField.setText(match.getAwayTeam());
                homeWinField.setText(String.valueOf(match.getHomeWin()));
                drawField.setText(String.valueOf(match.getDraw()));
                awayWinField.setText(String.valueOf(match.getAwayWin()));
                underField.setText(String.valueOf(match.getUndertnh()));
                aboveField.setText(String.valueOf(match.getAbovetnh()));
                return;
            }
        }
       
        homeTeamField.setText("");
        awayTeamField.setText("");
        homeWinField.setText("");
        drawField.setText("");
        awayWinField.setText("");
        underField.setText("");
        aboveField.setText("");
    }
		
    private void saveOrUpdateMatchDetails() {
        int selectedMatchID = (int) matchCBox.getSelectedItem();
        String filePath = "database/champ_league.txt";

        
        String homeTeam = homeTeamField.getText();
        String awayTeam = awayTeamField.getText();
        double homeWin = Double.parseDouble(homeWinField.getText());
        double draw = Double.parseDouble(drawField.getText());
        double awayWin = Double.parseDouble(awayWinField.getText());
        double undertnh = Double.parseDouble(underField.getText());
        double abovetnh = Double.parseDouble(aboveField.getText());

        
        Matches updatedMatch = new Matches(1, selectedMatchID, homeTeam, awayTeam, homeWin, draw, awayWin, undertnh, abovetnh);

        
        ArrayList<Matches> matchesList = FileManagement.readMatchesFromFile();

        
        boolean matchFound = false;
        for (int i = 0; i < matchesList.size(); i++) {
            if (matchesList.get(i).getMatchID() == selectedMatchID) {
                matchesList.set(i, updatedMatch);
                matchFound = true;
                break;
            }
        }

        if (!matchFound) {
            matchesList.add(updatedMatch);
        }

       
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Matches match : matchesList) {
                writer.write(match.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
		
		
		
		
		
    

		
		
		
       
 }


