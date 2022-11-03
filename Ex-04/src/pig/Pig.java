//Sigrist Cedric 22-120-844
//Moritz Scholz 22-122-071

package pig;

import dice.PairOfDice;

public class Pig {
	
	public static void main(String[] args) {
		new Pig().play();
	}
	
	
	public static final int WINNING_CONDITION = 100;
	//fancy formatting to make the players bold and colorful
	public static final String ANSI_CYAN_BI = "\u001B[36;1;3m";
	public static final String ANSI_RED_BI = "\u001B[31;1;3m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    //defining the players
    public static final String PLAYER1 = ANSI_CYAN_BI + "Spieler 1" + ANSI_RESET;
    public static final String PLAYER2 = ANSI_RED_BI + "Spieler 2" + ANSI_RESET;
	
    //a separator used to make the output more readable
	private static final String SEPARATOR = "\n------------------------------------------------------\n";
	
	//text displayed at certain stages in the game
	private static final String ENTRY_TEXT = 
			"In diesem Spiel gewinnt derjenige Spieler,\r\n"
			+ "der zuerst die Punktesumme 100 gesammelt hat. Innerhalb eines Spielzugs\r\n"
			+ "wirft der aktuelle Spieler so oft er m¨ochte je zwei Würfel\r\n"
			+ "Dabei werden alle Punkte zusammengezählt, bis entweder eine EINS gewurfelt wird, dann ist der Zug ¨\r\n"
			+ "zu Ende und alle Punkte dieses Zugs sind verloren und der andere Spieler\r\n"
			+ "ist an der Reihe, oder der Spieler die Wurfel weiterreicht und seinen Zug ¨\r\n"
			+ "freiwillig beendet. Nur in diesem Fall werden die gewurfelten Augen auf- ¨\r\n"
			+ "summiert und dem Konto des Spielers gutgeschrieben. Sollte der Spieler\r\n"
			+ "zwei EINSEN gleichzeitig wurfeln, verliert er alle bis zu diesem Zeitpunkt gesammelten Punkte auf seinem Konto und sein Zug ist ebenfalls\r\n"
			+ "zu Ende";
	//text displayed if two ones are rolled in a row
	private static final String ROLLED_2_ONES_TEXT = 
			ANSI_RED_BI+"Du hast zweimal eine 1 gewürfelt.\n"+ANSI_RESET+
			"Dein Zug ist beendet und deine Punkzahl wird auf 0 gesetzt!";
	//text displayed if a one is rolled
	private static final String ROLLED_1_ONE_TEXT = 
			"Du hast eine 1 gewürfelt\n"+
			"Dein Zug ist beendet und deine Punktzahl bleibt ";
    
	//score of player 1
	int pointSum1;
	//score of player 2
	int pointSum2;

	PairOfDice dice;

	public Pig() {
		this.pointSum1 = 0;
		this.pointSum2 = 0;
		this.dice = new PairOfDice();
	}

	/** runs a game of Pig between 2 players in the console */
	private void play() {
		System.out.println(ENTRY_TEXT);
		
		while (true) {
			System.out.println(SEPARATOR);
			System.out.println(PLAYER1 + " ist jetzt am Zug:");
			pointSum1 = getNewScore(pointSum1);
			//End the game if player 1 won
			if (pointSum1 > WINNING_CONDITION) break;
			
			System.out.println(SEPARATOR);
			System.out.println(PLAYER2 +" ist jetzt am Zug:");
			pointSum2 = getNewScore(pointSum2);
			//End the game if player 2 won
			if (pointSum2 > WINNING_CONDITION) break;
		}

		finishGame();
	}
	
	/** returns true if the a one was rolled */
	public static boolean containsOne(PairOfDice dice) {
		return dice.getDice1Points() == 1 || dice.getDice2Points() == 1;
	}
	/** returns true if two ones where rolled */
	public static boolean areBothOne(PairOfDice dice) {
		return dice.getDice1Points() == 1 && dice.getDice2Points() == 1;
	}
	
	/** returns the new score of a player with the given score in the argument */
	private int getNewScore(int score) {
		System.out.println("Deine Punktzahl ist " + score);
		int newScore = score;
		while (promptAndRoll()) {
			
			if (areBothOne(dice)) {
				System.out.println(ROLLED_2_ONES_TEXT);
				return 0;
			}
			if (containsOne(dice)) {
				System.out.println(ROLLED_1_ONE_TEXT + score);
				return score;
			}
			
			newScore += dice.getPointSum();
			System.out.println("Deine Punktzahl ist " + newScore);
			
			//Automatically stop if a the player has won
			if (newScore > WINNING_CONDITION) return newScore;
		}
		return newScore;
	}
	/** prompts the user to roll both dice, if they do print them, else return false */
	private boolean promptAndRoll() {
		if (myIO.Prompt.promptYN("möchtest du würfeln? (y/n)")) {
			this.dice.rollBoth();
			System.out.println("Du hast " + dice + " gewürfelt");
			return true;
		} else {
			return false;
		}
	}
	/** ends the game and declares a winner */
	public void finishGame() {
		
		System.out.println(SEPARATOR);
		
		if (pointSum1 > pointSum2){
			System.out.println(
					"Glückwunsch " + PLAYER1 + " hat mit " + pointSum1 + " Punkten gegen " + 
					PLAYER2 + " mit " + pointSum2 + " Punkten gewonnen");
		}else {
			System.out.println(
					"Glückwunsch " + PLAYER2 + " hat mit " + pointSum1 + " Punkten gegen " + 
					PLAYER1 + " mit " + pointSum2 + " Punkten gewonnen");
		}
	}


}
