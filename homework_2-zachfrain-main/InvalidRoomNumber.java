/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public class InvalidRoomNumber extends Exception{
	private static final long serialVersionUID = 1L;
	/**
	 * Creates an InvalidRoomNumber exception.
	 */
	public InvalidRoomNumber() {
		super();
	}
	/**
	 * Creates an InvalidRoomNumber exception with the message specified.
	 * @param message A string containing the message for the exception.
	 */
	public InvalidRoomNumber(String message) {
		super(message);
	}
}
