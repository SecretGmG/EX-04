//Sigrist Cedric 22-120-844
//Moritz Scholz 22-122-071
package coin;
import java.util.Random;


public class Coin {
	private boolean isHead;
	private Random rand;
	
	
	

	public Coin() {
		this.rand = new Random();
		this.flip();
	}
	
	/** flips the Coin and reassigns the isHead field randomly 
	 * returns true if the coin landed on head, else false*/
	public boolean flip() {
		this.isHead = rand.nextBoolean();
		return isHead;
	}
	public boolean isHead() {
		return this.isHead;
	}
	public boolean isTails() {
		return !this.isHead;
	}
	public String toString() {
		return isHead ? "Head" :  "Tails";
	}
	public boolean equals(Coin other) {
		return isHead == other.isHead;
	}
	
	
	
}
