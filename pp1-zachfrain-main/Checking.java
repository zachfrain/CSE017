/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public class Checking extends Account{
	/**
	 * Public constructor used to create a Checking account
	 * @param a A string containing the accountNumber of an account
	 * @param o A string containing the owner of an account
	 * @param b A double containing the balance of an account
	 */
	public Checking(String a, String o, double b) {
		super(a,o,b);
	}
	/**
	 * Method used to return a formatted string with the Checking account's information
	 */
	public String toString() {
		return super.toString();
	}
	/**
	 * Method used to deposit an amount into a Checking account.
	 */
	public void deposit(double amt) {
		this.setBalance(this.getBalance() + amt);
		System.out.println("You have deposited your funds.");
		System.out.println("Your new balance is: " + this.getBalance());
	}
	/**
	 * Method used to withdraw an amount from a Checking account
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
	 * Method used to determine the investment risk of a Checking account
	 */
	public void investmentRisk() {
		System.out.println("This is not an investment account.");
	}
	/**
	 * Method used to determine the monthly interest of a Checking account
	 */
	public void monthlyInterest() {
		System.out.println("This is not a savings account.");
	}
}
