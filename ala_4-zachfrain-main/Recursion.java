import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public class Recursion {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a directory:");
		String path = keyboard.next();
		System.out.println("Enter a filename:");
		String filename = keyboard.next();
		String found = searchFile(path, filename);
		if(found.equals("")) {
			System.out.println("File " + filename + " not found.");
		}
		else {
			System.out.println("File " + filename + " found at: " + found);
		}
		System.out.println("Etner a file/directory:");
		path = keyboard.next();
		System.out.println("Enter a word:");
		String word = keyboard.next();
		findWord(path, word);
	}
	/**
	 * Searches for a file
	 * @param path The path of the file
	 * @param filename The name of the file
	 * @return
	 */
	public static String searchFile(String path, String filename) {
		File dir = new File(path);
		if(!dir.isDirectory()) {
			return "";
		} else {
			File[] files = dir.listFiles();
			for(int i=0; i<files.length; i++) {
				if(files[i].isFile()) {
					if(files[i].getName().equals(filename)) {
						return files[i].getAbsolutePath();
					}
				}
				else if(files[i].isDirectory()) {
					String found = searchFile(files[i].getAbsolutePath(), filename);
					if(!found.equals("")) {
						return found;
					}
				}
			}
		}
		return "";
	}
	/**
	 * Finds a word in a file
	 * @param path The path of the file
	 * @param word The word being searched for
	 */
	public static void findWord(String path, String word) {
		File file = new File(path);
		if(file.isFile()) {
			int count = countWord(file,word);
			if(count != 0) {
				System.out.println(word + " found " + count + " times in " + file.getAbsolutePath());
			}
		}
		else if(file.isDirectory()) {
			File[] files = file.listFiles();
			for(int i=0; i<files.length; i++) {
				findWord(files[i].getAbsolutePath(), word);
			}
		}
	}
	/**
	 * Counts how many times a word appears in a file
	 * @param file The file that is being searched
	 * @param word The word that is being searched for
	 * @return The amount of times the word appears in the file
	 */
	public static int countWord(File file, String word) {
		int count = 0;
		try {
			Scanner readFile = new Scanner(file);
			while(readFile.hasNextLine()) {
				String line = readFile.nextLine();
				int index = line.indexOf(word, 0);
				while(index != -1) {
					count++;
					index = line.indexOf(word, index+1);
				}
			}
			readFile.close();
			return count;
		}
		catch(FileNotFoundException e) {
			return 0;
		}
	}
}
