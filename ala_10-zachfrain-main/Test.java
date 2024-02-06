import java.util.ArrayList;
import java.util.Collections;

public class Test {
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>(100000);
		
		final int SIZE = 100000;
		for(int i = 0; i < SIZE; i++) {
			int random = (int)(Math.random() * (SIZE - 1)) + 1;
			numbers.add(random);
		}
		
		Sort.selectionSort(numbers);
		
		Collections.shuffle(numbers);
		Sort.insertionSort(numbers);
		
		Collections.shuffle(numbers);
		Sort.bubbleSort(numbers);
		
		Collections.shuffle(numbers);
		Sort.mergeSort(numbers);
		
		Collections.shuffle(numbers);
		Sort.quickSort(numbers);
		
		Collections.shuffle(numbers);
		Sort.heapSort(numbers);
		
		System.out.println("Dataset Size: 100,000");
		System.out.printf("%-20s\t%-10s\n", "Sorting Algorithm", "Number Of Iterations");
		
		String[] algorithms = {"Selection Sort", "Insertion Sort", "Bubble Sort", "Merge Sort", "Quick Sort", "Heap Sort"};
		
		for(int i = 0; i < Sort.iterations.length; i++) {
			System.out.printf("%-20s\t%-10d\n", algorithms[i], Sort.iterations[i]);
		}

	}

}
