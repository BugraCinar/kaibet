
public class Matches {

	private int leagueID;
	private int  matchID;
	private String homeTeam;
	private String awayTeam;
	private double homeWin;
	private double draw;
	private double awayWin;
	private double undertnh;
	private double abovetnh;
	
	
	public  Matches(int leagueID, int matchID, String homeTeam, String awayTeam, double homeWin, double draw, double awayWin, double undertnh, double abovetnh )
	
	{
		this.leagueID=leagueID;
		this.matchID=matchID;
		this.homeTeam=homeTeam;
		this.awayTeam=awayTeam;
		this.homeWin=homeWin;
		this.draw=draw;
		this.awayWin=awayWin;
		this.undertnh=undertnh;
		this.abovetnh=abovetnh;
		
		}	
	
	public int getLeagueID() {
		return leagueID;
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
	
	public double getHomeWin () {	
	return homeWin;
	}
	public double getDraw() {
		return draw;
	}
	public double getAwayWin() {
		return awayWin;
	}
	public double getUndertnh() {
		return undertnh;
	}
	public double getAbovetnh() {
		return abovetnh;
	}
	
	
	public void setLeagueID(int leagueID) {
		this.leagueID=leagueID;
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
	public void setHomeWin(double homeWin) {
		this.homeWin=homeWin;
	}
	public void setDraw(double draw) {
		this.draw=draw;
	}
	public void setAwayWin(double awayWin) {
		this.awayWin=awayWin;
	}
	public void setUndertnh (double undertnh) {
		this.undertnh=undertnh;
	}
	public void setAbovetnh(double abovetnh) {
		this.abovetnh=abovetnh;
	}
	
	@Override
	public String toString() {
        
        return leagueID + "-" + matchID + "-" + homeTeam + "-" + awayTeam + "-" +
                homeWin + "-" + draw + "-" + awayWin + "-" + undertnh + "-" + abovetnh;
    }
}
