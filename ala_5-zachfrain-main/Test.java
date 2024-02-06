import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
/**
 * @author Zachary Frain
 * @version 1.0
 */
public class Test {
	/**
	 * Main class, used to run the program, show menus, read user input, etc.
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Reading a states file and creating the ArrayList of states pairs
		 */
		ArrayList<Pair<String, String>> states;
		states = new ArrayList<>();
		readStatesFromFile(states, "states.txt");
		/**
		 * Reading a trees file and creating the ArrayList of trees pairs
		 */
		ArrayList<Pair<String, Integer>> trees;
		trees = new ArrayList<>();
		readTreesFromFile(trees, "trees.txt");
		
		Scanner keyboard = new Scanner(System.in);
		int operation = 0;
		int operation2 = 0;
		int ending = 0;
		int ending2 = 0;
		/**
		 * Do-While loop used to allow the user to interact with the states menu.
		 */
		 do {
			printStatesMenu();
			operation = keyboard.nextInt();
			switch(operation) {
		/**
		 * The first case, which prints the states ArrayList
		 */
		case 1:
				for(Pair<String, String> p: states) {
					System.out.println(p);
				}
				break;
		/**
		 * The second case, which is to search for a state in the states ArrayList
		 */
		case 2:
				System.out.println("Enter a state");
				keyboard.nextLine();
				String state = keyboard.nextLine();
				
				int in = search(states, state);
				if(search(states,state) != -1) {
					System.out.println("State found: " + states.get(in));
				}
				else if(search(states,state) == -1){
					System.out.println("State not found.");
				}
				break;
		/**
		 * The third case, which is to sort the states ArrayList in alphabetical order by state name
		 */
		case 3:
				states.sort(new ComparatorByFirst<String, String>());
				break;
		/**
		 * The fourth case, which is to sort the states ArrayList in alphabetical order by capital name
		 */
		case 4:
				states.sort(new ComparatorBySecond<String, String>());
				break;
		/**
		 * The fifth case, which is to access the trees menu.
		 */
		case 5:
				/**
				 * Do-While loop used to allow the user to interact with the trees menu
				 */
				do {
					printTreeMenu();
					operation2 = keyboard.nextInt();
					switch(operation2) {
					/**
					 * The first case, which prints the trees ArrayList
					 */
					case 1:
						for(Pair<String, Integer> p: trees) {
							System.out.println(p);
						}
						break;
					/**
					 * The second case, which is to search for a tree in the trees ArrayList
					 */
					case 2:
						System.out.println("Enter a tree");
						keyboard.nextLine();
						String tree = keyboard.nextLine();
						int index2 = search(trees, tree);
						if(index2 != -1) {
							System.out.println("Tree found: " + trees.get(index2));
						} else {
							System.out.println("Tree not found.");
						}
						break;
					/**
					 * The third case, which is to sort the trees ArrayList in alphabetical order by tree name
					 */
					case 3:
						trees.sort(new ComparatorByFirst<String, Integer>());
						break;
					/**
					 * The fourth case, which is to sort the trees ArrayList in height order, least to greatest
					 */
					case 4:
						trees.sort(new ComparatorBySecond<String, Integer>());
						break;
					/**
					 * The fifth and last case, which leaves the trees menu and goes back to the states menu
					 */
					case 5: 
						break;
					}
				} while(operation2 != 5);
				break;
			/**
			 * The sixth and last case, which exits the program
			 */
			case 6:
				System.out.println("Thank you for using my program");
				System.exit(0);
				break;
			}
		} while(operation != 6);
	 }
	
	/**
	 * Method used to find the index of a specified E1 object in a list
	 * @param <E1> The first object in a pair
	 * @param <E2> The second object in a pair
	 * @param list The list being searched through 
	 * @param key The E1 object being searched for
	 * @return The index in 'list' of the E1 object that key is equal to. If key is not found in list, -1 is returned instead
	 */
	public static <E1, E2> int search(ArrayList<Pair<E1, E2>> list, E1 key) {
		for(int i=0; i<list.size(); i++) {
			Pair<E1, E2> p = list.get(i);
			if(p.getFirst().equals(key)) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Prints the states menu to the console
	 */
	public static void printStatesMenu() {
		System.out.println("Select an operation:");
		System.out.println("1) View all the states");
		System.out.println("2) Search");
		System.out.println("3) Sort by name");
		System.out.println("4) Sort by capital");
		System.out.println("5) View tree menu");
		System.out.println("6) Exit");
	}
	/**
	 * Prints the trees menu to the console
	 */
	public static void printTreeMenu() {
		System.out.println("Select an operation:");
		System.out.println("1) View all the trees");
		System.out.println("2) Search");
		System.out.println("3) Sort by name");
		System.out.println("4) Sort by height");
		System.out.println("5) Return for the states menu");
	}
	/**
	 * The method used to read the states file and put the values into an ArrayList
	 * @param list The ArrayList that is having the states added to it
	 * @param filename The name of the file that is being read from
	 */
	public static void readStatesFromFile(ArrayList<Pair<String, String>> list, String filename) {
		File file = new File(filename);
		try {
			Scanner readFile = new Scanner(file);
			while(readFile.hasNextLine()) {
				String line = readFile.nextLine();
				String[] tokens = line.split("\\|");
				String name = tokens[0];
				String capital = tokens[1];
				Pair<String, String> p = new Pair<>(name, capital);
				list.add(p);
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
	}
	/**
	 * The method used to read the trees file and put the values into an ArrayList
	 * @param list The ArrayList that is having the trees added to it
	 * @param filename The name of the file that is being read from
	 */
	public static void readTreesFromFile(ArrayList<Pair<String, Integer>> list, String filename) {
		File file = new File(filename);
		try {
			Scanner readFile = new Scanner(file);
			while(readFile.hasNextLine()) {
				String line = readFile.nextLine();
				int ind = line.indexOf("|");
				String name = line.substring(0, ind);
				String height = line.substring(ind + 1);
				int h = Integer.parseInt(height);
				
				Pair<String, Integer> p = new Pair<>(name, h);
				list.add(p);				
			}	
		} catch(FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
	}
}
