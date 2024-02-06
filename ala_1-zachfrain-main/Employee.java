/** Represents an employee.
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public class Employee extends Person{
	private int id;
	private String position;
	private double salary;
	
	/**
	 * Creates an employee with nothing specified
	 */
	public Employee() {
		super();
		id=0; position=""; salary=0;
	}
	/**
	 * Creates an employee with name, address, phone, email, id, position, and salary specified.
	 * @param name The employee's name
	 * @param address The employee's address
	 * @param phone The employee's phone number
	 * @param email The employee's email address
	 * @param id The employee's id number
	 * @param position The employee's position
	 * @param salary The employee's salary
	 */
	public Employee(String name, String address, String phone, String email, int id, String position, double salary) {
		super(name,address,phone,email);
		this.id=id; this.position=position; this.salary=salary;
	}
	
	/**
	 * Gets the employee's id number
	 * @return An int representing the employee's id number
	 */
	public int getID() {
		return id;
	}
	/**
	 * Gets the employee's position
	 * @return A string representing the employee's position
	 */ 
	public String getPosition() {
		return position;
	}
	/**
	 * Gets the employee's salary
	 * @return A double representing the employee's salary
	 */
	public double getSalary() {
		return salary;
	}
	
	/**
	 * Sets the employee's id number
	 * @param id An int containing the employee's id number
	 */
	public void setID(int id) {
		this.id=id;
	}
	/**
	 * Sets the employee's position
	 * @param p A string containing the employee's position
	 */
	public void setPosition(String p) {
		this.position=p;
	}
	/**
	 * Sets the employee's salary
	 * @param s A double containing the employee's salary
	 */
	public void setSalary(double s) {
		this.salary=s;
	}
	
	/**
	 * Returns a formatted string with the employee's information
	 */
	public String toString() {
		String s = String.format("ID: %d\nPosition: %s\nSalary: $%g\n",  id, position, salary);
		return super.toString() + s;
	}
}
