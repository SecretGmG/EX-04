//Sigrist Cedric 22-120-844
//Moritz Scholz 22-122-071

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
		return getDice1Points() + getDice2Points();
	}
	public int getDice1Points() {
		return dice1.getPoints();
	}
	public void setDice1Points(int dice1) {
		this.dice1.setPoints(dice1);
	}
	public int getDice2Points() {
		return dice2.getPoints();
	}
	public void setDice2Points(int dice2) {
		this.dice2.setPoints(dice2);
	}
	public String toString() {
		return getDice1Points() + ", " + getDice2Points();
	}
}
