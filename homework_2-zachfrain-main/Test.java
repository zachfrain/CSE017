/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class Test {
/**
 * Main method
 * @param args
 */
	public static void main(String[] args) {
		Room[] rooms = new Room[50]; //Declaring array
		File file = new File("src/rooms.txt"); //Initializing the file
		int count=0;
		try {
			Scanner readFile = new Scanner(file); //Initializing scanner to read the file
			while(readFile.hasNext()) { //Reading each line from the file... finding the room types/properties and adding them to the array
					String type = readFile.next();
					if(type.equals("Office")) { //If the room type is "Office"
						String number = readFile.next();
						int cap = readFile.nextInt();
						int area = readFile.nextInt();
						String owner = readFile.next()+ " "+readFile.next();
						
						rooms[count] = new Office(number, cap, area, owner);
						count++;
					}
					else if(type.equals("Lab")) { //If the room type is "Lab"
						String number = readFile.next();
						int cap = readFile.nextInt();
						int area = readFile.nextInt();
						int computers = readFile.nextInt();
						
						rooms[count] = new Lab(number, cap, area, computers);
						count++;
					}
					else if(type.equals("Classroom")) { //If the room type is "Classroom"
						String number = readFile.next();
						int cap = readFile.nextInt();
						int area = readFile.nextInt();
						
						rooms[count] = new Classroom(number, cap, area);
						count++;
					}
				}
		readFile.close();
		} catch (FileNotFoundException e) { //If the file that is being searched for is NOT found, this will display
			System.out.println("File not found.");
			System.exit(0);
		}
		
		Scanner scan = new Scanner(System.in); //The scanner being used for this section of the program
		int ending =1; //Integer to keep the while loop below running. Once program is over this will become 0
		while(ending == 0) {
			System.out.println("Select an operation: \n1) View all rooms.\n2) Find a room."
								+ "\n3) Add a new room.\n4) Remove an existing room.\n5) Sort the rooms by capacity.\n"
								+ "6) Exit.");
			int x = scan.nextInt(); //Reading the integer selected 
			if(x==1) { //Printing the rooms in the array
				printRooms(rooms, count);
			} 
			else if(x==2) { //Searching for room
				System.out.println("Enter the number for the room you would like to find.");
				String rn = scan.nextLine(); //Reading input for the user's desired room number
				
				try {
					if(checkRoomNumber(rn)) {
						int index = findRoom(rooms,count,rn); //The index of the room if it exists, if it doesn't than this value is -1
						if(index == -1) {
							System.out.println("This room does not exist"); //Message displayed if room does not exist
						}
						else {
							System.out.println(rooms[index]); //The room being printed
						}
					}
				} 
				catch (InvalidRoomNumber e) {
					System.out.println("This is not a valid room number."); //If the room number entered by the user is invalid, this message will be displayed
				}
			}
			else if(x==3) { //Adding room numbers
				System.out.println("Enter the room number for the room you would like to add.");
				String rn = scan.nextLine(); //Reading input for the user's desired room number
				
				try {
					if(checkRoomNumber(rn)) { //Checking validity of room number entered
						if(findRoom(rooms,count,rn) == -1) { //Checking if the room does not already exist
							System.out.println("Would you like to add a lab, office or classroom?");
							String type = scan.nextLine(); //Determining type of room
							
							if(type.equalsIgnoreCase("office")) { //If the room is an office, this will happen.
								System.out.println("Enter the capacity:");
								int capacity = scan.nextInt();
								System.out.println("Enter the area:");
								int area = scan.nextInt();
								System.out.println("Enter the owner:");
								String owner = scan.nextLine();
								
								rooms[count] = new Office(rn, capacity, area, owner);
								count++;
							}else if(type.equalsIgnoreCase("lab")) { //If the room is a lab, this will happen.
								System.out.println("Enter the capacity:");
								int capacity = scan.nextInt();
								System.out.println("Enter the area:");
								int area = scan.nextInt();
								System.out.println("Enter the amount of computers:");
								int computers = scan.nextInt();
								
								rooms[count] = new Lab(rn, capacity, area, computers);
								count++;
							}else if(type.equalsIgnoreCase("classroom")) { //If the room is a classroom, this will happen.
								System.out.println("Enter the capacity:");
								int capacity = scan.nextInt();
								System.out.println("Enter the area:");
								int area = scan.nextInt();
								
								rooms[count] = new Classroom(rn, capacity, area);
								count++;
							}else {
								System.out.println("You did not enter a valid room type."); //If the user did not enter a valid room type, this is the message that will be displayed
							}
						} else {
							System.out.println("The room number you entered already exists."); //If the room number entered by the user already exists in the array, this message will be displayed.
						}
					}
				}
				catch (InvalidRoomNumber e) {
					System.out.println("This is not a valid room number."); //If the room number is not valid, this message will be displayed
				}
			}
			else if(x==4) { //Removing a room from the array
				System.out.println("Enter the room number for the room you'd like to remove:");
				String rn = scan.nextLine(); //The room number of the room the user would like to array
				
				try {
					if(checkRoomNumber(rn)) { //Checking if the room number is valid
						int index = findRoom(rooms, count, rn); //The index of the room the user wants to remove, if it does not exist this valid will be -1
						if(index == -1) {
							System.out.println("This room does not exist."); //If the room does not exist in the array, this message will be displayed
						}else {
							rooms[index] = rooms[count - 1]; //Making the room the user wants to remove into the room which is the last index of the array
							rooms[count - 1] = null; //Making the last index of the array null
							count--; //Making count represent the new number of rooms in the array
							System.out.println("Your room has been removed from the array"); 
						}
					}
				} catch (InvalidRoomNumber e) {
					System.out.println("This is not a valid room number."); //The message displayed if the room number is invalid
				}
			}
			else if(x==5) { //Sorting the rooms in the array
				sortRooms(rooms, count); //Sorts the rooms in the array
				System.out.println("The rooms have been sorted."); //Message displayed once the rooms are sorted
			}
			else if(x==6) { //Exiting the program
				System.out.println("Thank you for using my program!");
				ending--; //Making exit equal to 0 so the program ends
			}
			else {
				System.out.println("Please enter a value between 1-6"); //The message displayed if the user enters a value other than 1 through 6
			}
		}
		
	}
/**
 * Prints the list of rooms specified
 * @param list The list of rooms being printed
 */
	public static void printRooms(Room[] list) {
		for(int i=0; i<list.length; i++) {
			System.out.println(list[i].toString());
		}
	}
/**
 * Prints the first 'count' elements of the array 'list'
 * @param list The list of rooms being printed
 * @param count The index at which the printing stops
 */
	public static void printRooms(Room[] list, int count) {
		for(int i=0; i<count; i++) {
			System.out.println(list[i].toString());
		}
	}
/**
 * Finds and returns the index of a room number specified
 * @param list The list of rooms being searched
 * @param roomNumber The room number being searched for
 * @return The index of the matching room
 */
	public static int findRoom(Room[] list, String roomNumber) {
		for(int i=0; i<list.length; i++) {
			if(roomNumber.equals(list[i].getNumber())) {
				return i;
			}
		}
		return -1;
	}
/**
 * Searches for a room in the first 'count' elements of the array 'list'
 * @param list The list of rooms being searched
 * @param count The index of the array in which the searching stops
 * @param roomNumber The room number being searched for
 * @return The index of the matching room
 */
	public static int findRoom(Room[] list, int count, String roomNumber) {
		for(int i=0; i<count; i++) {
			if(roomNumber.equals(list[i].getNumber())) {
				return i;
			}
		}
		return -1;
	}
/**
 * Sorts the rooms by the capacity
 * @param list The list of rooms being sorted
 */
	public static void sortRooms(Room[] list) {
		for(int i=1; i<list.length; i++) {
			Room currentVal = list[i];
			int j = i;
			while(j>0 && currentVal.getCapacity() < (list[j-1].getCapacity())) {
				list[j] = list[j-1];
				j--;
			}
			list[j] = currentVal;
		}
	}
/**
 * Sorts the rooms in the first 'count' elements of the array 'list'
 * based on the capacity.
 * @param list The list of rooms being sorted
 * @param count The index of the list where the sorting stops
 */
	public static void sortRooms(Room[] list, int count) {
		for(int i=1; i<count; i++) {
			Room currentVal = list[i];
			int j=i;
			while(j>0 && currentVal.getCapacity() < (list[j-1].getCapacity())) {
				list[j] = list[j-1];
				j--;
			}
			list[j] = currentVal;
		}
	}
	/**
	 * Checks the room number to determine whether it is valid or not.
	 * @param roomNumber The room number being checked
	 * @return A true value if roomNumber is valid and an InvalidRoomNumber exception if invalid.
	 * @throws InvalidRoomNumber The exception thrown if roomNUmber is invalid
	 */
	public static boolean checkRoomNumber(String roomNumber) throws InvalidRoomNumber {
		if(roomNumber.matches("[A-Z][A-Z][0-9][0-9][0-9]")) {
			return true;
		}
		else
			throw new InvalidRoomNumber("This is an invalid room number.");
	}
}
