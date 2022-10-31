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

		while (true) {
			
			System.out.println("Spieler 1 ist jetzt am Zug:");
			pointSum1 = runTurn(pointSum1);
			if (winningCondition())
				break;

			System.out.println("Spieler 2 ist jetzt am Zug:");
			pointSum1 = runTurn(pointSum1);			
			if (winningCondition())
				break;
		}

		finishGame();

	}

	public static boolean containsOne(PairOfDice dice) {
		return dice.getDice1Points() == 1 || dice.getDice2Points() == 1;
	}

	public static boolean areBothOne(PairOfDice dice) {
		return dice.getDice1Points() == 1 && dice.getDice2Points() == 1;
	}

	private int runTurn(int score) {
		int newScore = score;
		while (promptAndRoll()) {
			System.out.println("Du hast " + dice + " gewürfelt");
			if (areBothOne(dice)) {
				System.out.println(
						"Was ein pech du hast zweimal eine 1 gewürfelt.\n"+
						"Deine Punktzahl auf 0 gesetzt und dein Zug ist beendet!");
				return 0;
			}
			if (containsOne(dice)) {
				System.out.println("Weil du eine 1 gewürfelt hast ist dein Zug jetzt beendet");
				System.out.println("Deine Punktzahl ist" + newScore);
			}
			newScore += dice.getPointSum();
			System.out.println("Deine neue Punktzahl ist " + newScore);
		}
		return newScore;
	}

	private boolean promptAndRoll() {
		if (myIO.Prompt.promptYN("möchtest du würfeln? (y/n)")) {
			this.dice.rollBoth();
			return true;
		} else {
			return false;
		}
	}
	public boolean winningCondition() {
		return pointSum1>WINNING_CONDITION || pointSum2>WINNING_CONDITION;
	}

	public void finishGame() {
		if (pointSum1 > pointSum2){
			System.out.println("Glückwunsch Spieler 1 hat mit " + pointSum1 + "Punkten gegen Spieler 2 mit " + pointSum2 + "Punkten gewonnen");
		}else {
			System.out.println("Glückwunsch Spieler 2 hat mit " + pointSum1 + "Punkten gegen Spieler 1 mit " + pointSum2 + "Punkten gewonnen");
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
