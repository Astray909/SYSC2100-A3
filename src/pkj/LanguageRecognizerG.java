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

	static String str;

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
		if(str.isEmpty())
		{
			System.out.println("true");
			return true;
		}
		else if(str.length() == 1 && checkE(str.charAt(0)))
		{
			System.out.println("true");
			return true;
		}
		else if(str.length() == 2 && checkV(str.charAt(0)) && checkE(str.charAt(1)))
		{
			System.out.println("true");
			return true;
		}
		System.out.println("false");
		return false;//return false if invalid
	}

	/**
	 * check if char is of E type
	 * @param ch char to be tested
	 * @return true if is type E
	 */
	private static boolean checkE(char ch)
	{
		if(ch == 'W' || ch == 'A')
		{
			return true;
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
		if(ch == '&' || ch == '#')
		{
			return true;
		}
		return false;//return false if not V
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.print("Enter the G-language word to check:");
        str=input.next();
        recursiveRecogG(str);
	}

}
