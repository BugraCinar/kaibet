import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
public class FileManagement {
	
	
	 private static String loggedInUsername;


	 
	 public static boolean validateLogin(String username, String password) {
	        try (BufferedReader br = new BufferedReader(new FileReader("database/users.txt"))) {
	            List<Person> users = new ArrayList<>();
                loggedInUsername = username;
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts.length == 3) {
	                    Person user = new Person(parts[0], parts[1], Integer.parseInt(parts[2]));
	                    users.add(user);
	                }
	            }

	            for (Person user : users) {
	                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
	                   int balance = user.getBalance(); 
	                   
	                    return true;
	                }
	            }
	        } catch (IOException | NumberFormatException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	 
	 public static Person getPerson(String username,String password) 
	 {
		 try (BufferedReader br = new BufferedReader(new FileReader("database/users.txt"))) {
	            List<Person> users = new ArrayList<>();
             loggedInUsername = username;
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts.length == 3) {
	                    Person user = new Person(parts[0], parts[1], Integer.parseInt(parts[2]));
	                    users.add(user);
	                }
	            }

	            for (Person user : users) {
	                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
	   
	                	return user;
	                }
	
                }
	            return null;
            }

		 catch (IOException | NumberFormatException e) {
	            e.printStackTrace();
	            return null;
	        }
	 }
	 
	 public static ArrayList<Person> getPersons(){
		 try (BufferedReader br = new BufferedReader(new FileReader("database/users.txt"))) {
			 ArrayList<Person> users = new ArrayList<>();
	            
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts.length == 3) {
	                    Person user = new Person(parts[0], parts[1], Integer.parseInt(parts[2]));
	                    users.add(user);
	                }
	            } 
	       return users;     
		 }

		 catch (IOException | NumberFormatException e) {
	            e.printStackTrace();
	            return null;
	        }
	 }
	

public static String getLoggedInUsername() {
    return loggedInUsername;
}

public static boolean validateSignUp(String newUsername, String newPassword ) {
	 
	
	try (BufferedWriter bw = new BufferedWriter(new FileWriter("database/users.txt", true))) {
        bw.write(newUsername + "," + newPassword + ","+ "5000"+ "\n");
        return true;
    } catch (IOException ex) {
        ex.printStackTrace();
    }
	
	return false;
}

public static ArrayList<Matches> readMatchesFromFile() {
    ArrayList<Matches> matchesList = new ArrayList<>();
      String filePath= "database/champ_league.txt";
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
        
            String[] matchDetails = line.split("-");
         
            int leagueID = Integer.parseInt(matchDetails[0]); 
            int matchID = Integer.parseInt(matchDetails[1]);
            String homeTeam = matchDetails[2];
            String awayTeam = matchDetails[3];
            double homeWin = Double.parseDouble(matchDetails[4]);
            double draw = Double.parseDouble(matchDetails[5]);
            double awayWin = Double.parseDouble(matchDetails[6]);
            double undertnh = Double.parseDouble(matchDetails[7]);
            double abovetnh = Double.parseDouble(matchDetails[8]);

            
            Matches match = new Matches (leagueID,  matchID,  homeTeam,  awayTeam,  homeWin,  draw,  awayWin,  undertnh,  abovetnh );

         
            matchesList.add(match);
                    }
    } catch (IOException | NumberFormatException e) {
        e.printStackTrace();
    }

    return matchesList;
}

public static ArrayList<SelectedMatches> readSelectedMatches (){
  ArrayList<SelectedMatches> selectedMatchesList = new ArrayList<>();
  String filePath = "database/selectedMatches.txt";
  
  try ( BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	  String line;
	  while ((line = br.readLine())!= null) {
		  String[] selectedMatchDetails = line.split(",");
		  
		  int selectedMatchID = Integer.parseInt(selectedMatchDetails[0]);
		  String selectedHomeTeam = selectedMatchDetails[1];
          String selectedAwayTeam = selectedMatchDetails[2];
          double selectedBetOdd = Double.parseDouble(selectedMatchDetails[3]);
          String selectedBetOption = selectedMatchDetails[4];
        
          
          SelectedMatches selectedMatch = new SelectedMatches (selectedMatchID,selectedHomeTeam,selectedAwayTeam,selectedBetOdd,selectedBetOption);
          selectedMatchesList.add(selectedMatch);
	  }
	  return selectedMatchesList;
  }
  catch (IOException | NumberFormatException e) {
      e.printStackTrace();
  return null;    
  }
  
  

}
public static void clearFile(String path) {
	  
	  PrintWriter writer;
		try {
			writer = new PrintWriter(path);
	        writer.print("");
	        writer.close();
	        
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
}
public static void writeNewUsers(ArrayList<Person> users) {
	try (BufferedWriter bw = new BufferedWriter(new FileWriter("database/users.txt", true))) {
        for(int i = 0 ; i<users.size();i++) {
        	 bw.write(users.get(i).getUsername() + "," + users.get(i).getPassword()+ ","+ users.get(i).getBalance()+ "\n");
        }
        
    } catch (IOException ex) {
        ex.printStackTrace();
    }
	
	
	
}




}