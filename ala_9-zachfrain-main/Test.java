import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Test {
	
	public static void main(String[] args) {
		HashMap<String, String> hashMap = new HashMap(50000);
		LinkedList<String> linkedList = new LinkedList();
		BST<String> BST = new BST();
		ArrayList<String> words = new ArrayList();
		
		File file = new File("dictionary.txt");
		Scanner readFile = null;
		
		try {
			readFile = new Scanner(file);
			while(readFile.hasNext()) {
				String line = readFile.nextLine();
				String[] tokens = line.split("\\|");
				String word = tokens[0];
				String definition = tokens[1];
				
				words.add(word);
				hashMap.put(word, definition);
			}
			
		} catch(FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
		
		java.util.Collections.shuffle(words);
		for(int i = 0; i < words.size(); i++) {
			linkedList.add(words.get(i));
			BST.add(words.get(i));
		}
		//Iterations for three search operations
		String q = String.format("%-25s", "Number of iterations");
		String w = String.format("%10s", "LinkedList");
		String e = String.format("%10s", "BST");
		String r = String.format("%10s", "HashMap");
		System.out.println(q + w + e + r + "\n");
		
		int llTotal = 0; int bstTotal = 0; int hTotal = 0;
		for(int i = 0; i < 1000; i++) {
			int rNum = (int)(Math.random() * words.size());
			String str = words.get(rNum);
			hashMap.get(str);
			int linkedIterations = linkedList.contains(str);
			int bstIterations = BST.contains(str);
			int hashIterations = HashMap.iterations;
			llTotal += linkedIterations; bstTotal += bstIterations; hTotal += hashIterations;
			if(i % 50 == 0) {
				String a = String.format("%-25s", str);
				String b = String.format("%10d", linkedIterations);
				String c = String.format("%10d", bstIterations);
				String d = String.format("%10d", hashIterations);
				System.out.println(a + b + c + d);
			}
		}
		llTotal /= 1000; bstTotal /= 1000; hTotal /= 1000;
		
		String a = String.format("%-25s", "Average");
		String b = String.format("%10d", llTotal);
		String c = String.format("%10d", bstTotal);
		String d = String.format("%10d", hTotal);
		System.out.println("\n"+ a + b + c + d);
		
		
		System.out.println("\nMaximum number of collisions: " + hashMap.collisions());
	}
	
}
