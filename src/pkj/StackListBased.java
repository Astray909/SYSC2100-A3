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

	LinkedList<Character> items;
	Character top;
	/**
	 * empty constructor
	 */
	public StackListBased() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * create a new LinkedList of strings
	 */
	void createStack()
	{
		items = new LinkedList<Character>();
	}

	/**
	 * clone to all of items to a new List re, return that string, and clear items
	 * @return the cloned list that contains all the original items
	 */
	LinkedList<Character> popAll()
	{
		LinkedList<Character> re = new LinkedList<Character>();
		re = (LinkedList<Character>) items.clone();
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
	void push(Character item)
	{
		items.add(item);
	}

	/**
	 * pops the top item
	 * @return the item popped
	 */
	Character pop()
	{
		top =items.getLast();
		items.removeLast();
		return top;
	}

	/**
	 * peeks the top item
	 * @return the item peeked
	 */
	Character peek()
	{
		top = items.getLast();
		return top;
	}

	/**
	 * main function
	 * @param args
	 */
	public static void main(Character[] args) {
		// TODO Auto-generated method stub

	}

}
