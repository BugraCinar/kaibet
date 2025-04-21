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
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BetPage  extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextField userField;
	private JTextField blncField;
	private JTextField totalField;
	private JTextField playedField;
	private JTextField textField;
	DefaultTableModel model;
	private JTable table;
	private Person user;
	public void setUsername(String username) {
        userField.setText(username);
    }

	
	
	public BetPage(Person person) {
		getContentPane().setBackground(new Color(192, 192, 192));
		user=person;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel mybetLbl = new JLabel("MY BETS");
		mybetLbl.setBounds(22, 10, 130, 56);
		mybetLbl.setFont(new Font("Arial", Font.BOLD, 25));
		getContentPane().add(mybetLbl);
		
		JLabel userLbl = new JLabel("User Name");
		userLbl.setBounds(410, 17, 104, 44);
		userLbl.setFont(new Font("Arial", Font.BOLD, 20));
		getContentPane().add(userLbl);
		
		JLabel blncLbl = new JLabel("Balance");
		blncLbl.setBounds(642, 19, 79, 41);
		blncLbl.setFont(new Font("Arial", Font.BOLD, 20));
		getContentPane().add(blncLbl);
		
		userField = new JTextField();
		userField.setEditable(false);
		userField.setBounds(524, 23, 96, 33);
		userField.setFont(new Font("Arial", Font.BOLD, 20));
		userField.setBorder(null);
		getContentPane().add(userField);
		userField.setColumns(10);
		
		blncField = new JTextField();
		blncField.setEditable(false);
		blncField.setColumns(10);
		blncField.setBounds(731, 26, 96, 33);
		getContentPane().add(blncField);
		blncField.setText(String.valueOf(person.getBalance()));
		JLabel totalrateLbl = new JLabel("Total Odd");
		totalrateLbl.setBounds(20, 467, 104, 36);
		totalrateLbl.setFont(new Font("Arial", Font.BOLD, 20));
		getContentPane().add(totalrateLbl);
		
		JLabel plydblncLbl = new JLabel("Played Balance");
		plydblncLbl.setBounds(206, 468, 146, 35);
		plydblncLbl.setFont(new Font("Arial", Font.BOLD, 20));
		getContentPane().add(plydblncLbl);
		
		JLabel maxwinLbl = new JLabel("Maximum Win");
		maxwinLbl.setBounds(447, 469, 138, 33);
		maxwinLbl.setFont(new Font("Arial", Font.BOLD, 20));
		getContentPane().add(maxwinLbl);
		
		totalField = new JTextField();
		totalField.setEditable(false);
		totalField.setBounds(126, 470, 70, 33);
		getContentPane().add(totalField);
		totalField.setColumns(10);

		
		playedField = new JTextField();
		playedField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
				
				var keycode = e.getKeyCode();
				if(keycode == KeyEvent.VK_ENTER) {
					
					
					double totalRate =Double.parseDouble(totalField.getText());
					
					double playedAmount =Double.parseDouble(playedField.getText());
					DecimalFormat df = new DecimalFormat("#.##");
					if (playedAmount>user.getBalance()) {
						JOptionPane.showMessageDialog(null, "You can not enter more than your balance!");
						playedField.setText(String.valueOf(df.format(user.getBalance())));
						return;
					}
 
					textField.setText(String.valueOf(df.format(totalRate*playedAmount)));
				}
				}
				catch (NumberFormatException a) {
		      a.printStackTrace();
			     textField.setText("");
				}
			
		}});
		playedField.setColumns(10);
		playedField.setBounds(357, 472, 70, 33);
		getContentPane().add(playedField);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(595, 472, 70, 33);
		getContentPane().add(textField);
		
		JButton goodluckBttn = new JButton("GOOD LUCK");
		goodluckBttn.setFont(new Font("Arial", Font.BOLD, 12));
		goodluckBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 double totalOdd= Double.parseDouble(totalField.getText()); 
			 int playedAmount =Integer.parseInt(playedField.getText());	
			 double totalPosWin= Double.parseDouble(textField.getText()); 
				var bet= new Bet( totalOdd,  playedAmount,  totalPosWin);
				ResultsPage resultsPage = new ResultsPage(user,bet);
				dispose();
			}
		});
		goodluckBttn.setBounds(705, 467, 122, 36);
		getContentPane().add(goodluckBttn);

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 71, 816, 388);
        getContentPane().add(scrollPane);

        table = new JTable();
        Font font = new Font("New Times Roman", Font.PLAIN, 15);
        table.setFont(font);
        table.setRowHeight(30);
        model = new DefaultTableModel();
        table.setDefaultEditor(Object.class, null);
        Object[] column = {"Match ID","Home","Away","Bet Odd","Bet Option"};

        table.getTableHeader().setReorderingAllowed(false);
        table.setModel(model);
        model.setColumnIdentifiers(column);
        scrollPane.setViewportView(table);
        
      
            	ArrayList<SelectedMatches> selectedMatchesList =FileManagement.readSelectedMatches();
       		 for (int i = 0 ; i< selectedMatchesList.size(); i++) {
       			Object[] row = new  Object[9];
       			
       			   row[0]=selectedMatchesList.get(i).getMatchID();
       	           row[1]=selectedMatchesList.get(i).getHomeTeam();
       	           row[2]=selectedMatchesList.get(i).getAwayTeam();
       	           row[3]=selectedMatchesList.get(i).getBetOdd();
       	           row[4]=selectedMatchesList.get(i).getBetOption();
       	          
       	           model.addRow(row);
       	        
       		 }

		 double totalRate= 1.00;
		
		for(int i = 0 ; i< selectedMatchesList.size(); i++) {
			
			totalRate= totalRate*selectedMatchesList.get(i).getBetOdd();
			
			
			
		}
		
		DecimalFormat df = new DecimalFormat("#.##");
		totalField.setText(String.valueOf(df.format(totalRate)));
		
		setSize(850,550);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("My Bet v0.2.7");
       
	}
}
