/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */

public class Classroom extends Room{
/**
 * Creates a classroom with number, capacity, and area specified
 * @param number The classroom's number
 * @param capacity The classroom's capacity
 * @param area The classroom's area
 */
	public Classroom(String number, int capacity, int area) {
		super(number, capacity, area);
	}
/**
 * Returns a formatted string containing the classroom's information
 */
	public String toString() {
		return super.toString();
	}
/**
 * Returns a non-formatted string that contains the attributes of the classroom
 */
	public String simpleString() {
		return super.simpleString();
	}
}
