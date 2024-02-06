import java.util.ArrayList;

/**
 * Sort class
 * 
 * @author Zachary Frain
 * @version 1.0
 *
 */
public class Sort {

	public static long[] iterations = new long[6];
	

	/* Selection Sort */
	
	/*
	 * The time complexity of the selection sort is O(n^2). The iterations printed in the console
	 * is around half of O(n^2), which still falls under the category of O(n^2)
	 */
	public static <E extends Comparable<E>> void selectionSort(ArrayList<E> list) {
		int minIndex;
		for (int i = 0; i < list.size() - 1; i++) {
			iterations[0]++;
			E min = list.get(i);
			minIndex = i;
			for (int j = i; j < list.size(); j++) {
				iterations[0]++;
				if (list.get(j).compareTo(min) < 0) {
					min = list.get(j);
					minIndex = j;
				}
			}
			E temp = list.get(i);
			list.set(i, list.get(minIndex));
			list.set(minIndex, temp);
		}
	}

	/* Insertion Sort */

	/*
	 * The time complexity of the insertion sort is O(n^2). The iterations printed in the console
	 * is around a quarter of O(n^2), but that still falls under the category of O(n^2)
	 */
	
	public static <E extends Comparable<E>> void insertionSort(ArrayList<E> list) {
		for(int i = 1; i < list.size(); i++) {
			iterations[1]++;
			E currentVal = list.get(i);
			int j = i;
			while(j > 0 && currentVal.compareTo(list.get(j - 1)) < 0) {
				iterations[1]++;
				list.set(j, list.get(j- 1));
				j--;
			}
			list.set(j, currentVal);
		}
	}

	/* Bubble Sort */

	/*
	 * The time complexity of the bubble sort is O(n^2). The iterations printed in the console
	 * is around a half of O(n^2), which falls under the category of O(n^2)
	 */
	public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> list) {
		boolean sorted = false;
		for (int k = 1; k < list.size() && !sorted; k++) {
			iterations[2]++;
			sorted = true;
			for (int i = 0; i < list.size() - k; i++) {
				iterations[2]++;
				if (list.get(i).compareTo(list.get(i + 1)) > 0) {
					swap(list, i, i+1);
					sorted = false;
				}
			}
		}
	}

	/* Merge Sort */
	
	/*
	 * The time complexity of the merge sort is O(n logn). The iterations printed in the console
	 * is slightly more than that, but it is still close enough to fall under the category of O(n logn)
	 */
	public static <E extends Comparable<E>> void mergeSort(ArrayList<E> list) {
		iterations[3]++;
		if (list.size() > 1) {
			ArrayList<E> firstHalf = subList(list, 0, list.size()/2);
			ArrayList<E> secondHalf = subList(list, list.size()/2, list.size());
			
			mergeSort(firstHalf);
			mergeSort(secondHalf);
			merge(firstHalf, secondHalf, list);
		}
	}

	public static <E> ArrayList<E> subList(ArrayList<E> list, int start, int end) {
		ArrayList<E> newList = new ArrayList<>();
		for (int i = start; i < end; i++) {
			iterations[3]++;
			newList.add(list.get(i));
		}
		return newList;
	}

	public static <E extends Comparable<E>> void merge(ArrayList<E> list1, ArrayList<E> list2, ArrayList<E> list) {
		int list1Index = 0;
		int list2Index = 0;
		int listIndex = 0;

		while (list1Index < list1.size() && list2Index < list2.size()) {
			iterations[3]++;
			if (list1.get(list1Index).compareTo(list2.get(list2Index)) < 0) {
				list.set(listIndex++, list1.get(list1Index++));
			} else {
				list.set(listIndex++, list2.get(list2Index++));
			}
		}
		while (list1Index < list1.size()) {
			iterations[3]++;
			list.set(listIndex++, list1.get(list1Index++));
		}

		while (list2Index < list2.size()) {
			iterations[3]++;
			list.set(listIndex++, list2.get(list2Index++));
		}
	}

	/* QuickSort */

	/*
	 * The time complexity of the quick sort is O(n logn). The iterations printed in the console
	 * is slightly more than O(n logn), but the difference isn't enough to where the sorting
	 * would have a different time complexity.
	 * 
	 */
	public static <E extends Comparable<E>> void quickSort(ArrayList<E> list) {
		quickSort(list, 0, list.size() - 1);
	}

	public static <E extends Comparable<E>> void quickSort(ArrayList<E> list, int first, int last) {
		iterations[4]++;
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}

	public static <E extends Comparable<E>> int partition(ArrayList<E> list, int first, int last) {
		E pivot;
		int index, pivotIndex;
		pivot = list.get(first);
		pivotIndex = first;
		for (index = first + 1; index <= last; index++) {
			iterations[4]++;
			if (list.get(index).compareTo(pivot) < 0) {
				pivotIndex++;
				swap(list, pivotIndex, index);
			}
		}
		swap(list, first, pivotIndex);
		return pivotIndex;
	}

	public static <E extends Comparable<E>> void swap(ArrayList<E> list, int index1, int index2) {
		E temp = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, temp);
	}

	/* Heap Sort */

	/*
	 * The time complexity for the heap sort is O(n logn). The iterations printed in the console
	 * are relatively close to what O(n logn) would be, so this sort does belong in the O(n logn) category
	 */
	public static <E extends Comparable<E>> void heapSort(ArrayList<E> list) {
		Heap<E> heap = new Heap<>();
		for (int i = 0; i < list.size(); i++) {
			iterations[5]++;
			heap.add(list.get(i));
		}

		for (int i = list.size() - 1; i >= 0; i--) {
			iterations[5]++;
			list.set(i, heap.remove());
		}

	}
	/**
	 * Method used to reset the values in the iterations array
	 */
	public static void resetValues() {
		for(int i = 0; i < iterations.length; i++) {
			iterations[i] = 0;
		}
	}

}
