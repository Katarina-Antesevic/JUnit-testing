package calculators;

import exceptions.DivisionByZeroException;
import exceptions.NotSupportedOperationException;

/**
 * The Calculator program implements an application that
 * has ability to do calculations with two numbers.
 * Calculations include: addition (+), subtraction (-),
 * multiplication (*) and division (/).
 * 
 * <b>Note:</b>Be careful not to divide number by ZERO,
 * or use non-supported operator!
 * 
 * @author 		Katarina Antesevic
 * @version 	1.0
 * @since		2021-11-19
 * 
 */
public class Calculator {

	private Double currentValue = 0.0;
	
	
	/**
	 * This is default constructor for class Calculator. 
	 * It is called with the purpose of creating instance of this class.
	 * Since it has no parameters, and default value of parameter currentValue is 0.0,
	 * created instance will have one attribute, which value is 0.0
	 * 
	 */
	public Calculator() {
		
		super();
		
	}
	

	/**
	 * This is parameterised constructor for class Calculator
	 * 
	 * @param currentValue This is value that programmer need to forward to parameterised constructor
	 * 
	 */
	public Calculator(Double currentValue) {
		
		super();
		this.currentValue = currentValue;
		
	}
	
	
	/**
	 * This method is used to give information about value of private 
	 * attribute currentValue
	 * 
	 * @return Double This is private attribute currentValue for the class Calculator
	 * 
	 */
	public Double getCurrentValue() {
		
		return currentValue;
		
	}
	

	/**
	 * This method is used to set value of private attribute currentValue for the class Calculator 
	 * 
	 * @param currentValue This is the first and only parameter to setCurrentValue method.
	 * 		  			   This is Double value
	 * 
	 */
	public void setCurrentValue(Double currentValue) {
		
		this.currentValue = currentValue;
		
	}
	

	/**
	 * Method calculate is method that receives two parameters: value and operator.
	 * It allows following operations:addition, subtraction, multiplication and division.
	 * Based on this statement programmer is allowed to use these chars as second parameter:
	 * '+', '-', '*' and '/'.
	 *
	 * @param value	This is the first parameter to calculate method.
	 * 				It is Double value.
	 * 
	 * @param operator This is the second parameter to calculate method.
	 * 				   It is char value and it can be one of following chars:'+', '-', '*' and '/'.
	 * 				   If programmer chooses some other value of char, NotSupportedOperationException
	 * 				   is thrown.
	 * 
	 * 
	 * @throws DivisionByZeroException This is exception thrown in case that programmer
	 * 								   sets value of first parameter to zero and second
	 * 								   parameter to '/'.
	 * 
	 * @throws NotSupportedOperationException This is exception thrown in case that programmer
	 * 										  sets value of second parameter to anything else
	 * 									      but '+', '-', '*' or '/'.
	 * 
	 * @see DivisionByZeroException
	 * @see NotSupportedOperationException
	 * 
	 */
	public void calculate(Double value, char operator) throws DivisionByZeroException, NotSupportedOperationException{
		
		if ( operator == '+' ) {
			
			currentValue += value;
			
		} 
		
		else if ( operator == '-' ) {
			
			currentValue -= value;
			
		}
		
		else if ( operator == '*' ) {
			
			currentValue *= value;
			
		}
		
		else if ( operator == '/' ) {
			 
			if( value == 0.0 ) {
				
				throw new DivisionByZeroException( "Division by ZERO is NOT allowed!");
				
			}
			
			currentValue /= value;
			
		}
		
		else {
			
			throw new NotSupportedOperationException( "You used operator that is NOT supported! Operator must have value:+, -, * or /" );
			
		}
	}

}
