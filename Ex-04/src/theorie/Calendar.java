//Sigrist Cedric 22-120-844
//Moritz Scholz 22-122-071

package theorie;

public class Calendar {
	
	public static void main(String[] args) {
		System.out.println("2022:" + isLeapYear(2022));
		System.out.println("2000:" + isLeapYear(2000));
		System.out.println("1900:" + isLeapYear(1900));
		System.out.println("1500:" + isLeapYear(1500));
	}
	
	/** calculates if a year is a leap year 
	 * prints error and returns false if the year is not within the bounds */
	public static boolean isLeapYear(int year) {
		final int LOWER_BOUND = 1582;
		
		if(year < LOWER_BOUND) {
			System.out.println("The year is outside the bounds of this function! False was returned");
			return false;
		}
		
		if(year % 400 == 0) return true;		
		if(year % 100 == 0) return false;
		if(year % 4 == 0) return true;
		
		return false;
	}
}
