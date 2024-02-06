/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public class Faculty extends Employee{
	private String rank;
	/**
	 * Creates a faculty member with nothing specified
	 */
	public Faculty() {
		super();
		rank="";
	}
	/**
	 * Creates a faculty member with name, address, phone, email, id, position, salary, and rank specified.
	 * @param name The faculty member's name
	 * @param address The faculty member's address
	 * @param phone The faculty member's phone number
	 * @param email The faculty member's email address
	 * @param id The faculty member's id number
	 * @param position The faculty member's position
	 * @param salary The faculty member's salary
	 * @param rank The faculty member's rank
	 */
	public Faculty(String name, String address, String phone, String email, int id, String position, double salary, String rank) {
		super(name,address,phone,email,id,position,salary);
		this.rank=rank;
	}
	/**
	 * Gets the faculty member's rank
	 * @return A string containing the faculty member's rank
	 */
	public String getRank() {
		return rank;
	}
	/**
	 * Sets the faculty member's rank
	 * @param rank A string containing the faculty member's address
	 */
	public void setRank(String rank) {
		this.rank=rank;
	}
	
	/**
	 * Returns a formatted string with the faculty member's information
	 */
	public String toString() {
		String s = String.format("Rank: %s\n",rank);
		return super.toString() + s;
	}
}
