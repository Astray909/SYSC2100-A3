/**
 * 
 */
package pkj;

import java.util.*;
import java.lang.Exception;

/**
 * @author Jia Chen Huang
 * @version Feb 20, 2020
 *
 */
public class InfixCalculator {

	private static StackListBased inFStack;
	private static StackListBased postFStack;

	/**
	 * 
	 */
	public InfixCalculator() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws RuntimeException{

		inFStack = new StackListBased();
		postFStack = new StackListBased();
		inFStack.createStack();
		postFStack.createStack();

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the infix expression to evaluate");
		String inp = input.next();
	}

	/**
	 *	The algorithm to Convert Infix to PostFix.

		If the character is operand, append in the List.
		If the character is operator
		2.1 check if the stack is empty. If yes then push this operator into the stack.
		2.2 Else, Pop all the operators from the stack which are greater than or equal to in precedence than that of the scanned operator. After doing that Push the scanned operator to the stack.
		3.If you have openings bracket '(', push into the stack.
		If you have closing bracket ')', pop all element from the stack until you reach '(' and add in the list.

	 * @param str
	 * @return
	 */
	private List<String> itpCon (String str)
	{
		boolean fg = false;
		List<String> post = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++)
		{
			char ch = str.charAt(i);
			if(ch == ' ')//test to see if a space is present
			{
				continue;
			}
			if(checkCH(ch) == 0)
			{
				fg = false;
				postFStack.push(ch);
			}
			else if(checkCH(ch) == 2)
			{
				fg = false;
				if(postFStack.isEmpty())
				{
					postFStack.push(ch);
				}
				else
				{
					while(!postFStack.isEmpty() && checkPre(postFStack.peek(), ch))
					{
						post.add(postFStack.pop()+"");
					}
					postFStack.push(ch);
				}
			}
			else if(checkCH(ch) == 1)
			{
				fg = false;
				while(!postFStack.isEmpty())
				{
					if(checkCH(postFStack.peek()) == 1)
					{
						postFStack.pop();
						break;
					}
					else
					{
						post.add(postFStack.pop() + "");
					}
				}
			}
			else
			{
				if(fg)
				{
					String lastNumber = post.get(post.size()-1);
					lastNumber += ch;
					post.set(post.size()-1, lastNumber);
				}
				else
				{
					post.add(ch + "");
					fg = true;
				}
			}
		}
		while(!postFStack.isEmpty())
		{
			post.add(postFStack.pop()+"");
		}
		return post;
	}

	private int checkCH(char chr)
	{
		if(chr == '(')
		{
			return 0;
		}
		else if(chr == ')')
		{
			return 1;
		}
		else if(chr == '+' || chr== '-' || chr == '*' || chr == '/')
		{
			return 2;
		}
		else
		{
			return -1;
		}
	}

	private boolean checkPre(char sta, char sca)
	{
		if(sta == '+' || sta == '-')
		{
			if(sca == '+' || sca == '-')
			{
				return true;
			}
			else if(sca == '*' || sca == '/')
			{
				return false;
			}
		}
		else if(sta == '*' || sta == '/')
		{
			return true;
		}
		return false;
	}
}
