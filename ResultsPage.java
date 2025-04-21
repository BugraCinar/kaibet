import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;


public class ResultsPage extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField userField;
	private JTextField blncField;
	private JTextField totalField;
	private JTextField playedField;
	private JTextField textField;
	DefaultTableModel model;
	private JTable table;
	private Person user;
	public ResultsPage(Person person, Bet bet) {
		getContentPane().setBackground(new Color(192, 192, 192));
		 user=person;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel mybetLbl = new JLabel("MY BET");
		mybetLbl.setBounds(22, 10, 130, 56);
		mybetLbl.setFont(new Font("Arial", Font.BOLD, 20));
		getContentPane().add(mybetLbl);
		
		JLabel userLbl = new JLabel("User Name");
		userLbl.setBounds(410, 16, 104, 44);
		userLbl.setFont(new Font("Arial", Font.BOLD, 20));
		getContentPane().add(userLbl);
		
		JLabel blncLbl = new JLabel("Balance");
		blncLbl.setBounds(642, 18, 79, 41);
		blncLbl.setFont(new Font("Arial", Font.BOLD, 20));
		getContentPane().add(blncLbl);
		
		userField = new JTextField();
		userField.setEditable(false);
		userField.setBounds(524, 22, 96, 33);
		userField.setFont(new Font("Arial", Font.BOLD, 20));
		userField.setBorder(null);
		getContentPane().add(userField);
		userField.setColumns(10);
		
		blncField = new JTextField();
		blncField.setEditable(false);
		blncField.setColumns(10);
		blncField.setBounds(731, 25, 96, 33);
		getContentPane().add(blncField);
		blncField.setText(String.valueOf(person.getBalance()));
		JLabel totalrateLbl = new JLabel("Total Odd");
		totalrateLbl.setBounds(10, 467, 106, 33);
		totalrateLbl.setFont(new Font("Arial", Font.BOLD, 20));
		getContentPane().add(totalrateLbl);
		
		JLabel plydblncLbl = new JLabel("Played Balance");
		plydblncLbl.setBounds(192, 466, 146, 35);
		plydblncLbl.setFont(new Font("Arial", Font.BOLD, 20));
		getContentPane().add(plydblncLbl);
		
		JLabel maxwinLbl = new JLabel("Maximum Win");
		maxwinLbl.setBounds(419, 467, 138, 33);
		maxwinLbl.setFont(new Font("Arial", Font.BOLD, 20));
		getContentPane().add(maxwinLbl);
		
		totalField = new JTextField();
		totalField.setEditable(false);
		totalField.setBounds(112, 470, 70, 33);
		getContentPane().add(totalField);
		totalField.setColumns(10);
		
		
		playedField = new JTextField();
		playedField.setEditable(false);
		playedField.setColumns(10);
		playedField.setBounds(339, 470, 70, 33);
		getContentPane().add(playedField);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(555, 470, 70, 33);
		getContentPane().add(textField);
		
		JLabel lblNewLabel = new JLabel("");
	    lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
	    lblNewLabel.setBounds(191, 13, 186, 56);
	    getContentPane().add(lblNewLabel);
		
		JButton logOutBttn = new JButton("Log Out");
		logOutBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileManagement.clearFile("database/selectedMatches.txt");
        		new WelcomePage();
        		dispose();
			}
		});
		logOutBttn.setBounds(731, 468, 96, 36);
		getContentPane().add(logOutBttn);
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 71, 816, 388);
        getContentPane().add(scrollPane);

        table = new JTable();
        Font font = new Font("New Times Roman", Font.PLAIN, 15);
        table.setFont(font);
        table.setRowHeight(30);
        model = new DefaultTableModel();
        table.setDefaultEditor(Object.class, null);
        
        var listResults = SimulateSelectedMatches();
        Object[] column = {"Match ID","Home","Home Score","vs", "Away Score","Away" ,"Bet Option","Status"};
        
        table.getTableHeader().setReorderingAllowed(false);
        table.setModel(model);
        model.setColumnIdentifiers(column);
        scrollPane.setViewportView(table);
        boolean winBet = true;
        for (int i = 0 ; i< listResults.size(); i++) {
   			Object[] row = new  Object[8];
   			
   			   row[0]=listResults.get(i).getMatchID();
   	           row[1]=listResults.get(i).getHomeTeam();
   	           row[2]=listResults.get(i).getHomeScore();
   	           row[3]="vs";
   	           row[4]=listResults.get(i).getAwayScore();
   	           row[5]=listResults.get(i).getAwayTeam();
	           row[6]=listResults.get(i).getBetOption();
	           
	           if (listResults.get(i).getWin()== true) {
	        	     row[7]=" win "; 
	           } 
	           else {
	        	   row[7]= "lose";
	        	   winBet = false;
	        	   
	           }
	  
	        	   
	           
   	          
   	           model.addRow(row);
   	        
        }
        if(winBet== false) {
        	lblNewLabel.setText("You Lost...");
        	lblNewLabel.setForeground(Color.RED);
        	user.setBalance(user.getBalance()-(int)bet.getPlayedAmount());
        }
        else {
        	lblNewLabel.setText("You Win!!");
        	lblNewLabel.setForeground(Color.GREEN);
        	user.setBalance(user.getBalance()+ (int)bet.getTotalPosWin()-(int)bet.getPlayedAmount());
        	
        }
        var users = FileManagement.getPersons();
        var newusers = new ArrayList<Person>();
        for(Person u : users) {
        	if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
        		u.setBalance(user.getBalance());
        		newusers.add(u);
        	}
        	else {
        		newusers.add(u);
        	}
        }
        
        FileManagement.clearFile("database/users.txt");
		FileManagement.writeNewUsers(newusers);
		

        JButton tmReturnBttn_1 = new JButton("Today's \nMatches");
        tmReturnBttn_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		FileManagement.clearFile("database/selectedMatches.txt");
        		new TodaysMatchesPage(user);
        		dispose();
        	}
        });
        tmReturnBttn_1.setBounds(635, 468, 96, 36);
        getContentPane().add(tmReturnBttn_1);
		
        userField.setText(user.getUsername());
        blncField.setText(String.valueOf(user.getBalance()));
        totalField.setText(String.valueOf(bet.getTotalOdd()));
        playedField.setText(String.valueOf(bet.getPlayedAmount()));
        textField.setText(String.valueOf(bet.getTotalPosWin()));
        
       
        
		setSize(850,550);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Results Page v0.2.7");
		
		
	}
	
	private ArrayList<Results> SimulateSelectedMatches() {
	var selectedmatches = FileManagement.readSelectedMatches();
	var random = new Random();
	var listResults = new ArrayList<Results>();
	for(SelectedMatches matches : selectedmatches) {
		var hometeam = matches.getHomeTeam();
		var awayteam = matches.getAwayTeam();
		var hometeamscore =  random.nextInt(6);
		var awayteamscore = random.nextInt(6);
		var betoption = matches.getBetOption();
		var matchid = matches.getMatchID();
		var win = false;
		if (betoption.equals("Home Win")) {
      	  if(hometeamscore>awayteamscore) {
      		  win = true;
      	  }
        }
        else if(betoption.equals("Away Win")) {
        	  if(awayteamscore>hometeamscore) {
          		  win = true;
          	  }
        }                      
        else if(betoption.equals("Draw")) {
      	      if(hometeamscore==awayteamscore) {
      	    	  win = true;
      	      }
      	  }                      
        else if(betoption.equals("Above 3.5")) {
      	   if (hometeamscore+awayteamscore>3) {
      		   win = true;
      	   }
      	  }                      
        else if(betoption.equals("Under 3.5")) {
      	  if (hometeamscore+awayteamscore<4) {
      		  win= true;
      	  }
        }
        
		var result = new Results(hometeamscore,awayteamscore,hometeam,awayteam,matchid,betoption,win);
		listResults.add(result);
	}
	return listResults;
	}
	}

