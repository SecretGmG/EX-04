//Sigrist Cedric 22-120-844
//Moritz Scholz 22-122-071

package theorie;

public class Counter {
	public static void main(String[] args) {
		System.out.println("alsdfn: " + countA("alsdfn"));
		System.out.println("aaaaaa: " + countA("aaaaaa"));
		System.out.println("<empty String> :" + countA(""));
	}
	/** counts the number of a's in a String */
	public static int countA(String name) {
		return countChar(name, 'a');
	}
	/** counts the number of times a char occurs in a String */
	public static int countChar(String str, char chr) {
		int count = 0;
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i) == chr) count++;
		}
		return count;
	}
}
