import java.util.ListIterator;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Test {
	
	public static void main(String[] args) {
		ArrayList<String> aList = new ArrayList<String>();
		LinkedList<String> lList = new LinkedList<String>();
		DoublyLinkedList<String> dlList= new DoublyLinkedList<String>();
		
		readFromFile(aList, "countries.txt");
		readFromFile(lList, "countries.txt");
		readFromFile(dlList, "countries.txt");
		
		System.out.println("ArrayList forward:");
		printListBackward(aList);
		System.out.println();
		System.out.println("\nLinkedList forward:");
		printListForward(lList);
		System.out.println();
		System.out.println("\nDoublyLinkedList forward:");
		printListForward(dlList);
		System.out.println();
		
		System.out.println("\nArrayList backward:");
		printListForward(aList);
		System.out.println();
		System.out.println("\nLinkedList backward:");
		printListBackward(lList);
		System.out.println();
		System.out.println("\nDoublyLinkedList backward:");
		printListBackward(dlList);
	}
	
	public static void readFromFile(List<String> list, String filename) {
		File file = new File(filename);
		try {
			Scanner readFile = new Scanner(file);
			while(readFile.hasNextLine()) {
				String line = readFile.nextLine();
				list.add(line);
			}
		} catch(FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
	}
	
	public static <E> void printListBackward(List<E> list) {
		ListIterator<E> iterator = list.listIterator();
		System.out.print("[");
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.print("]");
	}
	public static <E> void printListForward(List<E> list) {
		ListIterator<E> iterator = list.listIterator(list.size());
		System.out.print("[");
		while(iterator.hasPrevious()) {
			System.out.print(iterator.previous() + " ");
		}
		System.out.print("]");
	}
}
