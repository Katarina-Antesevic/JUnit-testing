package exceptions;

/**
 * Thrown when programmer tries to use non-supported operator
 * 
 * @author 		Katarina Antesevic
 * @version 	1.0
 * @since		2021-11-19
 * 
 */

public class NotSupportedOperationException extends Exception{
	
	/**
	 * This is parameterised constructor for class NotSupportedOperationException
	 * It constructs an NotSupportedOperationException with the specified detail message
	 * 
	 * @param message Specified detail message
	 */
	public NotSupportedOperationException(String message) {
		
		super(message);
		
	}

}
