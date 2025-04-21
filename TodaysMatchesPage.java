import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.io.FileWriter;

import javax.swing.table.DefaultTableModel;


public class TodaysMatchesPage extends JFrame {
	private static final long serialVersionUID = 1L;
	DefaultTableModel model;
	private JTable table;
	private Person User;
	
	public   TodaysMatchesPage(Person person) {
		getContentPane().setBackground(new Color(192, 192, 192));
		this.User = person;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   CHAMPIONS LEAGUE");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 10, 593, 59);
		getContentPane().add(lblNewLabel);
		
		JButton betPagebttn = new JButton("Bet Page");
		betPagebttn.setBackground(new Color(255, 255, 255));
		betPagebttn.setFont(new Font("Arial", Font.BOLD, 20));
		betPagebttn.setBounds(644, 10, 152, 59);
		getContentPane().add(betPagebttn);
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 79, 816, 424);
        getContentPane().add(scrollPane);

        table = new JTable();
        Font font = new Font("New Times Roman", Font.PLAIN, 15);
        table.setFont(font);
        table.setRowHeight(30);
        model = new DefaultTableModel();
        table.setDefaultEditor(Object.class, null);
        Object[] column = {"League Id","Match ID","Home","Away","Home Win","Draw","Away Win","Under 3.5","Above 3.5"};

        table.getTableHeader().setReorderingAllowed(false);
        table.setModel(model);
        model.setColumnIdentifiers(column);
        scrollPane.setViewportView(table);
        
      
            	ArrayList<Matches> matchesList =FileManagement.readMatchesFromFile();
       		 for (int i = 0 ; i< matchesList.size(); i++) {
       			Object[] row = new  Object[9];
       			
       			   row[0]=matchesList.get(i).getLeagueID();
       	           row[1]=matchesList.get(i).getMatchID();
       	           row[2]=matchesList.get(i).getHomeTeam();
       	           row[3]=matchesList.get(i).getAwayTeam();
       	           row[4]=matchesList.get(i).getHomeWin();
       	           row[5]=matchesList.get(i).getDraw();
       	           row[6]=matchesList.get(i).getAwayWin();
       	           row[7]=matchesList.get(i).getUndertnh();
       	           row[8]=matchesList.get(i).getAbovetnh();
       	           model.addRow(row);
       	        
       		 }
       		
       		 JComboBox<Integer> matchIdComboBox = new JComboBox<>();
             matchIdComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
             ArrayList<Matches> matchesListt = FileManagement.readMatchesFromFile();
             for (int i = 1; i <= matchesListt.size(); i++) {
                 matchIdComboBox.addItem(i);
             }
             matchIdComboBox.setBounds(123, 520, 80, 30);
             getContentPane().add(matchIdComboBox);

             JComboBox<String> betOptionsComboBox = new JComboBox<>();
             String[] bettingOptions = {"Home Win", "Draw", "Away Win", "Under 3.5", "Above 3.5"};
             for (String option : bettingOptions) {
                 betOptionsComboBox.addItem(option);
             }
             betOptionsComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
             betOptionsComboBox.setBounds(336, 520, 120, 30);
             getContentPane().add(betOptionsComboBox);

             JButton addBetButton = new JButton("Add Bet");
             addBetButton.setBackground(new Color(240, 240, 240));
             addBetButton.setFont(new Font("Arial", Font.BOLD, 15));
             addBetButton.setBounds(575, 520, 100, 30);
             getContentPane().add(addBetButton);
             
             JLabel matchLbl = new JLabel("Match ID:");
             matchLbl.setFont(new Font("Arial", Font.BOLD, 15));
             matchLbl.setBounds(33, 520, 80, 30);
             getContentPane().add(matchLbl);
             
             JLabel lblNewLabel_1 = new JLabel("Bet Type:");
             lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
             lblNewLabel_1.setBounds(240, 520, 86, 30);
             getContentPane().add(lblNewLabel_1);

             addBetButton.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     int selectedMatchId = (int) matchIdComboBox.getSelectedItem();
                     String selectedBetOption = (String) betOptionsComboBox.getSelectedItem();
                     Matches selectedMatch= null;
                     double selectedBetOdd = 0;
                     var listMatches= FileManagement.readMatchesFromFile();
                    var selectedMatches = FileManagement.readSelectedMatches();
                     for (Matches matches : listMatches) {
                    	 
                    	 if(	 matches.getMatchID() == selectedMatchId) {
                    		 selectedMatch = matches;
                    	 	}
                     }
                      if (selectedBetOption == "Home Win") {
                    	  selectedBetOdd = selectedMatch.getHomeWin();
                      }
                      else if(selectedBetOption == "Away Win") {
                    	  selectedBetOdd = selectedMatch.getAwayWin();
                    	  
                      }                      
                      else if(selectedBetOption == "Draw") {
                    	  selectedBetOdd = selectedMatch.getDraw();
                    	  }                      
                      else if(selectedBetOption == "Above 3.5") {
                    	  selectedBetOdd = selectedMatch.getAbovetnh();
                    	  }                      
                      else if(selectedBetOption == "Under 3.5") {
                    	  selectedBetOdd = selectedMatch.getUndertnh();
                      }
                      
                     for(SelectedMatches matches : selectedMatches) 
                     {
                    	 if(matches.getMatchID() == selectedMatchId ) {
                    		 JOptionPane.showMessageDialog(null, "You already made a bet on this match!");
                    		 return;
                    	 	}
                     }
                     
                     try {
                         FileWriter writer = new FileWriter("database/selectedMatches.txt", true); // Append mode
                         writer.write( selectedMatchId + "," + selectedMatch.getHomeTeam()+ "," + selectedMatch.getAwayTeam() 
                         +"," +selectedBetOdd + "," + selectedBetOption + "\n");
                         writer.close();
                     } catch (IOException ex) {
                         ex.printStackTrace();
                     }

                     JOptionPane.showMessageDialog(null, "Bet added successfully!");
                 }
             });

       	
      betPagebttn.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  
    		  String username = FileManagement.getLoggedInUsername();
    		 
    		 
    		BetPage betPage=  new BetPage(User);
    		betPage.setUsername(username);
              dispose();
          }
      });
		 
		setSize(850,600);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Today's Matches v0.2.7");
       
        
       
    }
}
