
public class SelectedMatches{

	private int  matchID;
	private String homeTeam;
	private String awayTeam;
	private double betOdd;
	private String betOption;
	
	
	
	public  SelectedMatches( int matchID, String homeTeam, String awayTeam, double betOdd, String betOption )
	
	{
	
		this.matchID=matchID;
		this.homeTeam=homeTeam;
		this.awayTeam=awayTeam;
		this.betOdd=betOdd;
		this.betOption=betOption;
		}	
	
	
	
	public int getMatchID() {
		return matchID;
	}
	 public String getHomeTeam () {
		 return homeTeam;
	 }
	
	public String getAwayTeam () {
		return awayTeam;
	}
	
	public double getBetOdd () {	
	return betOdd;
	}
	
	public String getBetOption () {
		return betOption;
	}
	
	
	
	public void setMatchID (int matchID) {
		this.matchID=matchID;
	}
	public void setHomeTeam(String homeTeam) {
		this.homeTeam=homeTeam;
	}
	public void setAwayTeam(String awayTeam) {
		this.awayTeam=awayTeam;
	}
	public void setBetOdd(double betOdd) {
		this.betOdd=betOdd;
	}
	public void setBetOption(String betOption) {
		this.betOption=betOption;
	}
	
	@Override
	 public String toString() {
	 
	 return " Selected Match= ( Match ID: " + matchID + " , " + "Home Team: " + homeTeam + " , " +
	 "Away Team: " + awayTeam + " , " + " Bet Odd: " + betOdd + " , " + "Bet Option: " + betOption + " )" ;
	 }
}
