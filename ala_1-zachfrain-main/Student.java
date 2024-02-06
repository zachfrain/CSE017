/** Represents a student.
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public class Student extends Person{
	private int id;
	private String major;
	
	/**
	 * Creates a student with nothing specified
	 */
	public Student() {
		super();
		id=0; major="undeclared";
	}
	/**
	 * Creates a student with name, address, phone, email, id, and major specified
	 * @param name The student's name
	 * @param address The student's address
	 * @param phone The student's phone number
	 * @param email The student's email address
	 * @param id The student's id number
	 * @param major The student's major
	 */
	public Student(String name, String address, String phone, String email, int id, String major) {
		super(name, address, phone, email);
		this.id = id; this.major = major;
	}
	/**
	 * Gets the student's id number
	 * @return An int representing the student's id number
	 */
	public int getID() {
		return id;
	}
	/**
	 * Gets the student's major
	 * @return A string representing the student's major
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * Sets the student's id number
	 * @param id An int containing the student's id number
	 */
	public void setID(int id) {
		this.id=id;
	}
	/**
	 * Sets the student's major
	 * @param major A string containing the student's major
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	/**
	 * Returns a formatted string with the student's information
	 */
	public String toString() {
		String s = String.format("ID: %d\nMajor: %s\n",  id, major);
		return super.toString() + s;
	}
}
