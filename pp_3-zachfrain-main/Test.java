import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Test class used to test the HashMapSC, HashMapLP and HashMapEntry implementations
 * @author Zachary Frain
 * @version 1.0
 */
public class Test {
	/**
	 * Main method used to print messages the the console
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<>();
		readToAL(words, "dictionary.txt");
		/**
		 * Testing the put(key, value) method for both classes HashMapSC and HashMapLP
		 * 
		 * For the first three HashMaps (sizes 10000, 20000 and 30000), the put() method for the HashMapLP class has less collisions
		 * than the put() method for the HashMapSC. However, after the HashMaps with size 30000, the HashMapSC put() method has much less collisions.
		 * For sizes 40000, 50000 and 60000, the HashMapSC put() method has 5,000 less collisions than the HashMapLP put() method. For the last four sizes
		 * 70000, 80000, 90000 and 100000, the HashMapSC put() method still has less collisions than the HashMapLP put() method, but the difference is only about 400
		 * collisions.
		 */
		System.out.println("Testing put(key, value) - Number of collisions\n");
		System.out.printf("%-5s%15s%15s\n", "Size", "HashMap(SC)", "HashMap(LP)");
		HashMapLP<String, String> LP1 = new HashMapLP(10000);
		HashMapSC<String, String> SC1 = new HashMapSC(10000);
		readToSC(SC1, "dictionary.txt");
		readToLP(LP1,"dictionary.txt");
		System.out.printf("%-5d%15d%15d\n", 10000, SC1.collisions, LP1.collisions);
		HashMapLP<String, String> LP2 = new HashMapLP(20000);
		HashMapSC<String, String> SC2 = new HashMapSC(20000);
		readToSC(SC2, "dictionary.txt");
		readToLP(LP2,"dictionary.txt");
		System.out.printf("%-5d%15d%15d\n", 20000, SC2.collisions, LP2.collisions);
		HashMapLP<String, String> LP3 = new HashMapLP(30000);
		HashMapSC<String, String> SC3 = new HashMapSC(30000);
		readToSC(SC3, "dictionary.txt");
		readToLP(LP3, "dictionary.txt");
		System.out.printf("%-5d%15d%15d\n", 30000, SC3.collisions, LP3.collisions);
		HashMapLP<String, String> LP4 = new HashMapLP(40000);
		HashMapSC<String, String> SC4 = new HashMapSC(40000);
		readToSC(SC4, "dictionary.txt");
		readToLP(LP4, "dictionary.txt");
		System.out.printf("%-5d%15d%15d\n", 40000, SC4.collisions, LP4.collisions);
		HashMapLP<String, String> LP5 = new HashMapLP(50000);
		HashMapSC<String, String> SC5 = new HashMapSC(50000);
		readToSC(SC5, "dictionary.txt");
		readToLP(LP5, "dictionary.txt");
		System.out.printf("%-5d%15d%15d\n", 50000, SC5.collisions, LP5.collisions);
		HashMapLP<String, String> LP6 = new HashMapLP(60000);
		HashMapSC<String, String> SC6 = new HashMapSC(60000);
		readToSC(SC6, "dictionary.txt");
		readToLP(LP6, "dictionary.txt");
		System.out.printf("%-5d%15d%15d\n", 60000, SC6.collisions, LP6.collisions);
		HashMapLP<String, String> LP7 = new HashMapLP(70000);
		HashMapSC<String, String> SC7 = new HashMapSC(70000);
		readToSC(SC7, "dictionary.txt");
		readToLP(LP7, "dictionary.txt");
		System.out.printf("%-5d%15d%15d\n", 70000, SC7.collisions, LP7.collisions);
		HashMapLP<String, String> LP8 = new HashMapLP(80000);
		HashMapSC<String, String> SC8 = new HashMapSC(80000);
		readToSC(SC8, "dictionary.txt");
		readToLP(LP8, "dictionary.txt");
		System.out.printf("%-5d%15d%15d\n", 80000, SC8.collisions, LP8.collisions);
		HashMapLP<String, String> LP9 = new HashMapLP(90000);
		HashMapSC<String, String> SC9 = new HashMapSC(90000);
		readToSC(SC9, "dictionary.txt");
		readToLP(LP9, "dictionary.txt");
		System.out.printf("%-5d%15d%15d\n", 90000, SC9.collisions, LP9.collisions);
		HashMapLP<String, String> LP10 = new HashMapLP(100000);
		HashMapSC<String, String> SC10 = new HashMapSC(100000);
		readToSC(SC10, "dictionary.txt");
		readToLP(LP10, "dictionary.txt");
		System.out.printf("%-5d%14d%15d\n", 100000, SC10.collisions, LP10.collisions);
		
