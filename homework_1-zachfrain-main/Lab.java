/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public class Lab extends Room{
	private int computers;
/**
 * Creates a lab with number, capacity, area, and computers specified
 * @param number The lab's number
 * @param capacity The lab's capacity
 * @param area The lab's area
 * @param computers The lab's computer count
 */
	public Lab(String number, int capacity, int area, int computers) {
		super(number, capacity, area);
		this.computers = computers;
	}
/**
 * Gets the lab's computer count
 * @return An int representing the computer count
 */
	public int getComputers() {
		return computers;
	}
/**
 * Sets the lab's computer count
 * @param c An int containing the lab's computer count
 */
	public void setComputers(int c) {
		this.computers = c;
	}
/**
 * Returns a formatted string with the person's information
 */
	public String toString()
	{
		String s = String.format("Computers: %d\t", computers);
		return super.toString() + s;
	}
}
