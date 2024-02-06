import java.util.ArrayList;

public class Heap<E extends Comparable<E>> {
	private ArrayList<E> list;
	
	public Heap() {
		list = new ArrayList<>();
	}
	public int size() {
		return list.size();
	}
	public boolean isEmpty() {
		return list.isEmpty();
	}
	public void clear() {
		list.clear();
	}
	public String toString() {
		return list.toString();
	}
	public int contains(E item) { //O(n log n)
		int iterations = 0;
		for(int i=0; i<list.size(); i++) {
			iterations++;
			if(list.get(i).equals(item))
				return iterations;
		}
		return iterations;
	}
	public int add(E item) { //O(log n)
		int iterations = 0;
		list.add(item);
		int currentIndex = list.size() - 1;
		while(currentIndex > 0) {
			iterations++;
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
		return iterations;
	}
	public int remove() { //O(log n)
		int iterations = 0;
		if(list.size() == 0) {
			return iterations;
		}
		E removedItem = list.get(0);
		list.set(0,  list.get(list.size()-1));
		list.remove(list.size()-1);
		int currentIndex = 0;
		while(currentIndex < list.size()) {
			iterations++;
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
		return iterations;
	}
	//Height Method
	public int height() { //O(log n)
		int height = 0;
		return height(height);
	}
	public int height(int height) { //O(log n)
		if(height <= list.size())
			return 1 + Math.max(height(height * 2 + 1), height(height * 2 + 2));
		else
			return 0;
	}
	//isBalanced Method
	public boolean isBalanced() { //O(log n)
		int x = 0;
		return isBalanced(x);
	}
	public boolean isBalanced(int x) { //O(log n)
		if(x >= list.size())
			return true;
		if(Math.abs(height(x * 2 + 1) - height(x * 2 + 2)) > 1)
			return false;
		else
			return isBalanced(x * 2 + 1) && isBalanced(x * 2 + 2);
	}
}
