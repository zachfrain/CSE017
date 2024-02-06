/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */

import java.util.Scanner;

public class Test {
/**
 * Main method
 * @param args
 */
	public static void main(String[] args) {
		Room[] rooms = new Room[5];
		rooms[0] = new Lab("PA-110",65,150,45);
		rooms[1] = new Office("PA-252",2,36,"Houria Oudghiri");
		rooms[2] = new Lab("PA-202",45,100,25);
		rooms[3] = new Classroom("PA101",20,45);
		rooms[4] = new Lab("PA100",47,120,40);
		
		Scanner scan = new Scanner(System.in);
		int ending = 0;
		while(ending == 0) {
			System.out.println("Select an operation: \n1) Find a room\n2) View all rooms\n3) Sort rooms\n4) Exit");
			int x = scan.nextInt();
			if(x==1) {
				System.out.println("Enter the room number:");
				String y = "";
				while(y=="") {
					y = scan.nextLine();
				}
				if(findRoom(rooms, y)!=-1) {
					System.out.println(rooms[findRoom(rooms,y)].toString());
				}
				else {
					System.out.println("Room not found.");
				}
			}
			if(x==2) {
				printRooms(rooms);
			}
			if(x==3) {
				sortRooms(rooms);
			}
			if(x>=4) {
				System.out.println("Thank you for using my program");
				ending--;
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
}
