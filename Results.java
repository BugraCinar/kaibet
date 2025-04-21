
public class Results {

	private int homeScore;
    private int awayScore;	
    private String homeTeam;
    private String awayTeam;
    private int matchID;
    private String betOption;
    private boolean win;
    
    
    public Results  (int homeScore, int awayScore,String homeTeam,String awayTeam,int matchID, String betOption,boolean win) {
    	
   this.homeScore=homeScore;
   this.awayScore=awayScore;
   this.homeTeam=homeTeam;
   this.awayTeam=awayTeam;
   this.matchID=matchID;
   this.betOption=betOption;
   this.win=win;
    	
    }
	
    public int getHomeScore() {
    	return homeScore;
    }
    public int getAwayScore() {
    	return awayScore;
    }
	public String getHomeTeam() {
		return homeTeam;
	}
    public String getAwayTeam() {
    	return awayTeam;
    }
    public int getMatchID() {
    	return matchID;
    }
    public String getBetOption() {
    	return betOption;
    }
    public boolean getWin() {
    	return win;
    }
	
    public void setHomeScore(int homeScore) {
    	this.homeScore=homeScore;
    }
    public void setAwayScore (int awayScore) {
    	this.awayScore=awayScore;
    }
    public void setHomeTeam(String homeTeam) {
    	this.homeTeam=homeTeam;
    }
    public void setAwayTeam(String awayTeam) {
    	this.awayTeam=awayTeam;
    }
    public void setMatchID(int matchID) {
    	
    this.matchID=matchID;
    }
    public void setBetOPtion(String betOption) {
    	this.betOption=betOption;
    }
    public void setWin (boolean win) {
    	this.win=win;
    }
    @Override
    public String toString() {
        return "Results= ( Home Score: " + homeScore  + " , " + "Away Score: " + awayScore + " , " + "Home Team: " + homeTeam + " , " + " Away Team: " 
       + awayTeam + " , " + "Mathc ID: " + matchID + ", " + " Bet Option: " +  betOption + " , " + "Win: " + win + ")" ;
    }

}
