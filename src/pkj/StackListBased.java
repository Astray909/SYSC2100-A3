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
public class StackListBased {

	LinkedList<String> items;
	String top;
	/**
	 * constructor
	 */
	public StackListBased() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * create a new LinkedList of strings
	 */
	private void createStack()
	{
		items = new LinkedList<String>();
	}

	/**
	 * clone to all of items to a new List re, return that string, and clear items
	 * @return the cloned list that contains all the original items
	 */
	private LinkedList<String> popAll()
	{
		LinkedList<String> re = new LinkedList<String>();
		re = (LinkedList<String>) items.clone();
		items.clear();
		return re;
	}

	private boolean isEmpty()
	{
		return items.isEmpty();
	}

	private void push()
	{
		return;
	}

	private String pop()
	{
		String s=items.getLast();
		items.removeLast();
		return s;
	}

	private void peek()
	{
		return;
	}
	/**
	 * main function
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
