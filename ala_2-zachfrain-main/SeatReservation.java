import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public class SeatReservation {
/**
 * Main Method
 * @param args
 */
	public static void main(String[] args) {
		Airplane myAirplane = new Airplane("seatsmap.txt");
		int operation=0;
		String seatNumber;
		Scanner keyboard = new Scanner(System.in);
		do {
			try {
			System.out.println(myAirplane.toString());
			printMenu();
			operation = keyboard.nextInt();
			switch(operation) {
			/**
			 * What to do if the input is 1
			 */
			case 1:
				System.out.println("\nEnter a seat number [1-9][A-H]: ");
				seatNumber = keyboard.next();
				if(myAirplane.reserveSeat(seatNumber)) {
					System.out.println("\n\nSeat " + seatNumber + " successfully reserved.");
				} else {
					System.out.println("\n\nSeat " + seatNumber + " already reserved.");
				}
				break;
			/**
			 * What to do if the input is 2
			 */
			case 2:
				System.out.println("\nEnter a seat number [1-9][A-H]: ");
				seatNumber = keyboard.next();
				if(myAirplane.freeSeat(seatNumber)) {
					System.out.println("\n\nSeat " + seatNumber + " successfully freed.");
				} else {
					System.out.println("\n\nSeat " + seatNumber + " already freed.");
				}
				break;
			/*
			 * What to do if the input is 3
			 */
			case 3:
				myAirplane.saveMap("seatsmap.txt");
				System.out.println("\n\nThank you for using my program!");
				break;
			/**
			 * The message displayed for any value input by the user that is not 1,2 or 3
			 */
			default:
				System.out.println("\nInvalid operation. Must be 1 to 3.");
			}
				
		}
		catch(InvalidSeatException e) {
			System.out.println(e.getMessage());
		}			
	}while (operation!=3);
}
	/**
	 * Method used to print the menu to the Console.
	 */
	public static void printMenu() {
		System.out.println("Select an operation: ");
		System.out.println("1) Reserve a seat");
		System.out.println("2) Free a seat");
		System.out.println("3) Quit");
	}
}
