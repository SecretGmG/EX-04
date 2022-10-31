//Sigrist Cedric 22-120-844
//Moritz Scholz 22-122-071
package myIO;

import java.util.Scanner;

//Scanners of System.in do not need to / should not be closed
@SuppressWarnings("resource")

/** Simple static class used to prompt the user for inputs */
public class Prompt {
	
	/** Asks the User to input an integer with a given message */
	public static int promptInt(String text) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(text);
		return scanner.nextInt();
	}
	
	/** Asks the User to input a double with a given message */
	public static double promptDouble(String text) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(text);
		return scanner.nextDouble();
	}
	
	/** Asks the User to input a String with a given message */
	public static String promptString(String text) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(text);
		return scanner.next();
	}
	/** Asks the User a question that can be answered by y,Y / n,N */
	public static boolean promptYN(String text) {
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.println(text);
			String userInput = scanner.next().toLowerCase();
			if(userInput.length() > 0) {
				if(userInput.charAt(0) == 'n') {
					return false;
				}
				if(userInput.charAt(0) == 'y') {
					return true;
				}
			}
			System.out.println("Your input was invalid please answer the question with y or n");
		}		
	}
	
}
