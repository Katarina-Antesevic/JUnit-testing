package calculators;


import exceptions.NotSupportedOperationException;
import exceptions.NumberNotInAreaException;

/**
 * Class CalculatorAdvanced extends class Calculator, which means it inherits all its attributes and methods.
 * Class CalculatorAdvanced has two additional methods:calculateAdvanced and hasCharacteristic.
 * 
 * Method calculateAdvanced, depending on argument passed by a programmer, can either calculate factorial of a
 * currentValue, or power of it.
 * 
 * Method hasCharacteristic can determine if currentValue is an Armstrong or a perfect number  
 * 
 * 
 * @author 		Katarina Antesevic
 * @version 	1.0
 * @since		2021-11-19
 *
 */ 
public class CalculatorAdvanced extends Calculator {

	/**
	 * This is default constructor for class CalculatorAdvanced. 
	 * It is called with the purpose of creating instance of class CalculatorAdvanced.
	 * Since it has no parameters, and default value of parameter currentValue is 0.0,
	 * created instance will have one attribute, which value is 0.0
	 * 
	 */
	public CalculatorAdvanced() {
		
		super();
		
	}
	

	/**
	 * This is parameterised constructor for class CalculatorAdvanced
	 * 
	 * @param currentValue This is value that programmer need to forward to parameterised constructor
	 * 
	 */
	public CalculatorAdvanced(Double currentValue) {
		
		super(currentValue);
		
	}
	

	/**
	 * This method, depending on passed argument, can either calculate factorial of a
     * currentValue, or power of it.
     * If character with value between '0' and '9' is passed, method will calculate currentValue by the power of passed value
     * Furthermore, if value of passed character is '!', method will calculate factorial of currentValue
     * There are some ground rules:if power is 0, calculated value will always be 1
     * 							   if power is 1, currentValue keeps its value
     * 						
     * If passed character is equal to '!', currentValue must have value within the limits of the interval [0, 10]
     * 
	 * 
	 * 
	 * @param action This is first and only parameter to calculateAdvanced method
	 * 				 It is character value. Its value can be '0' - '9' or it can be '!'
	 * 
	 * 
	 * @throws NumberNotInAreaException This is exception thrown in case programmer wants to calculate factorial of 
	 * 									currentValue, but currentValue is not  within the limits of the interval [0, 10]
	 * 
	 * @throws NotSupportedOperationException This is exception thrown in case that value of action is not '!' or
	 * 										  value between '0' and '9'
	 * 
	 * @see NumberNotInAreaException
	 * @see NotSupportedOperationException
	 * 
	 */
	public void calculateAdvanced(char action) throws NumberNotInAreaException, NotSupportedOperationException{
		
		double tmp = (double) getCurrentValue();
		int intValue = (int) tmp;
		
		if ( action == '!' ) {
			
			if( intValue < 0 || intValue > 10) {
				
				throw new NumberNotInAreaException( "CurrentValue must be within the limits of the interval [0, 10]!" );
								
			}
			
			if ( intValue == 0 || intValue==1 ) { //0!=1, 1!=1
				
				setCurrentValue(1.0);
				
			}
			
			else {
				
				double factorial=1;
				while( intValue > 0 ) {
					
					factorial *= intValue;
					--intValue;
					
				}
			
				
				setCurrentValue(factorial);
				
			}
			
		}
		
		else if( action == '0' ) {
			
			setCurrentValue(1.0);
			
		}
		
		else if ( action == '1' ){
			
			/*double doubleValue = (double) intValue;	
			setCurrentValue(doubleValue);*/	
				
		}
		
		else if ( action >= '2' && action <= '9' ) {
			
			Double result = 1.0;
			while( action != '0' ) {
				
				result *= intValue;
				--action;
				
			}
			
			setCurrentValue(result);
			
		}
			
		
		else {
			
			throw new NotSupportedOperationException( "Argumet must be '!' or number within the limits of the interval [0, 9]!" );
			
		}
		
	}
	
	
	/**
	 * This method, depending on passed argument, can determine id currentValue is Armstrong or perfect number.
	 * Argument value can be 'A' or 'P'.
	 * In case character 'A' is passed, method will return true value if currentValue is Armstrong number, otherwise
	 * it returns false value.
	 * In case character 'P' is passed, method will return true value if currentValue is perfect number, otherwise
	 * it returns false value.
	 * 
	 * Integer value of currentValue must be > 1, otherwise exception is thrown.
	 * 
	 * 
	 * @param value This is the first and only parameter to hasCharacteristic method.
	 * 		  	    This is Boolean value.
	 * 
	 * 
	 * @return true if all conditions are fulfilled, otherwise method returns false value
	 * 
	 *  
	 * @throws NumberNotInAreaException This is exception thrown in case currentValue is set to value smaller than 1
	 * 
	 * @throws NotSupportedOperationException This is exception thrown in case passed value of method's argument is different
	 * 										  than 'A' or 'P'
	 * 
	 * @see NumberNotInAreaException 
	 * @see NotSupportedOperationException
	 * 
	 */
	public Boolean hasCharacteristic(char value) throws NumberNotInAreaException, NotSupportedOperationException{
		
		if ( value != 'A' && value != 'P') {
			
			throw new NotSupportedOperationException( "Argument must have value 'A' or 'P'!");
			
		}
		 
		else {
			
			double tmp = (double) getCurrentValue();
			int intValue = (int) tmp;
			
			if ( intValue < 1 ) {
				
				throw new NumberNotInAreaException( "Integer value of atribute currentValue is < 1!" );
				
			}
			
			if ( value == 'A' ) {
				
				int intValueTmp = intValue;
				int numberOfDigits = 0;
				while( intValueTmp > 0 ) {
					
					++numberOfDigits;
					intValueTmp /= 10;
					
				}
				
			    intValueTmp = intValue;
			    int result = 0;			    
			    while( intValueTmp > 0 ) {
			    	
			    	int temp = 1;
			    	int numberOfDigitsTmp = numberOfDigits;
			    	int lastDigit = intValueTmp % 10;
			    	while( numberOfDigitsTmp > 0 ) {
			    		
			    		temp *= lastDigit;
			    		--numberOfDigitsTmp;
			    		
			    	}
			    	
			    	result += temp; 
			    	intValueTmp/=10;
			
			    }
			    
			   if ( result == intValue ) {
				   
				   return true;
				   
			   }
			}
		
			else if ( value == 'P' ) {
				
				int intValueTmp = intValue / 2;
				int result = 1;
				
				for(int i=2; i<=intValueTmp; i++) {
					
					if ( intValue % i == 0 ) {
						
						result += i;
						
					}
					
				}
				
				if ( result == intValue ) {
					
					return true;
					
				}
				
			}
		
		}
			   
		  return false;
			   
	}
}
