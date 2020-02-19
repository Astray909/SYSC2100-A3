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
	
	String str;

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
	private boolean recursiveRecogG(String str)
	{
		str = this.str;
		if(str.isEmpty())
		{
			return true;
		}
		else if(str.length() == 1 && checkE(str.charAt(0)))
		{
			return true;
		}
		//else if()
		
		return true;//return true of the language is valid
	}
	
	/**
	 * check if char is of E type
	 * @param ch char to be tested
	 * @return true if is type E
	 */
	private boolean checkE(char ch)
	{
		return true;
	}
	
	/**
	 * check if char is of V type
	 * @param ch char to be tested
	 * @return true if is type V
	 */
	private boolean checkV(char ch)
	{
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Scanner input = 
	}

}
