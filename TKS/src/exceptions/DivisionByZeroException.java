package exceptions;

/**
 * Thrown when programmer tries to divide number by zero
 * 
 * @author 		Katarina Antesevic
 * @version 	1.0
 * @since		2021-11-19
 *
 */

public class DivisionByZeroException extends Exception{
	
	/**
	 * This is parameterised constructor for class DivisionByZeroException
	 * It constructs an DivisionByZeroException with the specified detail message
	 * 
	 * @param message Specified detail message
	 */
	public DivisionByZeroException(String message) {
		
		super(message);
		
	}
	
}
