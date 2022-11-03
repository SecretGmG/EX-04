//Sigrist Cedric 22-120-844
//Moritz Scholz 22-122-071

package theorie;

public class Loops {
	public static void main(String[] args) {
		fooWithFor();
		fooWithWhile();
	}
	
	private static void fooWithFor() {
		int value = 0;
		for (int num = 10; num <= 40; num+=10) {
			value += num;
		}
		System.out.println(value);
	}
	private static void fooWithWhile(){
		int value = 0;
		int num = 10;
		while(num<=40){
			value += num;
			num+=10;
		}
		System.out.println(value);
	}
}
