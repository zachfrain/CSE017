import java.util.Stack;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public class Test {
	/**
	 * Main method, used to run through program
	 * @param args
	 */
	public static void main(String[] args) {
	int ending = 0;
	while(ending == 0) { //While loop to prompt user with entering file path, first and second character
		Scanner scan = new Scanner(System.in);
		Stack<String> stack = new Stack<>();
		/**
		 * Asking user for the file path
		 */
		System.out.println("Enter a file path:");
		String path = scan.nextLine();
		/**
		 * Asking user for the first character
		 */
		System.out.println("Enter the first character:");
		String fChar = scan.next().substring(0,1);
		/**
		 * Asking user for the second character
		 */
		System.out.println("Enter the second character:");
		String sChar = scan.next().substring(0,1);
		/**
		 * Using the information previously received from the user, the program will execute the readThroughFile method
		 */
		readThroughFile(stack, path, fChar, sChar);
		/**
		 * Asking the user if they want to check another file
		 */
		System.out.println("Do you want to check another file? (yes/no)");
		String yn = scan.next();
		if(yn.equalsIgnoreCase("yes")) { 
			//if yes, nothing happens
		} else {
			//if the user says anything but yes, the loop ends and the simulation is printed to the console
			ending++;
			System.out.println("Queueing System Simulation");
			System.out.println("--------------------------");
			System.out.println();
			System.out.println("Simulation time: 8 hours");
			System.out.println("Arrival Rate: 25 customers / hour");
			System.out.println("Service time: 5 minutes / customer");
			System.out.println("\n\nCashiers\tCustomers\tAverage number of waiting customers\t Average waiting time per customer(minutes)");
			for(int i=1; i<=5; i++) {
				simulation(8*60, 25/60.0, 5, i);
			}
		}
		}
	}
	/**
	 * Method used to read through the file and check for pairs of two characters
	 * @param s The stack that is being used
	 * @param filename The string containing the name of the file being searched through
	 * @param fC The string containing the first character that is being looked for in the file
	 * @param sC The string containing the second character that is being looked for in the file
	 */
	public static void readThroughFile(Stack<String> s, String filename, String fC, String sC) {
		File file = new File(filename);
		
		try {
			int i = 1;
			Scanner readFile = new Scanner(file);
			while(readFile.hasNextLine()) {
				String line = readFile.nextLine();
				for(int g=0; g<line.length(); g++) {
					String current = line.substring(g,g+1);
					if(current.equals(fC)) {
						s.push(fC+i);
					} else if(current.equals(sC)) {
						s.pop();
					}
				}
				i++;
			}
			if(s.isEmpty()) {
				System.out.println("All '"+fC+"' and '"+sC+"' match.");
			} else {
				System.out.println("Mismatching: The following '"+fC+"' do not have a matching '"+sC+"'");
				while(!s.isEmpty()) {
					String result = s.pop();
					System.out.println(fC+": line "+result.substring(1));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (EmptyStackException e) {
			System.out.println("Mismatching pairs. There are more '"+sC+"' than '"+fC+"'");
		}
	}
	/**
	 * Method used to simulate cashiers working with customers
	 * @param simulationTime The during of the simulation time in minutes
	 * @param arrivalRate The number of customers who arrive in one minute
	 * @param serviceTime The time, in minutes, it takes the cashier to serve one customer
	 * @param cashiersWorking The number of cashiers working
	 */
	public static void simulation(double simulationTime, double arrivalRate, double serviceTime, int cashiersWorking) {
		double totalWaitingTime = 0;
		int customers = 0;
		int totalWaitingCustomers = 0;
		double[] cashier = new double[cashiersWorking];
		
		LinkedList<Double> queue = new LinkedList<>();
		
		for(double time = 0; time <= simulationTime; time++) {
			double random = Math.random();
			if(random > arrivalRate) {
				queue.offer(time);
				customers++;
			}
			
			for(int i=0; i < cashier.length; i++) {
				if(cashier[i]!=0) {
					cashier[i]--;
				}
			}
			int availability;
			while((availability = freeCashier(cashier)) != -1 && !queue.isEmpty()) {
				cashier[availability] = serviceTime;
				totalWaitingTime += time - queue.poll();
			}
			totalWaitingCustomers += queue.size();
		}
		System.out.printf("%-10d\t%-15d\t%-15d\t%30.2f\n", cashiersWorking, customers, (int)(totalWaitingCustomers/simulationTime), (totalWaitingTime/customers));
		
	}
	/**
	 * Method that is used to determine if there is a free cashier available
	 * @param cashier The array of cashiers availability
	 * @return The index of an available cashier
	 */
	public static int freeCashier(double[] cashier) {
		for(int i=0; i < cashier.length; i++) {
			if(cashier[i] == 0) {
				return i;
			}
		}
		return -1;
	}
	
}
