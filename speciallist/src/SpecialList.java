import java.util.Vector;

/**
 * A SpecialList is a singly - linked list without header / trailer nodes. What
 * is special about it is that although duplicate values are allowed, there will
 * never be two consecutive elements with the same value. For example, [4, 9, 4]
 * is ok, but [4, 4, 9] should never occur.
 */
@SuppressWarnings("serial")
public class SpecialList extends AbstractSpecialList {
	private int length = 0;

	/**
	 * Add an value to the list at a given position. All values starting at that
	 * position are moved over one position. If the position is less than or
	 * equal to 0, the new value is added to the front of the list. If the
	 * position is greater than or equal to the number of elements in the list,
	 * the new value is added to the end of the list. Make sure the resulting
	 * list does not have two consecutive equal values.
	 *
	 * @param pos
	 *            The position.
	 * @param value
	 *            The value to be added.
	 */
	public void add(int pos, int value) {
		if (first == null) {
			first = new Node(value, null);
			length++;
		} else if (pos <= 0) {
			if (value != first.getValue()) {
				Node current = first;
				first = new Node(value, current);
				length++;
			}
		} else if (pos >= length()) {
			Node current = first;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			if (current.getValue() != value) {
				current.setNext(new Node(value, null));
				length++;
			}
		} else { 
			Node current = first;
			Node previous = null;
			for (int i = 0; i < pos; i++) {
				previous = current;
				current = current.getNext();
			}
			if (current.getValue() != value) {
				Node addMe = new Node(value, current);
				previous.setNext(addMe);
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
		if (first == null) {
			return 0;
		} else {
			return length;
		}
	} // end of length method

	/**
	 * Remove all values from the list.
	 */
	public void clear() {
		if (length != 0 || this != null) {
			Node current = first;
			first = null;
			while (current != null) {
				Node next = current.getNext();
				current.setNext(null);
				current = next;
			}
		}
		length = 0;
	} // end of clear method

	/**
	 * Get the value at the given position.
	 *
	 * @param pos
	 *            The position to get the value from. If position is less than
	 *            0, the first element is assumed. If position is greater than
	 *            or equal to the number of elements in the list, the last
	 *            element is assumed
	 *
	 * @return The value at the given position. If there are no values in the
	 *         list, 0 is returned.
	 */
	public int valueAt(int pos) {
		if (first == null) {
			return 0;
		} else if (pos < 0) {
			return first.getValue();
		} else if (pos >= length) {
			Node current = first;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			return current.getValue();
		} else {
			Node current = first;
			for (int i = 0; i < pos; i++) {
				current = current.getNext();
			}
			return current.getValue();
		}
	} // end of valueAt method

	/**
	 * Find the positions of all occurrences of a given value.
	 *
	 * @param value
	 *            The value to search for .
	 *
	 * @return The positions of the value in the list (the positions should be
	 *         in increasing order). If the value is not in the list, return a
	 *         vector with no elements.
	 */
	public Vector<Integer> positionsOf(int value) {
		Vector<Integer> vector = new Vector<Integer>();
		for (int i = 0; i < length; i++) {
			if (value == valueAt(i)) {
				vector.add(i);
			}
		}
		return vector;
	} // end of positionsOf method

	/**
	 * Remove the value at the given position. Make sure the resulting list does
	 * not have two consecutive equal values.
	 *
	 * @param pos
	 *            The position of the value to be omit. If position is less than
	 *            0, the first element is assumed. If position is greater than
	 *            or equal to the number of elements in the list, the last
	 *            element is assumed
	 */
	public void omit(int pos) {
		if (first != null) {
			if (pos <= 0) {
				Node oldfirst = first;
				first = first.getNext();
				oldfirst.setNext(null);
				length--;
			} else if (pos >= length() - 1) {
				if (length > 1) {
					Node current = first;
					Node previous = null;
					while (current.getNext() != null) {
						previous = current;
						current = current.getNext();
					}
					previous.setNext(null);
					length--;
				} else {
					clear();
				}
			} else {
				Node current = first;
				Node previous = null;
				for (int i = 0; i < pos; i++) {
					previous = current;
					current = current.getNext();
				}
				previous.setNext(current.getNext());
				length--;
				if (previous.getValue() == previous.getNext().getValue()) {
					omit(pos);
				}
			} 
		}
	} // end of omit method

	/**
	 * Shuffle the list. Split the list in half (with the extra element if the
	 * list has an odd number of elements) in the first half. Then construct a
	 * new list by starting with the first element if the first half, then
	 * appending the first element of the second list, then appending the second
	 * element of the first list, then appending the second element of the
	 * second list, etc. For example, if the list is [1, 2, 3, 4, 5, 6, 7], then
	 * the list after shuffling is [1, 5, 2, 6, 3, 7, 4]. Make sure the
	 * resulting list does not have two consecutive equal values.
	 */
	public void shuffle() {
		if (first != null || length != 1 || length != 2) {
			SpecialList half1 = new SpecialList();
			SpecialList half2 = new SpecialList();
			if (length % 2 == 0) {
				for (int i = 0; i < length; i++) {
					if (i < length / 2) {
						half1.add(i, valueAt(i));
					} else {
						half2.add(i, valueAt(i));
					}
				}
			} else {
				for (int i = 0; i < length; i++) {
					if (i < (length / 2) + 1) {
						half1.add(i, valueAt(i));
					} else {
						half2.add(i, valueAt(i));
					}
				}
			}
			int oldlength = length;
			clear();
			for (int i = 0; i < oldlength; i++) {
				if (i % 2 == 0) {
					add(i, half1.valueAt(0));
					half1.omit(0);
				} else {
					add(i, half2.valueAt(0));
					half2.omit(0);
				}
			}
		}
	} // end of shuffle method

	/**
	 * Move the largest value in the list to the end of the list. If the largest
	 * value occurs more than once, move the last occurrence of that value to
	 * the end. For example, if the list is [4, 9, 3, 2, 9, 6, 0], then afterwards is
	 * [4, 9, 3, 2, 6, 0, 9]. Make sure the resulting list does not have two
	 * consecutive equal values.
	 */
	public void move() {
		if (first != null && length != 1) {
			int largest = Integer.MIN_VALUE;
			Node current = first;
			while (current.getNext() != null) {
				if (current.getValue() > largest) {
					largest = current.getValue();
				}
				current = current.getNext();
			}
			Vector<Integer> indexes = positionsOf(largest);
			add(length, largest);
			omit(indexes.lastElement());
		}

	} // end of move method

} // end of SpecialList class