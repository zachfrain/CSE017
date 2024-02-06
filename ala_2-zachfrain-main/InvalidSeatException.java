/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public class InvalidSeatException extends Exception{
	private static final long serialVersionUID = 1L;
	/**
	 * Creates an InvalidSeatException
	 */
	public InvalidSeatException() {
		super();
	}
	/**
	 * Creates an InvalidSeatException with message specified
	 * @param message A string containing the message for the exception
	 */
	public InvalidSeatException(String message) {
		super(message);
	}
}
