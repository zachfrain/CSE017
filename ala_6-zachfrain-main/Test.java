import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * 
 * @author Zachary Frain
 * @version 1.0
 * 
 */
public class Test {
	/**
	 * Main class
	 * @param args
	 */
	public static void main(String[] args) {
		final double PRINTING_SPEED = 10000;
		Scanner keyboard = new Scanner(System.in);
		Stack<Integer> postfixStack = new Stack<>();
		int ending = 0;
		/*
		 * While loop that gets a postfix expression from the user and evaluates it.
		 */
		while(ending == 0) {
		System.out.println("Enter a postfix expression:");
		String expression = keyboard.nextLine();
		String[] tokens = expression.split(" ");
		for(int i=0; i<tokens.length; i++) {
			if(!tokens[i].matches("\\d{1,}")) {
				int op1 = postfixStack.pop();
				int op2 = postfixStack.pop();
				switch(tokens[i]) {
				case "+":
					postfixStack.push(op2 + op1);
					break;
				case "-":
					postfixStack.push(op2 - op1);
					break;
				case "*":
					postfixStack.push(op2 * op1);
					break;
				case "/":
					postfixStack.push(op2 / op1);
					break;
				}
			} else {
				postfixStack.push(Integer.parseInt(tokens[i]));
			}
		}
		int result = postfixStack.pop();
		if(postfixStack.isEmpty()) {
			System.out.println("Result : " + result);
			System.out.println("Do you want to evaluate another postfix expression? (yes/no)");
			String evalAnother = keyboard.nextLine();
			if(evalAnother.equalsIgnoreCase("yes")){
				
			} else if(evalAnother.equalsIgnoreCase("no")) {
				ending+=1;
			}
		} else {
			System.out.println("Malformed postfix expression.");
			System.out.println("Do you want to evaluate another postfix expression? (yes/no)");
			String evalAnother = keyboard.nextLine();
			if(evalAnother.equalsIgnoreCase("yes")) {
			
			}
			else if(evalAnother.equalsIgnoreCase("no")) {
				ending+=1;
			}
		}
		}
		/**
		 * Creating a PriorityQueue jobs for type Job
		 */
		PriorityQueue<Job> jobs = new PriorityQueue<>();
		File file = new File("jobs.txt");
		/**
		 * Reads the file "jobs.txt" and creates new Job objects to put in the jobs PriorityQueue<Job>
		 */
		try {
			Scanner readFile = new Scanner(file);
			while(readFile.hasNext()) {
				int id = readFile.nextInt();
				int group = readFile.nextInt();
				long size = readFile.nextLong();
				Job job = new Job(id, group, size);
				jobs.offer(job);
			}
			readFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		/**
		 * Printing the Job objects from the PriorityQueue<Job> jobs
		 */
		System.out.println("\n\nSimulating printing jobs");
		System.out.println("---------------------------------------------------------------");
		System.out.println("Job ID\t\tJob Group\tSize\t\tCompletion Time");
		double totalTime = 0;
		while(!jobs.isEmpty()) {
			Job job = jobs.poll();
			double time = job.getSize() / PRINTING_SPEED;
			totalTime += time;
			String convertedTime = convertTime(time);
			System.out.printf("%s\t\t%s\n", job.toString(), convertedTime);
		}
		
		System.out.println("\n\nTotal Printing Time: " + convertTime(totalTime));
	}
	/**
	 * Method used to convert the time values from double to formatted string into days:hours:minutes:seconds
	 * @param time The double value that is being converted
	 * @return A string representing the formatted time.
	 */
	public static String convertTime(double time) {
		int seconds = 0;
		int minutes = 0;
		int hours = 0;
		int days = 0;
		
		if(time >= 86400) {
			days = Math.floorDiv((int) time, 86400);
			time = time % 86400;
		}
		if(time >= 3600) {
			hours = Math.floorDiv((int) time, 3600);
			time = time % 3600;
		}
		if(time >= 60) {
			minutes = Math.floorDiv((int) time, 60);
			time = time % 60;
		}
		seconds = (int)time;
		
		String day = Integer.toString(days);
		if(day.length() == 1) {
			day = "0"+day;
		}
		
		String hour = Integer.toString(hours);
		if(hour.length() == 1) {
			hour = "0"+hour;
		}
		
		String minute = Integer.toString(minutes);
		if(minute.length() == 1) {
			minute = "0"+minute;
		}
		
		String second = Integer.toString(seconds);
		if(second.length() == 1) {
			second = "0"+second;
		}
		
		return day + ":" + hour + ":" + minute + ":" + second;
	}
}	
	
