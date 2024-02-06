import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public class Airplane {
	private char[][] seatMap;
	/**
	 * Creates an airplane with no parameters
	 */
	public Airplane() {
		seatMap = new char[9][8];
		for(int i=0; i<seatMap.length; i++) {
			for(int j=0; j<seatMap[i].length; j++) {
				seatMap[i][j] = '.';
			}
		}
	}
	/**
	 * Creates an airplane with the seatMap input in the parameter
	 * @param filename The file that contains the seatMap
	 */
	public Airplane(String filename) {
		seatMap = new char[9][8];
		readMap(filename);
	}
	/**
	 * Loads seatMap filename on to a blank seatMap
	 * @param filename The seatMap that is being read.
	 */
	private void readMap(String filename) {
		File file = new File(filename);
		try {	
		Scanner readFile = new Scanner(file);
		for(int i=0; i<seatMap.length; i++) {
			for(int j=0; j<seatMap[i].length; j++) {
				seatMap[i][j] = readFile.next().charAt(0);
			}
		}
		readFile.close();
		}
		catch(FileNotFoundException e) {
			for(int i=0; i<seatMap.length; i++) {
				for(int j=0; j<seatMap[i].length; j++) {
					seatMap[i][j] = '.';
				}
			}
		}
	}
	/**
	 * Determines whether a seat is free or reserved
	 * 
	 * @param seat The seat that is being checked
	 * @return
	 * @throws InvalidSeatException The exception thrown if there is an invalid seat number.
	 */
	private boolean checkSeat(String seat) throws InvalidSeatException{
		if(seat.matches("[1-9][A-H]")) {
			return true;
		} else {
			throw new InvalidSeatException("Invalid seat number. Must be [1-9][A-H]");
		}
	}
	/**
	 * Reserves a free seat.
	 * 
	 * @param seat The seat that is being reserved
	 * @return
	 * @throws InvalidSeatException The exception thrown if the seat is already reserved.
	 */
	public boolean reserveSeat(String seat) throws InvalidSeatException{
		if(checkSeat(seat)) {
			int row = seat.charAt(0)-'1';
			int col = seat.charAt(1)-'A';
			if(seatMap[row][col]=='.') {
				seatMap[row][col] = 'X';
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	/**
	 * Frees a reserved seat.
	 * 
	 * @param seat The seat that is being freed
	 * @return
	 * @throws InvalidSeatException The exception thrown if the seat is already freed.
	 */
	public boolean freeSeat(String seat) throws InvalidSeatException{
		if(checkSeat(seat)) {
			int row = seat.charAt(0)-'1';
			int col = seat.charAt(1)-'A';
			if(seatMap[row][col]=='X') {
				seatMap[row][col] = '.';
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	/**
	 * Saves a map.
	 * 
	 * @param filename The map that is being saved.
	 */
	public void saveMap(String filename) {
		File file = new File(filename);
		try {
			PrintWriter writeFile = new PrintWriter(file);
			for(int i=0; i<seatMap.length; i++) {
				for(int j=0; j<seatMap[i].length; j++) 
					writeFile.print(seatMap[i][j] + " ");
				writeFile.println();
			}
			writeFile.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Cannot write to " + filename);
		}
	}
	/**
	 * Prints the seatMap to the console.
	 */
	public String toString() {
		String output = "\tA\tB\tC\tD\tE\tF\tG\tH\n";
		for(int i=0; i<seatMap.length; i++) {
			output += (i+1) + "\t";
			for(int j=0; j < seatMap[i].length; j++) {
				output += seatMap[i][j] + "\t";
			}
			output += "\n";
		}
		return output;
	}
}
