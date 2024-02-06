/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public abstract class Account implements Comparable<Account>,Closable{
	private String accountNumber;
	private String owner;
	private double balance;
	
	/**
	 * Creates a protected Account with accountNumber, owner, and balance specified
	 * @param a The string containing the accountNumber of the account
	 * @param o The string containing the owner of the account
	 * @param b The double containing the balance of the accounts
	 */
	protected Account(String a, String o, double b) {
		this.accountNumber = a;
		this.owner = o;
		this.balance = b;
	}
	/**
	 * Sets the accountNumber of an account
	 * @param a The string containing the accountNumber of the account
	 */
	public void setAccountNumber(String a) {
		this.accountNumber = a;
	}
	/**
	 * Sets the owner of an account
	 * @param o The string containing the owner of the account
	 */
	public void setOwner(String o) {
		this.owner = o;
	}
	/**
	 * Sets the balance of an account
	 * @param b The double containing the balance of the account
	 */
	public void setBalance(double b) {
		this.balance = b;
	}
	/**
	 * Gets the accountNumber of an account
	 * @return A string containing the accountNumber of an account
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * Gets the owner of an account
	 * @return A string containing the owner of an account
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * Gets the balance of an account
	 * @return A double containing the balance of an account
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * Returns a formatted string with the account's information
	 */
	public String toString() {
		String a = String.format("%13s", accountNumber);
		String o = String.format("%25s", owner);
		String b = String.format("%,15.2f", balance);
		return a + o + b;
	}
	/**
	 * Method to compare two accounts by their balance for the Comparable<Account> interface.
	 */
	public int compareTo(Account a) {
		if(this.balance == a.balance) {
			return 0;
		}
		else if(this.balance > a.balance) {
			return 1;
		}
		else {
			return -1;
		}
	}
	/**
	 * Method to determine if an account is closable for the Closable interface.
	 */
	public boolean isClosable() {
		if(this.balance < 200) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Abstract method used for depositing money into an account.
	 * @param amt A double containing the amount of money that will be deposited into the account.
	 */
	public abstract void deposit(double amt);
	/**
	 * Abstract method used for withdrawing money from an account
	 * @param amt A double containing the amount of money that will be withdrawn from the account.
	 */
	public abstract void withdraw(double amt);
	/**
	 * Abstract method used to determine the investment risk of an account.
	 */
	public abstract void investmentRisk();
	/**
	 * Abstract method used to determine the monthlyInterest of an account.
	 */
	public abstract void monthlyInterest();
	
}
