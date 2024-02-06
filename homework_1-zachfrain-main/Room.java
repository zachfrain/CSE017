/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */

public class Room {
	private String number;
	private int capacity;
	private int area;
/**
 * Creates a room with number, capacity, and area specified
 * @param number The room's number
 * @param capacity The room's capacity
 * @param area The room's area
 */
	public Room(String number, int capacity, int area) {
		this.number = number;
		this.capacity = capacity;
		this.area = area;
	}
/**
 * Gets the room's number
 * @return A string representing the room's number
 */
	public String getNumber() {
		return number;
	}
/**
 * Gets the room's capacity
 * @return An int that represents the room's capacity
 */
	public int getCapacity() {
		return capacity;
	}
/**
 * Gets the room's area
 * @return An int that represents the room's area
 */
	public int getArea() {
		return area;
	}
/**
 * Sets the room's number
 * @param n A string containing the room's number
 */
	public void setNumber(String n) {
		this.number = n;
	}
/**
 * Sets the room's capacity
 * @param c An int containing the room's capacity
 */
	public void setCapacity(int c) {
		this.capacity = c;
	}
/**
 * Sets the room's area
 * @param a An int containing the room's area
 */
	public void setArea(int a) {
		this.area = a;
	}
/**
 * Returns a formatted string with the room's information
 */
	public String toString() {
		String s = String.format("Number: %s\tCapacity: %d\tArea: %d\t", number, capacity, area);
		return s;
	}
}
