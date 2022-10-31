package dice;

public class PairOfDice {
	private Dice dice1;
	private Dice dice2;
	
	public PairOfDice() {
		this.dice1 = new Dice();
		this.dice2 = new Dice();		
	}
	/** rolls both dice */
	public void rollBoth() {
		this.dice1.roll();
		this.dice2.roll();
	}
	/** calculates and returns the sum of points of the 2 dice */
	public int getPointSum() {
		return dice1.getPoints() + dice2.getPoints();
	}
	public Dice getDice1() {
		return dice1;
	}
	public void setDice1(Dice dice1) {
		this.dice1 = dice1;
	}
	public Dice getDice2() {
		return dice2;
	}
	public void setDice2(Dice dice2) {
		this.dice2 = dice2;
	}
	
}
