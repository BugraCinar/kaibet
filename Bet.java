
public class Bet {

private double totalOdd;
private int playedAmount;
private double totalPosWin;



public Bet(double totalOdd, int playedAmount, double totalPosWin) {
	
	this.totalOdd=totalOdd;
	this.playedAmount=playedAmount;
	this.totalPosWin=totalPosWin;

}

public double getTotalOdd() {
	return totalOdd;
}
public int getPlayedAmount (){
	return playedAmount;
}
public double getTotalPosWin () {
	return totalPosWin;
}

public void setTotalOdd (double totalOdd) {
	this.totalOdd=totalOdd;
}
public void setPlayedAmount (int playedAmount) {
	this.playedAmount=playedAmount;
}
public void setTotalPosWin( double totalPosWin) {
	this.totalPosWin=totalPosWin;
}

@Override
 public String toString() {
	 return "Bet = (  Total Odd: " + totalOdd + " , " + "Played Amount: " + playedAmount + " , " + "Total Possible Win: " + totalPosWin + " ) " ; 
 }
}
