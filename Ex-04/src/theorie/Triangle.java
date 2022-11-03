//Sigrist Cedric 22-120-844
//Moritz Scholz 22-122-071

package theorie;

public class Triangle {
	public static void main(String[] args) {
		System.out.println("(3,4,5): " + isIsoceles(3,4,5));
		System.out.println("(5,5,5): " + isIsoceles(5,5,5));
		System.out.println("(3,4,3): " + isIsoceles(3,4,3));
		System.out.println("(2,2,7): " + isIsoceles(2,2,7));
		System.out.println("(1,8,8): " + isIsoceles(1,8,8));
		
	}
	/** returns true if the triangle described by the inputs
	 *  is isoceles but not equilateral */
	public static boolean isIsoceles(int a, int b, int c) {
		//Early return if the triangle is equilateral
		if(a==b && b==c) return false;
		//True if any two sides are equal
		return a==b || b==c || c==a;
	}
}
