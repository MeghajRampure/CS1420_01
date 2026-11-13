
package assign09;

import java.util.Arrays;

/**
 * This class represents a better dynamic array of AudioEvents,
 * doubling the length of the backing array when more space is needed
 * and never shrinking.
 *
 * @author CS 1420 course staff and Meghaj Rampure
 * @version November 12, 2026
 */
public class BetterDynamicArray {

	// DO NOT ADD OR REMOVE ANY INSTANCE VARIABLES
	private AudioEvent[] elements;
	private int elementCount;

	/**
	 * Creates a dynamic array with space for ten elements.
	 */
	public BetterDynamicArray() {
		elements = new AudioEvent[10];
		elementCount = 0;
	}

	/**
	 * Appends the given AudioEvent to the end of this dynamic array.
	 *
	 * @param value the AudioEvent to append
	 */
	public void add(AudioEvent value) {
		insert(elementCount, value);
	}

	/**
	 * Inserts a given AudioEvent at a given index.
	 *
	 * @param index the index at which to insert
	 * @param value the AudioEvent to insert
	 * @throws IndexOutOfBoundsException if the index is invalid
	 */
	public void insert(int index, AudioEvent value) {
		if (index < 0 || index > elementCount) {
			throw new IndexOutOfBoundsException();
		}

		if (elementCount == elements.length) {
			doubleBackingArray();
		}

		for (int i = elementCount; i > index; i--) {
			elements[i] = elements[i - 1];
		}

		elements[index] = value;
		elementCount++;
	}

	/**
	 * Doubles the length of the backing array.
	 */
	private void doubleBackingArray() {
		AudioEvent[] largerArray = new AudioEvent[elements.length * 2];

		for (int i = 0; i < elements.length; i++) {
			largerArray[i] = elements[i];
		}

		elements = largerArray;
	}

	/**
	 * Gets the AudioEvent at the given index.
	 *
	 * @param index the index of the element
	 * @return the element at the given index
	 * @throws IndexOutOfBoundsException if the index is invalid
	 */
	public AudioEvent get(int index) {
		if (index < 0 || index >= elementCount) {
			throw new IndexOutOfBoundsException();
		}

		return elements[index];
	}

	/**
	 * Returns the number of elements in this dynamic array.
	 *
	 * @return the number of elements
	 */
	public int size() {
		return elementCount;
	}

	/**
	 * Changes the element at the given index.
	 *
	 * @param index the index of the element
	 * @param value the new AudioEvent value
	 * @throws IndexOutOfBoundsException if the index is invalid
	 */
	public void set(int index, AudioEvent value) {
		if (index < 0 || index >= elementCount) {
			throw new IndexOutOfBoundsException();
		}

		elements[index] = value;
	}

	/**
	 * Removes the element at the given index.
	 *
	 * @param index the index of the element to remove
	 * @throws IndexOutOfBoundsException if the index is invalid
	 */
	public void remove(int index) {
		if (index < 0 || index >= elementCount) {
			throw new IndexOutOfBoundsException();
		}

		for (int i = index; i < elementCount - 1; i++) {
			elements[i] = elements[i + 1];
		}

		elementCount--;
		elements[elementCount] = null;
	}

	/**
	 * Removes the first element equal to the given value.
	 *
	 * @param value the AudioEvent to remove
	 */
	public void remove(AudioEvent value) {
		int index = -1;

		for (int i = 0; i < elementCount; i++) {
			if (elements[i].equals(value)) {
				index = i;
				break;
			}
		}

		if (index != -1) {
			remove(index);
		}
	}

	/**
	 * Removes all elements from the dynamic array.
	 */
	public void clear() {
		elementCount = 0;
	}

	/**
	 * Sorts the elements from smallest to largest.
	 */
	public void sort() {
		Arrays.sort(elements, 0, elementCount);
	}

	/**
	 * Generates a textual representation of this dynamic array.
	 *
	 * @return the textual representation
	 */
	public String toString() {
		String result = "[";

		if (size() > 0) {
			result += get(0);
		}

		for (int i = 1; i < size(); i++) {
			result += ", " + get(i);
		}

		return result + "] backing array length: " + elements.length;
	}
}
