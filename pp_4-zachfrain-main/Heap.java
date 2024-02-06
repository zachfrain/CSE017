import java.util.ArrayList;
/**
 * Heap Implementation
 * @author Zachary Frain
 * @version 1.0
 *
 * @param <E>
 */
public class Heap<E extends Comparable<E>> {
	/**
	 * Data members
	 */
	private ArrayList<E> list;
	/**
	 * No-arg constructor for a Heap
	 */
	public Heap() {
		list = new ArrayList<>();
	}
	/**
	 * getter for the size of the Heap
	 * @return int value representing the size of the Heap
	 */
	public int size() {
		return list.size();
	}
	/**
	 * boolean method used to determine if a Heap is empty
	 * @return true if empty, false if not
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	/**
	 * method used to clear a Heap
	 */
	public void clear() {
		list.clear();
	}
	/**
	 * toString() method
	 */
	public String toString() {
		return list.toString();
	}
	/**
	 * search method used to determine if E item is in the Heap
	 * @param item E value being searched for
	 * @return the number of iterations to find the item
	 */
	public int contains(E item) { //O(n log n)
		int iterations = 0;
		for(int i=0; i<list.size(); i++) {
			iterations++;
			if(list.get(i).equals(item))
				return iterations;
		}
		return iterations;
	}
	/**
	 * add method used to add E item to the Heap
	 * @param item E value being added to the Heap
	 * @return the number of iterations to add the item
	 */
	public void add(E item) { //O(log n)
		int iterations = 0;
		list.add(item);
		int currentIndex = list.size() - 1;
		while(currentIndex > 0) {
			Sort.iterations[5]++;
			int parentIndex = (currentIndex - 1)/2;
			E current = list.get(currentIndex);
			E parent = list.get(parentIndex);
			if(current.compareTo(parent) > 0) {
				list.set(currentIndex, parent);
				list.set(parentIndex, current);
			} else {
				break;
			}
			currentIndex = parentIndex;
		}
	}
	/**
	 * remove method used to remove an item from the Heap
	 * @return the number of iterations to remove the item
	 */
	public E remove() { //O(log n)
		int iterations = 0;
		E removedItem = list.get(0);
		list.set(0,  list.get(list.size()-1));
		list.remove(list.size()-1);
		int currentIndex = 0;
		while(currentIndex < list.size()) {
			Sort.iterations[5]++;
			int left = 2 * currentIndex + 1;
			int right = 2 * currentIndex + 2;
			if(left >= list.size()) {
				break;
			}
			int maxIndex = left;
			E max = list.get(maxIndex);
			if(right < list.size()) {
				if(max.compareTo(list.get(right)) < 0) {
					maxIndex = right;
				}
			}
			E current = list.get(currentIndex);
			max = list.get(maxIndex);
			if(current.compareTo(max) < 0) {
				list.set(maxIndex, current);
				list.set(currentIndex, max);
				currentIndex = maxIndex;
			} else {
				break;
			}
		}
		return removedItem;
	}
	/**
	 * helper method used to get the height of the Heap
	 * @return int value representing the height of the Heap
	 */
	public int height() { //O(log n)
		int height = 0;
		return height(height);
	}
	/**
	 * height method for the Heap
	 * @param height int value representing the height being searched at
	 * @return int value representing the height of the Heap
	 */
	public int height(int height) { //O(log n)
		if(height <= list.size())
			return 1 + Math.max(height(height * 2 + 1), height(height * 2 + 2));
		else
			return 0;
	}
	/**
	 * helped method used to determine if the Heap is balanced
	 * @return true if balanced, false if not
	 */
	public boolean isBalanced() { //O(log n)
		int x = 0;
		return isBalanced(x);
	}
	/**
	 * method used to determine if the Heap is balanced
	 * @param x int value representing the height being searched at
	 * @return true if balanced, false if not
	 */
	public boolean isBalanced(int x) { //O(log n)
		if(x >= list.size())
			return true;
		if(Math.abs(height(x * 2 + 1) - height(x * 2 + 2)) > 1)
			return false;
		else
			return isBalanced(x * 2 + 1) && isBalanced(x * 2 + 2);
	}
}
