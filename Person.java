
public class Person {

	
	    private String username;
	    private String password;
	    private int balance = 5000;

	    public Person(String username, String password,int balance) {
	        this.username = username;
	        this.password = password;
	        this.balance=balance;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public String getPassword() {
	        return password;
	    }
	    public int getBalance() {
	    	return balance;
	    }
	    public void setUsername(String username) {
	    	
	    	this.username=username;
	    }
	    
	    public void setPassword (String password) {
	    	
	    	this.password= password;
	    }
	
        public void setBalance(int balance) {
        	this.balance=balance;
        }
        
        @Override
        public String toString() {
        	return "Person= ( UserName: " + username + " , " + "Password: " + password + " , " + "Balance: " + balance + " ) " ; 
        }
}
