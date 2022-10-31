package coin;

public class CoinRace {
	
	public static final int WINNING_CRITERIA = 3;
	
	public static void main(String[] args) {
		runCoinRace();
		
		
	}
	
	
	public static void runCoinRace() {
		Coin coin1 = new Coin();
		Coin coin2 = new Coin();
		
		int streak1 = 0;
		int streak2 = 0;
		
		int i = 0;
		
		while(streak1 < 3 && streak2 < 3) {
			i++;			
			if (coin1.flip()) {
				streak1++;
			}
			else {
				streak1 = 0;
			}
			if (coin2.flip()) {
				streak2++;
			}
			else {
				streak2 = 0;
			}
			printCoinRaceRound(i,coin1,coin2);
		}
		printCoinRaceResult(streak1,streak2);
	}
	public static void printCoinRaceResult(int streak1, int streak2) {
		
		if(streak1>streak2) {
			System.out.println("Münze 1 gewinnt!");
		}
		else if(streak2>streak1) {
			System.out.println("Münze 2 gewinnt!");
		}
		else {
			System.out.println("Es war ein Unentschieden!");
		}
		
	}
	public static void printCoinRaceRound(int i, Coin coin1, Coin coin2) {
		System.out.println("Runde " + i + ": " + coin1 + " " + coin2);
	}
}
