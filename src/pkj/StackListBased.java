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
	 * empty constructor
	 */
	public StackListBased() {
		// TODO Auto-generated constructor stub
		items = new LinkedList<String>();
	}

	/**
	 * create a new LinkedList of strings
	 */
	void createStack()
	{
		items = new LinkedList<String>();
	}

	/**
	 * clone to all of items to a new List re, return that string, and clear items
	 * @return the cloned list that contains all the original items
	 */
	LinkedList<String> popAll()
	{
		LinkedList<String> re = new LinkedList<String>();
		re = (LinkedList<String>) items.clone();
		items.clear();
		return re;
	}

	/**
	 * to see if items is empty
	 * @return true of empty
	 */
	boolean isEmpty()
	{
		return items.isEmpty();
	}

	/**
	 * add item to items
	 * @param item
	 */
	void push(String item)
	{
		items.add(item);
	}

	/**
	 * pops the top item
	 * @return the item popped
	 */
	String pop()
	{
		top =items.getLast();
		items.removeLast();
		return top;
	}

	/**
	 * peeks the top item
	 * @return the item peeked
	 */
	String peek()
	{
		top = items.getLast();
		return top;
	}
	
	int size()
	{
		return items.size();
	}

	/**
	 * main function
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
