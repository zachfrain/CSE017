/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */

public class Office extends Room{
	private String owner;
/**
 * Creates an office with number, capacity, area and owner specified
 * @param number The office's number
 * @param capacity The office's capacity
 * @param area The office's area
 * @param owner The office's owner
 */
	public Office(String number, int capacity, int area, String owner) {
		super(number, capacity, area);
		this.owner = owner;
	}
/**
 * Gets the office's owner
 * @return A string representing the office's owner
 */
	public String getOwner() {
		return owner;
	}
/**
 * Sets the office's owner
 * @param o A string containing the office's owner
 */
	public void setOwner(String o) {
		this.owner = o;
	}
/**
 * Returns a formatted string with the office's information
 */
	public String toString() {
		String s = String.format("Owner: %s\t", owner);
		return super.toString() +s;
	}
/**
 * Returns a non-formatted string that contains the attributes of the office
 */
	public String simpleString() {
		return super.simpleString() + owner + " ";
	}
}
