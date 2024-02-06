/** Represents a person.
 * 
 * @author Zachary Frain
 * @version 1.0
 *
 */
public class Person {
	//Data members
	protected String name;
	protected String address;
	protected String phone;
	protected String email;
	
	/**
	 * Creates a person with nothing specified
	 */
	public Person() {
		name=address=phone=email="none";
	}
	/**
	 * Creates a person with name, address, phone, and email specified
	 * @param name The person's name
	 * @param address The person's address
	 * @param phone The person's phone number
	 * @param email The person's email address
	 */
	public Person(String name, String address, String phone, String email) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	
	/**
	 * Gets the person's name
	 * @return A string representing the person's name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Gets the person's address
	 * @return A string representing the person's address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * Gets the person's phone number
	 * @return A string representing the person's phone number
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * Gets the persons email address
	 * @return A string representing the person's email address
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the person's name
	 * @param name A string containing the person's name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Sets the person's address
	 * @param address A string containing the person's address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * Sets the person's phone number
	 * @param phone A string containing the person's phone number
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * Sets the person's email address
	 * @param email A string containing the person's email address
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Returns a formatted string with the person's information
	 */
	public String toString() {
		String s;
		s = String.format("Name : %s\nAddress: %s\nPhone: %s\nEmail: %s\n", name, address, phone, email);
		
		return s;
	}
	/**
	 * Returns a boolean value when comparing two People
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person p = (Person) obj;
			return p.name.equals(this.name);
		}
		return false;
		}
	}
