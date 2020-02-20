/**
 * 
 */
package pkj;

import java.util.*;

/**
 * @author Jia Chen Huang 101073186
 * @version Feb 19, 2020
 *
 */
public class LanguageRecognizerG {

	static String str;//string to check

	/**
	 * 
	 */
	public LanguageRecognizerG() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Check if a string is language G
	 * @return true of valid grammar of language G
	 */
	private static boolean recursiveRecogG(String str)
	{
		if(str.isEmpty())//test for empty string
		{
			return true;
		}
		else if(str.length() == 1 && checkE(str.charAt(0)))//test for E
		{
			return true;
		}
		else if(str.length() == 2 && checkV(str.charAt(0)) && checkE(str.charAt(1)))//test for VE
		{
			return true;
		}
		else if(checkE(str.charAt(0)) && checkV(str.charAt(str.length() - 1)))//test for EGV with recursion
		{
			recursiveRecogG(str.substring(1,str.length()-1));
			return true;
		}
		return false;//return false if invalid
	}

	/**
	 * check if char is of E type
	 * @param ch char to be tested
	 * @return true if is type E
	 */
	private static boolean checkE(char ch)
	{
		if(ch == '&' || ch == '#')
		{
			return true;//true if E
		}
		return false;//return false if not E
	}

	/**
	 * check if char is of V type
	 * @param ch char to be tested
	 * @return true if is type V
	 */
	private static boolean checkV(char ch)
	{
		if(ch == 'W' || ch == 'A')
		{
			return true;//true if V
		}
		return false;//return false if not V
	}

	/**
	 * prints out IS or is NOT depends on the situation
	 * @param gee is G or not G
	 * @return IS if is, is NOT if is not
	 */
	private static String printOut(boolean gee)
	{
		if(gee)
		{
			return "IS";
		}
		else
		{
			return "is NOT";
		}
	}

	/**
	 * main function
	 * @param args
	 */
	public static void main(String[] args) {
		//code for input scanner
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the G-language word to check:\n");
		str=input.next();

		//printout
		System.out.println("Recursion: Word \"" + str + "\" " + printOut(recursiveRecogG(str)) + " a word of the G language\n");

		//want to run again?
		Scanner again = new Scanner(System.in);
		System.out.print("type in Y to run again, or any other string to exit the program\n");
		String A =again.next();
		if(A.equals("Y"))
		{
			main(args);//run main again if yes
		}
		else
		{
			System.out.println("Thank you for using, quitting...");
			System.exit(1);
		}
	}

}
