/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public class Investment extends Account{
	private String investmentType;
	/**
	 * Creates an Investment account
	 * @param a The string containing the accountNumber of an account
	 * @param o The string containing the owner of an account
	 * @param b The double containing the balance of an account
	 * @param i The string containing the investmentType of an account
	 */
	public Investment(String a, String o, double b, String i) {
		super(a,o,b);
		this.investmentType = i;
	}
	/**
	 * Returns a formatted string with the Investment account's information
	 */
	public String toString() {
		String s = String.format("%18s",investmentType);
		return super.toString() + s;
	}
	/**
	 * Gets the Investment account's investmentType
	 * @return A string containing the investmentType of an Investment account
	 */ 
	public String getInvestmentType() {
		return this.investmentType;
	}
	/**
	 * Method used to deposit a certain amount into an Investment account
	 */
	public void deposit(double amt) {
		this.setBalance(this.getBalance() + amt);
		System.out.println("You have deposited your funds.");
		System.out.println("Your new balance is: " + this.getBalance());
	}
	/**
	 * Method used to withdraw a certain amount from an Investment account
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
	 * Method used to determine the investment risk of an Investment account
	 */
	public void investmentRisk() {
		int probability = (int)(Math.random() * 10);
		if(probability >= 0.5) { //profit
			double divisor = this.getBalance() / 20;
			double profit = (double) (Math.random() * divisor);
			this.setBalance(this.getBalance() + profit);
			System.out.println("Profit. Your new balance is: " + this.getBalance());
		}
		else if(probability < 0.5) { //loss
			double divisor = this.getBalance() / 20;
			double loss = (double) (Math.random() * divisor);
			this.setBalance(this.getBalance() - loss);
			System.out.println("Loss. Your new balance is: " + this.getBalance());
 		}
	}
	/**
	 * Method used to determine the monthly interest of an Investment account
	 */
	public void monthlyInterest() {
		System.out.println("This is not a savings account.");
	}

}
