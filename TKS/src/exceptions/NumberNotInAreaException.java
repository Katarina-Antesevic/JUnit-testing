package exceptions;

/**
 * Thrown when value of Calculator attribute currentValue is not within a specific range
 * 
 * @author 		Katarina Antesevic
 * @version 	1.0
 * @since		2021-11-19
 *
 */
public class NumberNotInAreaException extends Exception{
	
	/**
	 * This is parameterised constructor for class NumberNotInAreaException
	 * It constructs an NumberNotInAreaException with the specified detail message
	 * 
	 * @param message Specified detail message
 */
public NumberNotInAreaException(String message) {
		
		super(message);
		
	}

}
