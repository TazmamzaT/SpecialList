import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 * A SpecialList is a singly-linked list without header/trailer nodes.
 * What is special about it is that although duplicate values are allowed, there
 * will never be two consecutive elements with the same value.
 * For example, [4,9,4] is ok, but [4,4,9] should never occur.
 */
public class SpecialList extends AbstractSpecialList {
	private Node top = null;
	private int length = 0;

    /**
     * Add an value to the list at a given position.
     * All values starting at that position are moved over one position.
     * If the position is less than or equal to 0, the new value is added to
     * the front of the list.
     * If the position is greater than or equal to the number of elements in
     * the list, the new value is added to the end of the list.
     * Make sure the resulting list does not have two consecutive equal values.
     *
     * @param pos The position.
     * @param value The value to be added.
     */
	public void add(int pos, int value) {
    	if (length == 0) {
    		top = new Node(value, null);
    		length++;
    	} else if ( pos <= 0 && value != top.getValue() ) {
    		top = new Node(value, top);
    		length++;
    	} else if ( pos >= this.length() ) { 
    		Node current = top;
    		while (current.getNext() != null) {
    			current = current.getNext();
    		}
    		if (current.getValue() != value) {
	    		current.setNext(new Node(value, null));
	    		length++;
    		}
    	} else {
    		Node current = top;
    		for (int i = 0; i < pos; i++) {
    			current = current.getNext();
    		}
    		if (current.getValue() != value) {
    			Node addMe = new Node (value, current.getNext());
        		current.setNext(addMe);
        		length++;
    		}
    	}
    	
	} // end of add method

    /**
     * Get the current length of the list.
     *
     * @return The current length.
     */
    public int length() {
    	return length;
	} // end of length method

    /**
     * Remove all values from the list.
     */
    public void clear() {
    	if (length != 0 || this != null) {
    		Node current = top;
    		top = null;
    		while (current != null) {
    			Node next = current.getNext();
    			current.setNext(null);
    			current = next;
    		}
    	}
	} // end of clear method

    /**
     * Get the value at the given position.
     *
     * @param pos The position to get the value from.
     *            If position is less than 0, the first element is assumed.
     *            If position is greater than or equal to the number of
     *            elements in the list, the last element is assumed
     *
     * @return The value at the given position.
     *         If there are no values in the list, 0 is returned.
     */
    public int valueAt(int pos) {
    	if (length == 0) {
    		return 0;
    	} else if ( pos <= 0 ) {
    		return top.getValue();
    	} else if ( pos >= this.length() ) { 
    		Node current = top;
    		while (current.getNext() != null) {
    			current = current.getNext();
    		}
    		return current.getValue();
    	} else {
    		Node current = top;
    		for (int i = 0; i < pos - 1; i++) {
    			current = current.getNext();
    		}
    		return current.getValue();
    	}
	} // end of valueAt method

    /**
     * Find the positions of all occurrences of a given value.
     *
     * @param value The value to search for.
     *
     * @return The positions of the value in the list (the positions
     *         should be in increasing order).
     * 	       If the value is not in the list, return a vector with no
     * 	       elements.
     */
    public Vector<Integer> positionsOf(int value) {
    	Vector<Integer> vector = new Vector<Integer>();
    	int count = 0;
    	if (this != null) {
    		Node current = top;
    		while (current != null) {
    			if (value == current.getValue()) {
    				vector.add(count);
    			}
    		}
    		count++;
    	}
	return vector;
	} // end of positionsOf method

    /**
     * Remove the value at the given position.
     * Make sure the resulting list does not have two consecutive equal values.
     *
     * @param pos The position of the value to be omit.
     *            If position is less than 0, the first element is assumed.
     *            If position is greater than or equal to the number of
     *            elements in the list, the last element is assumed
     */
    public void omit(int pos) {

	} // end of omit method

    /**
     * Shuffle the list.
     * Split the list in half (with the extra element if the list has an odd
     * number of elements) in the first half.
     * Then construct a new list by starting with the first element if the
     * first half, then appending the first element of the second list, then
     * appending the second element of the first list, then appending the
     * second element of the second list, etc.
     * For example, if the list is [1,2,3,4,5,6,7], then the list after
     * shuffling is [1,5,2,6,3,7,4].
     * Make sure the resulting list does not have two consecutive equal values.
     */
    public void shuffle() { 
    	int mod = length % 2;
    	Node current = top;
    	SpecialList half1 = new SpecialList();
    	SpecialList half2 = new SpecialList();
    	if (mod == 0) {
    		while(current.getNext() != null) {
    			for (int i = 0; i < length / 2; i++) {
    				half1.add(i, this.valueAt(i));
    			}
    			for (int i = length / 2; i < length / 2; i++) {
    				half2.add(i, this.valueAt(i));
    			}
    		}
    	} else if (mod == 1) {
    		while(current.getNext() != null) {
    			for (int i = 0; i < (int)(length / 2 + 1); i++) {
    				half1.add(i, this.valueAt(i));
    			}
    			for (int i = (int)(length / 2); i < (int)(length / 2); i++) {
    				half2.add(i, this.valueAt(i));
    			}
    		}
    	}
	} // end of shuffle method

    /**
     * Move the largest value in the list to the end of the list.
     * If the largest value occurs more than once, move the last occurrence of
     * that value to the end.
     * For example, if the list is [4,9,3,2,9,6,0], then afterwards is
     * [4,9,3,2,6,0,9].
     * Make sure the resulting list does not have two consecutive equal values.
     */
    public void move() { 

	} // end of move method

    } // end of SpecialList class