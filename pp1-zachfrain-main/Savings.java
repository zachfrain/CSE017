/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public class Savings extends Account{
	private double interest;
	/**
	 * Creates a Savings account
	 * @param a The string containing the accountNumber of the account 
	 * @param o The string containing the owner of the account
	 * @param b The double containing the balance of the account 
	 * @param i The double containing the interest of the account
	 */
	public Savings(String a, String o, double b, double i) {
		super(a,o,b);
		this.interest = i;
	}
	/**
	 * Returns a formatted string with the Savings account's information
	 */
	public String toString() {
		String s = String.format("%,15.2f", interest);
		return super.toString() + s;
	}
	/**
	 * Gets the interest of a Savings account
	 * @return A double containing the interest of the account
	 */
	public double getInterest() {
		return interest;
	}
	/**
	 * Method used to deposit a specified amount of money into a Savings account
	 */
	public void deposit(double amt) {
		this.setBalance(this.getBalance() + amt);
		System.out.println("You have deposited your funds.");
		System.out.println("Your new balance is: " + this.getBalance());
	}
	/**
	 * Method used to withdraw a specified amount of money from a Savings account
	 */
	public void withdraw(double amt) {
		if(amt > this.getBalance()) {
			System.out.println("Insufficient funds");
		} else {
			this.setBalance(this.getBalance() - amt);
			System.out.println("You have withdrawn your funds");
			System.out.println("Your new balance is: " + this.getBalance());
		}
	}
	/**
	 * Method used to determine the investment risk of a Savings account
	 */
	public void investmentRisk() {
		System.out.println("This is not an investment account.");
	}
	/**
	 * Method used to determine the monthly interest of a Savings account
	 */
	public void monthlyInterest() {
		double interestRate = this.getInterest() / 12;
		interestRate = interestRate / 100 + 1;
		this.setBalance(this.getBalance()*interestRate);
		System.out.println("New Balance: " + this.getBalance());
	}
	
}
