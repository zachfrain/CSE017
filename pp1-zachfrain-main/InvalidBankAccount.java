/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public class InvalidBankAccount extends Exception {
	/**
	 * Creates an InvalidBankAccount exception
	 */
	public InvalidBankAccount() {
		super();
	}
	/**
	 * Creates an InvalidBankAccount exception with a specified message
	 * @param message A string containing the message for the InvalidBankAccount exception
	 */
	public InvalidBankAccount(String message) {
		super(message);
	}
}
