import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public class Test{
	/**
	 * Main method. Runs the menu and reads the input for the program.
	 * @param args
	 */
	public static void main(String[] args) {
	
		Account[] accounts = new Account[100];
		File file = new File("accounts.txt");
		int count = 0;
		try {
			Scanner readFile = new Scanner(file);
			while(readFile.hasNext()) {
				String type = readFile.next();
				if(type.equalsIgnoreCase("Investment")) { //Putting Investment accounts into the accounts array
					String aN = readFile.next();
					String o = readFile.next();
					double b = readFile.nextDouble();
					String iT = readFile.next();
					
					accounts[count] = new Investment(aN, o, b, iT);
					count++;
				}
				else if(type.equalsIgnoreCase("Savings")) { //Putting Savings accounts into the accounts array
					String aN = readFile.next();
					String o = readFile.next();
					double b = readFile.nextDouble();
					double i = readFile.nextDouble();
					
					accounts[count] = new Savings(aN, o, b, i);
					count++;
				}
				else if(type.equalsIgnoreCase("Checking")) { //Putting the Checking accounts into the accounts array
					String aN = readFile.next();
					String o = readFile.next();
					double b = readFile.nextDouble();
					
					accounts[count] = new Checking(aN, o, b);
					count++;
				}
			}
			readFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}

		
		Scanner scan = new Scanner(System.in);
		int ending = 1;
		while(ending == 1) {
			System.out.println("Select an operation: \n1) Find Account"
					  + "\n2) Add Account"
					  + "\n3) Remove Account"
					  + "\n4) View Accounts"
					  + "\n5) View Closable Accounts"
					  + "\n6) Sort Account"
					  + "\n7) Exit");
			int x = scan.nextInt();
			if(x == 1) {
				//Find Account
				System.out.println("Enter Account Number (6 digits)");
				int aN1 = scan.nextInt();
				String aN = Integer.toString(aN1);
				try {
					if(checkAccountNumber(aN) == true) {
						int index = findAccount(accounts, count, aN);
						if(index == -1) {
							System.out.println("Account not found.");
						} else {
							int sEnding = 1;
							while(sEnding == 1) {
								System.out.println("Select an operation:"
										+ "\n1) Check Balance"
										+ "\n2) Withdraw"
										+ "\n3) Deposit"
										+ "\n4) Apply Monthly Interest"
										+ "\n5) Apply Investment Risk"
										+ "\n6) Go Back To Main Menu");
								int y = scan.nextInt();
								if(y == 1) {
									//Check Balance
									System.out.println(accounts[index].getBalance());
								}
								else if(y == 2) {
									//Withdraw
									System.out.println("Enter the amount you'd like to withdraw");
									double w = scan.nextDouble();
									accounts[index].withdraw(w);
								}
								else if(y == 3) {
									//Deposit
									System.out.println("Enter the amount you'd like to deposit");
									double d = scan.nextDouble();
									accounts[index].deposit(d);
								}
								else if(y == 4) {
									//Apply Monthly Interest
									accounts[index].monthlyInterest();
								}
								else if(y == 5) {
									//Apply Investment Risk
									accounts[index].investmentRisk();
								}
								else if(y == 6) {
									//Main menu
									sEnding++;
								}
								else {
									System.out.println("Please enter a number 1-6");
								}
							}
						}
					} else {
						System.out.println("Invalid account number");
					}
				} catch (InvalidBankAccount e) {
					System.out.println("Invalid account number.");
				}
			}
			else if(x == 2) {
				//Add Account
				System.out.println("Enter the account type (checking/savings/investment)");
				String aType = scan.next();
				if(aType.equalsIgnoreCase("Checking")) {
					System.out.println("Enter the owner's name (first,last)");
					String aOwner = scan.next();
					System.out.println("Enter the intial balance:");
					double aBalance = scan.nextDouble();
					
					accounts[count] = new Checking(randomAccountNumber(), aOwner, aBalance);
					count++;
					System.out.println("The account has been added");
				}
				else if(aType.equalsIgnoreCase("Savings")) {
					System.out.println("Enter the owner's name (first,last)");
					String aOwner = scan.next();
					System.out.println("Enter the intial balance:");
					double aBalance = scan.nextDouble();
					System.out.println("Enter the interest:");
					double aInterest = scan.nextDouble();
					
					accounts[count] = new Savings(randomAccountNumber(), aOwner, aBalance, aInterest);
					count++;
					System.out.println("The account has been added");
				}
				else if(aType.equalsIgnoreCase("Investment")) {
					System.out.println("Enter the owner's name (first,last)");
					String aOwner = scan.next();
					System.out.println("Enter the intial balance:");
					double aBalance = scan.nextDouble();
					System.out.println("Enter the investment type:");
					String aInvestmentType = scan.next();
					
					accounts[count] = new Investment(randomAccountNumber(), aOwner, aBalance, aInvestmentType);
					count++;
					System.out.println("The account has been added");
				}
				else {
					System.out.println("That is not a valid account type");
				}
			}
			else if(x == 3) {
				//Remove Account
				System.out.println("Enter Account Number (6 digits)");
				int aN3 = scan.nextInt();
				String aN2 = Integer.toString(aN3);
				try {
					if(checkAccountNumber(aN2) == true) {
						int aIndex = findAccount(accounts, count, aN2);
						if(aIndex != -1) {
							for(int i = aIndex; i < count; i++) {
								accounts[i] = accounts[i + 1];
							}
							System.out.println("The account has been removed");
							accounts[count] = null;
							count--;
						} else {
							System.out.println("Account not found.");
						}
					}
				}
				catch (InvalidBankAccount e){
					System.out.println("Invalid Account Number");
				}
			}
			else if(x == 4) {
				//View Accounts
				printAccounts(accounts, count);
			}
			else if(x == 5) {
				//View Closable Accounts
				printClosableAccounts(accounts, count);
			}
			else if(x == 6) {
				Arrays.sort(accounts,0,count);
				System.out.println("The account list has been sorted");
			}
			else if(x == 7) {
				System.out.println("Thank you for using my program.");
				
				File accountFile = new File ("accounts.txt");
				try {
					PrintStream wr = new PrintStream("accounts.txt");
					
					int index = 0;
					while(index < count) {
						if(accounts[index] instanceof Checking) {
							wr.print("Checking ");
							wr.print(accounts[index].getAccountNumber() + " ");
							wr.print(accounts[index].getOwner() + " ");
							wr.print(accounts[index].getBalance() + " \n");
						}
						else if(accounts[index] instanceof Savings) {
							wr.print("Savings ");
							wr.print(accounts[index].getAccountNumber() + " ");
							wr.print(accounts[index].getOwner() + " ");
							wr.print(accounts[index].getBalance() + " ");
							wr.print(((Savings) accounts[index]).getInterest() + " \n");
						}
						else if(accounts[index] instanceof Investment) {
							wr.print("Investment ");
							wr.print(accounts[index].getAccountNumber() + " ");
							wr.print(accounts[index].getOwner() + " ");
							wr.print(accounts[index].getBalance() + " ");
							wr.print(((Investment) accounts[index]).getInvestmentType() + " ");
						}
						index++;
					}
					wr.close();
					
					
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				
				System.exit(0);
			}
			else {
				System.out.println("Please enter an integer between 1 and 7.");
			}
		}
	}
	/**
	 * Method used to print all the accounts from an Account[] array
	 * @param list The Account[] array being printed
	 * @param count The index in the array where the printing ends
	 */
	public static void printAccounts(Account[] list, int count) {
		System.out.println("Acct. Type:\t Acct. Number:\t\t Owner:\t      Balance:\t\t Interest/Investment Type:\t");
		for(int i=0; i<count; i++) {
			if(list[i] instanceof Checking) {
				System.out.println("Checking  " + list[i].toString());
			}
			else if(list[i] instanceof Savings) {
				System.out.println("Savings   " + list[i].toString());
			}
			else if(list[i] instanceof Investment) {
				System.out.println("Investment" + list[i].toString());
			}
		}
	}
	/**
	 * Method used to print all the closable accounts from an Account[] array
	 * @param list The Account[] array being printed
	 * @param count The index in the array where the printing ends
	 */
	public static void printClosableAccounts(Account[] list, int count) {
		System.out.println("Acct. Type:\t Acct. Number:\t\t Owner:\t      Balance:\t\t Interest/Investment Type:\t");
		for(int i=0; i<count; i++) {
			if(list[i].isClosable()) {
				if(list[i] instanceof Checking) {
					System.out.println("Checking  " + list[i].toString());
				}
				else if(list[i] instanceof Savings) {
					System.out.println("Savings   " + list[i].toString());
				}
				else if(list[i] instanceof Investment) {
					System.out.println("Investment" + list[i].toString());
				}
			}
		}
	}
	/**
	 * Method used to find an account from an Account[] array
	 * @param list The Account[] array being searched through
	 * @param count The index in the array where the searching ends
	 * @param aN The string containing the accountNumber being searched for
	 * @return The index of the matching account in the array list, or -1 if the account is not to be found
	 */
	public static int findAccount(Account[] list, int count, String aN) {
		for(int i=0; i<count; i++) {
			if(aN.equals(list[i].getAccountNumber())) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Method used to determine if an accountNumber is valid
	 * @param aN A String containing an accountNumber
	 * @return True if the accountNumber is valid, False if invalid
	 * @throws InvalidBankAccount The exception thrown when there is an invalid accountNumber
	 */
	public static boolean checkAccountNumber(String aN) throws InvalidBankAccount{
		if(aN.matches("[0-9][0-9][0-9][0-9][0-9][0-9]")) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Method used to create a random accountNumber for an account
	 * @return A string containing the accountNumber for an account
	 */
	public static String randomAccountNumber() {
		int i = (int)(Math.random()*899999) + 100000;
		String r = Integer.toString(i);
		return r;
	}
	/**
	 * Method used to remove an account from an Account[] array
	 * @param list The Account[] array that an account is being removed from
	 * @param count The index in the array where the loop ends
	 * @param accountNumber The accountNumber of the account being removed
	 */
	public static void removeAccount(Account[] list, int count, String accountNumber) {
		int aIndex = findAccount(list, count, accountNumber);
		if(aIndex != -1) {
			for(int i = aIndex; i < count; i++) {
				list[i] = list[i + 1];
			}
			System.out.println("The account has been removed");
		} else {
			System.out.println("Account not found.");
		}
	}
	
}