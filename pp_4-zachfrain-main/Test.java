import java.util.ArrayList;
import java.util.Collections;

public class Test {
	public static void main(String[] args) {
		final int SIZE = 10000;
		
		ArrayList<Integer> randomList = new ArrayList<>(SIZE);
		for(int i = 0; i < SIZE; i++) {
			int random = (int)(Math.random() * (SIZE - 1)) + 1;
			randomList.add(random);
		}
		ArrayList<Integer> sortedList = (ArrayList<Integer>) randomList.clone();
		ArrayList<Integer> reversedList = (ArrayList<Integer>) randomList.clone();
		
		String[] algorithms = {"Selection Sort", "Insertion Sort", "Bubble Sort", "Merge Sort", "Quick Sort", "Heap Sort"};
		long[] random = {0,0,0,0,0,0};
		long[] sorted = {0,0,0,0,0,0};
		long[] reversed = {0,0,0,0,0,0};
		
		System.out.println("Dataset Size: " + SIZE);
		System.out.printf("%-20s\t%10s\t%10s\t%10s\n", "Sorting Algorithm","Random","Sorted","Reversed");
		
		/* Sorting the random list */
		Sort.selectionSort(randomList);
		
		Collections.shuffle(randomList);
		Sort.insertionSort(randomList);
		
		Collections.shuffle(randomList);
		Sort.bubbleSort(randomList);
		
		Collections.shuffle(randomList);
		Sort.mergeSort(randomList);
		
		Collections.shuffle(randomList);
		Sort.quickSort(randomList);
		
		Collections.shuffle(randomList);
		Sort.heapSort(randomList);
		
		for(int i = 0; i < random.length; i++) {
			random[i] = Sort.iterations[i];
		}
		Sort.resetValues();
		
		/* Sorting the sorted list */
		Collections.sort(sortedList);
		
		Sort.selectionSort(sortedList);
		Sort.insertionSort(sortedList);
		Sort.bubbleSort(sortedList);
		Sort.mergeSort(sortedList);
		Sort.quickSort(sortedList);
		Sort.heapSort(sortedList);
		
		for(int i = 0; i < sorted.length; i++) {
			sorted[i] = Sort.iterations[i];
		}
		Sort.resetValues();
		
		/* Sorting the reversed list */
		Collections.sort(reversedList);
		Collections.reverse(reversedList);
		
		Sort.selectionSort(reversedList);
		Collections.reverse(reversedList);
		
		Sort.insertionSort(reversedList);
		Collections.reverse(reversedList);
		
		Sort.bubbleSort(reversedList);
		Collections.reverse(reversedList);
		
		Sort.mergeSort(reversedList);
		Collections.reverse(reversedList);
		
		Sort.quickSort(reversedList);
		Collections.reverse(reversedList);
		
		Sort.heapSort(reversedList);
		Collections.reverse(reversedList);
		
		for(int i = 0; i < reversed.length; i++) {
			reversed[i] = Sort.iterations[i];
		}
		
		/* Printing out the iteration values for each sort on each list */
		for(int i = 0; i < algorithms.length; i++) {
			System.out.printf("%-20s\t%10d\t%10d\t%10d\n", algorithms[i], random[i], sorted[i], reversed[i]);
		}
		
		/*
		 * Selection Sort: Regardless of the order of the list, selection sort iterates
		 * through the list the same amount of times. The time complexity is O(n^2).
		 * 
		 * Insertion Sort: The worst case for the insertion sort is if the list is reversed. Next
		 * is random, which is half of the iterations the reversed list had. If the list is sorted,
		 * the number of iterations will be O(n) instead of O(n^2)
		 * 
		 * Bubble Sort: For bubble sort, the time complexity is O(n^2) and it is unchanged if the list
		 * is either random or reversed. However, if the list is sorted, the time complexity is O(n).
		 * Very similar to the insertion sort's iterations.
		 * 
		 * Merge Sort: The time complexity is O(n logn). No matter the order of the list, the same number
		 * of iterations will occur.
		 * 
		 * Quick Sort: The time complexity is O(n logn). However, the worst case is O(n^2). For the random list,
		 * the time complexity is O(n logn), but for the sorted and reversed list, the time complexity is
		 * O(n^2).
		 * 
		 * Heap Sort: The time complexity is O(n logn). The time complexity is O(n logn) for all of the lists,
		 * but the sorted list has about double the iterations of the other two lists. The sorted list
		 * still has a time complexity of O(n logn), but it does have about double than the other two which are also
		 * O(n logn)
		 */
		
	}
}
