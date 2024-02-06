/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public class Country {
	/*
	 * Declaring the code,name,capital and area
	 */
	private String code;
	private String name;
	private String capital;
	private double area;
	/**
	 * Constructor for a Country
	 * @param code The string containing the code of the country
	 * @param name The string containing the name of the country
	 * @param capital The string containing the capital of the country
	 * @param area The double containing the area of the country
	 */
	public Country(String code, String name, String capital, double area) {
		this.code = code;
		this.name = name;
		this.capital = capital;
		this.area = area;
	}
	/**
	 * Getter for the code
	 * @return The string containing the code of the country
	 */
	public String getCode() {
		return code;
	}
	/**
	 * Getter for the name
	 * @return The string containing the name of the country
	 */
	public String getName() {
		return name;
	}
	/**
	 * Getter for the capital
	 * @return The string containing the capital of the country
	 */
	public String getCapital() {
		return capital;
	}
	/**
	 * Getter for the area
	 * @return The double containing the area of the country
	 */
	public double getArea() {
		return area;
	}
	/**
	 * Setter for the code
	 * @param c The string that contains the new code for the country
	 */
	public void setCode(String c) {
		code = c;
	}
	/**
	 * Setter for the name
	 * @param n The string that contains the new name for the country
	 */
	public void setName(String n) {
		name = n;
	}
	/**
	 * Setter for the capital
	 * @param c The string that contains the new capital for the country
	 */
	public void setCapital(String c) {
		capital = c;
	}
	/**
	 * Setter for the area
	 * @param a The double that contains the new area value for the country
	 */
	public void setArea(double a) {
		area = a;
	}
	/**
	 * Creates a formatted string for the country
	 * @return A formatted string with the country's information
	 */
	public String toString() {
		String c = String.format("%2s", code);
		String n = String.format("%45s", name);
		String cc = String.format("%27s", capital);
		String a = String.format("%,15.1f", area);
		return c + n + cc + a;
	}
	/**
	 * Method to determine whether two countries have equivalent names
	 * @param c The country being compared to
	 * @return True if the two countries have equal names, false otherwise
	 */
	public boolean equals(Object c) {
		if(c instanceof Country) {
			if(this instanceof Country) {
				if(this.getName().equals(((Country) c).getName())) {
					return true;
				}
			}
		}
		return false;
	}
}
