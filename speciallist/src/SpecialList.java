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
    	} else if ( pos <= 0 ) {
    		top = new Node(value, top);
    	} else if ( pos > this.length() ) { 
    		Node current = top;
    		while (current.getNext() != null) {
    			current = current.getNext();
    		}
    		current.setNext(new Node(value, null));
    	} else {
    		Node current = top;
    		for (int i = 0; i < pos - 1; i++) {
    			current = current.getNext();
    		}
    		current.setNext(new Node(value, current));
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

	return 0;
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

	return null;
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