import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class AnimalDB {

	public static void main(String[] args) {
		BST<String> animalBST = new BST<>();
		Heap<String> animalHeap = new Heap<>();
		ArrayList<String> animalAL = new ArrayList<>();
		
		File file = new File("animals.txt");
		Scanner readFile = null;
		int it = 0;
		
		try {
			readFile = new Scanner(file);
		} catch(FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
		/*
		 * The number of iterations in the add method for the BST and Heap are relatively
		 * similar, but the Heap's is lower because the height of the Heap is less than
		 * the BST's height. 
		 */
		System.out.println("Testing add()           	  BST            Heap\n");
		int BSTAvg = 0;
		int HeapAvg = 0;
		while(readFile.hasNextLine()) {
			String line = readFile.nextLine();
			if(it <= 24) {
				
				int aBST = animalBST.add(line);
				int aHeap = animalHeap.add(line);
				
				BSTAvg += aBST;
				HeapAvg += aHeap;
				
				String j = String.format("%-25s", line);
				String k = String.format("%10d", aBST);
				String l = String.format("%15d", aHeap);
				System.out.println(j + k + l);
				
			}
			animalBST.add(line);
			animalHeap.add(line);
			animalAL.add(line);
			it++;
		}
		BSTAvg = (int)(BSTAvg / 24);
		HeapAvg = (int)(HeapAvg / 24);
		
		String a1 = String.format("%-25s", "Average");
		String a2 = String.format("%10d", BSTAvg);
		String a3 = String.format("%15d", HeapAvg);
		System.out.println("\n"+ a1 + a2 + a3);
		System.out.println("------------------------------------------------------------");

		BSTAvg = 0; HeapAvg = 0;
		/*
		 * The number of iterations in the contains method for the BST and Heap are very different.
		 * The BST's number of iterations is much lower than the iterations for the Heap because
		 * the Heap's time complexity is n * logn which is bound to be more than the BST's number
		 * of iterations with a time complexity of n.
		 */
		System.out.println("Testing contains()                BST            Heap\n");
		for(int i = 0; i<20; i++) {
			int x = (int) (Math.random() * animalAL.size());
			
			String line2 = animalAL.get(x);
			int aBST2 = animalBST.contains(line2);
			int aHeap2 = animalHeap.contains(line2);
			
			BSTAvg += aBST2;
			HeapAvg += aHeap2;
			
			String q = String.format("%-25s", line2);
			String w = String.format("%11d", aBST2);
			String e = String.format("%16d", aHeap2);
			System.out.println(q + w + e);
		}
		BSTAvg = (int)(BSTAvg / 24);
		HeapAvg = (int)(HeapAvg / 24);
		
		String a4 = String.format("%-25s", "Average");
		String a5 = String.format("%11d", BSTAvg);
		String a6 = String.format("%16d", HeapAvg);
		System.out.println("\n"+ a4 + a5 + a6);
		System.out.println("------------------------------------------------------------");

		BSTAvg = 0; HeapAvg = 0;
		/*
		 * The remove method in both the BST and Heap have a similar number of iterations, but the
		 * BST usually has more. The time complexity for both is n, but since the BST's height is more
		 * the number of iterations will be too (for most calls of the remove method)
		 */
		System.out.println("Testing remove()                  BST              Heap\n");
		for(int i = 0; i<20; i++) {
			int f = (int) (Math.random() * animalAL.size());
			
			String line3 = animalAL.get(f);
			int aBST3 = animalBST.remove(line3);
			int aHeap3 = animalHeap.remove();
			
			BSTAvg += aBST3;
			HeapAvg += aHeap3;
			
			String z = String.format("%-25s", line3);
			String x = String.format("%11d", aBST3);
			String c = String.format("%16d", aHeap3);
			System.out.println(z + x + c);
		}
		BSTAvg = (int)(BSTAvg / 24);
		HeapAvg = (int)(HeapAvg / 24);
		
		String a7 = String.format("%-25s", "Average");
		String a8 = String.format("%11d", BSTAvg);
		String a9 = String.format("%16d", HeapAvg);
		System.out.println("\n"+ a7 + a8 + a9);
	}
	

}
