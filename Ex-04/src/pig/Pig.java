package pig;

import dice.PairOfDice;

public class Pig {
	public static final int WINNING_CONDITION = 100;
	private static final String ENTRY_TEXT = "In diesem Spiel gewinnt derjenige Spieler,\r\n"
			+ "der zuerst die Punktesumme 100 gesammelt hat. Innerhalb eines Spielzugs\r\n"
			+ "wirft der aktuelle Spieler so oft er m¨ochte je zwei Würfel\r\n"
			+ "Dabei werden alle Punkte zusammengezählt, bis entweder eine EINS gewurfelt wird, dann ist der Zug ¨\r\n"
			+ "zu Ende und alle Punkte dieses Zugs sind verloren und der andere Spieler\r\n"
			+ "ist an der Reihe, oder der Spieler die Wurfel weiterreicht und seinen Zug ¨\r\n"
			+ "freiwillig beendet. Nur in diesem Fall werden die gewurfelten Augen auf- ¨\r\n"
			+ "summiert und dem Konto des Spielers gutgeschrieben. Sollte der Spieler\r\n"
			+ "zwei EINSEN gleichzeitig wurfeln, verliert er alle bis zu diesem Zeitpunkt gesammelten Punkte auf seinem Konto und sein Zug ist ebenfalls\r\n"
			+ "zu Ende";
	
	int pointSum1;
	int pointSum2;
	
	PairOfDice dice;
	
	public Pig() {
		this.pointSum1 = 0;
		this.pointSum2 = 0;
		this.dice = new PairOfDice();
	}
	
	private void play() {
		System.out.println(ENTRY_TEXT);
		
		while(true) {
			runPlayer1Turn();
			if(winningCondition()) break;
			runPlayer2Turn();
			if(winningCondition()) break;
		}
		
		finishGame();
		
		
	}
	public static boolean containsOne(PairOfDice dice) {
		return dice.getDice1Points() == 1 || dice.getDice2Points() == 1;
	}
	public static boolean areBothOne(Pair)
	public void runPlayer1Turn() {
		
	}
	public void runPlayer2Turn() {
		
	}
	public boolean winningCondition() {
		
	}
	public void finishGame() {
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