		/**
		 * Testing the get(key) method for both the HashMapSC and HashMapLP classes.
		 * 
		 * From the results that are printed, usually the HashMapSC get() method has less iterations than the HashMapLP get() method. The difference
		 * between the two methods is very little because the average iteration number over 1000 calls to the method is 1 for both the HashMapSC
		 * and the HashMapLP. Most calls to the get() method for both classes only have one iteration, with very few having more than one for the
		 * HashMapSC, but more calls having iteration numbers of 2,3 or even 4 for example.
		 */
		System.out.println("\nTesting get(key) - Number of iterations\n");
		System.out.printf("%-25s%15s%15s\n", "Word", "HashMap(SC)", "HashMap(LP)");
		int avgSC = 0; int avgLP = 0;
		for(int i = 0; i < 1000; i++) {
			int randomNumber = (int)(Math.random() * words.size());
			if(i % 50 == 0) {
				SC5.get(words.get(randomNumber));
				LP5.get(words.get(randomNumber));
				System.out.printf("%-25s%15d%15d\n", words.get(randomNumber), SC5.iterations, LP5.iterations);
			}
			avgSC += SC5.iterations;
			avgLP += LP5.iterations;
		}
		avgSC = (int)(avgSC / 1000);
		avgLP = (int)(avgLP / 1000);
		System.out.printf("\n%-25s%15d%15d", "Average", avgSC, avgLP);
	}
	/**
	 * Method used to read a file to a HashMapSC
	 * @param hm The HashMapSC having the file read to
	 * @param filename The name of the file being read from
	 */
	public static void readToSC(HashMapSC<String, String> hm, String filename) {
		File file = new File(filename);
		Scanner readFile = null;
		try {
			readFile = new Scanner(file);
			while(readFile.hasNextLine()){
				String line = readFile.nextLine();
				String tokens[] = line.split("\\|");
				String word = tokens[0];
				String definition = tokens[1];
				
				hm.put(word, definition);
			}
		} catch(FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
	}
	/**
	 * Method used to read a file to a HashMapLP
	 * @param hm The HashMapLP having the file read to
	 * @param filename The name of the file being read from
	 */
	public static void readToLP(HashMapLP<String, String> hm, String filename) {
		File file = new File(filename);
		Scanner readFile = null;
		try {
			readFile = new Scanner(file);
			while(readFile.hasNextLine()){
				String line = readFile.nextLine();
				String tokens[] = line.split("\\|");
				String word = tokens[0];
				String definition = tokens[1];
				
				hm.put(word, definition);
			}
		} catch(FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
	}
	/**
	 * Method used to read a file to an ArrayList
	 * @param al The ArrayList having the file read to
	 * @param filename The name of the file being read from
	 */
	public static void readToAL(ArrayList<String> al, String filename) {
		File file = new File(filename);
		Scanner readFile = null;
		try {
			readFile = new Scanner(file);
			while(readFile.hasNextLine()) {
				String line = readFile.nextLine();
				String tokens[] = line.split("\\|");
				String word = tokens[0];
				
				al.add(word);
			}
		} catch(FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
	}
}
