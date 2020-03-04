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

	private static StackListBased resStack;
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

		resStack = new StackListBased();
		postFStack = new StackListBased();
		resStack.createStack();
		postFStack.createStack();

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the infix expression to evaluate");
		String inp = input.next();

		System.out.println("postfix: " + convertPostfix(inp));
		System.out.println("result: " + evaluateInfix(convertPostfix(inp)));
	}

	/**
	 *	The algorithm to Convert Infix to PostFix. NOT WORKING

		If the character is operand, append in the List.
		If the character is operator
		2.1 check if the stack is empty. If yes then push this operator into the stack.
		2.2 Else, Pop all the operators from the stack which are greater than or equal to in precedence than that of the scanned operator. After doing that Push the scanned operator to the stack.
		3.If you have openings bracket '(', push into the stack.
		If you have closing bracket ')', pop all element from the stack until you reach '(' and add in the list.

	 * @param str infix expression
	 * @return result
	 */
	private static String convertPostfix (String str)
	{
		String out = "";
		for (int i = 0; i < str.length(); i++)
		{
			char c = str.charAt(i);
			if(c == ' ' || c == '\t' || c == '\r' || c == '\n' || Character.isWhitespace(c))
			{
				continue;
			}
			else if(checkPre(c)>0)
			{
				while(!postFStack.isEmpty() && checkPre(postFStack.peek().charAt(0)) >= checkPre(c))
				{
					out += postFStack.pop();
				}
				postFStack.push(String.valueOf(c));
			}

			else if(c=='(')
			{
				postFStack.push(String.valueOf(c));
			}
			else if(c==')')
			{
				while(!postFStack.isEmpty())
				{
					if(postFStack.peek().charAt(0) == '(')
					{
						postFStack.pop();
						break;
					}
					else
					{
						out+=postFStack.pop();
					}
				}
			}
			else
			{
				out += c;
			}
		}
		for(int i = 0; i <= postFStack.size(); i++)
		{
			out += postFStack.pop();
		}
		return out;
	}
	
	/**
	 * 	The algorithm to Calculate PostFix. NOT WORKING EXCEPT FOR SINGLE INTEGERS

		Create a stack to store operands (or values).
		Scan the ArrayList and do following for every scanned element.
		2.1) If the element is a number, push it into the stack
		2.2) If the element is an operator, pop operands for the operator from the stack. Evaluate the operator and push the result back to the stack
		When the expression is ended, the number in the stack is the final answer
	 * @param str postfix expression
	 * @return result
	 */
	private static String evaluateInfix (String str)
	{
		int x = 0, y = 0;
		char ch[] = str.toCharArray();
		for(char c: ch)
		{
			if(c >= '0' && c <= '9')
			{
				resStack.push(Integer.toString((int)(c - '0')));
			}
			else
			{
				y = Integer.parseInt(resStack.pop());
				x = Integer.parseInt(resStack.pop());
				switch(c)
				{
				case'+':
					resStack.push(Integer.toString(x + y));
					break;
				case'-':
					resStack.push(Integer.toString(x - y));
					break;
				case'*':
					resStack.push(Integer.toString(x * y));
					break;
				case'/':
					resStack.push(Integer.toString(x / y));
					break;
				}
			}
		}
		return resStack.pop();
	}

	/**
	 * check for the precedence of operands
	 * @param chr
	 * @return corresponding operands
	 */
	private static int checkPre(char chr)
	{
		switch (chr)
		{
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}
}
