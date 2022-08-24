import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import calculators.Calculator;
import exceptions.DivisionByZeroException;
import exceptions.NotSupportedOperationException;

@DisplayName("I'm a Test Calculator Class")
class CalculatorTest {
	
	private Calculator calculator = new Calculator();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		calculator.setCurrentValue(0.0);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		
		assertThat(calculator, notNullValue());
		
	}
	
	@ParameterizedTest
	@DisplayName("Parameterised constructor test")
	@MethodSource("metodaSaParametrimaConstructor")
	public void testParametrized(Double value){
		
		Calculator c = new Calculator (value);
		assertThat(c.getCurrentValue(), is(value));
		
	}
	
	public static Stream<Arguments> metodaSaParametrimaConstructor() {
	    return Stream.of(
	    		Arguments.of(0.0, 0.0),
		  	    Arguments.of(1.0, 1.0),
		  	    Arguments.of(-1.0, -1.0)
		  	    );
	    
	}
	
	
	@ParameterizedTest
	@DisplayName("Setter test")
	@MethodSource("metodaSaParametrimaSetter")
	public void testParametrizedSetter(Double value){
		
		Calculator c = new Calculator ();
		c.setCurrentValue(value);
		assertThat(c.getCurrentValue(), is(value));
		
	}
	
	public static Stream<Arguments> metodaSaParametrimaSetter() {
	    return Stream.of(
	    		Arguments.of(0.0, 0.0),
		  	    Arguments.of(1.0, 1.0),
		  	    Arguments.of(-1.0, -1.0)
		  	    );
	    
	}
	    	
	@ParameterizedTest
	@DisplayName("Calculate method test")
	@MethodSource("metodaSaParametrimaCalculate")
	public void testParametrized(Double currentValue, char operator, Double value, Double result) throws DivisionByZeroException, NotSupportedOperationException {
		
		calculator.setCurrentValue(currentValue);
		calculator.calculate(value, operator);
		assertThat(calculator.getCurrentValue(), is(result));
		
	}
	
	public static Stream<Arguments> metodaSaParametrimaCalculate() {
	    return Stream.of(
	      Arguments.of(5.0, '+', 5.0, 10.0),
	      Arguments.of(5.0, '*', 5.0, 25.0),
	      Arguments.of(6.0, '-', 5.0, 1.0),
	      Arguments.of(5.0, '/', 5.0, 1.0),
	      Arguments.of(-5.0, '+', 3.0, -2.0),
	      Arguments.of(-5.0, '-', -5.0, 0.0),
	      Arguments.of(-5.0, '*', 5.0, -25.0),
	      Arguments.of(-5.0, '/', 5.0, -1.0),
	      Arguments.of(15.0, '+', -5.0, 10.0),
	      Arguments.of(25.0, '-', -5.0, 30.0),
	      Arguments.of(5.0, '*', -5.0, -25.0),
	      Arguments.of(5.0, '-', -7.0, 12.0),
	      Arguments.of(-5.0, '+', -5.0, -10.0),
	      Arguments.of(-5.0, '-', -5.0, 0.0),
	      Arguments.of(-5.0, '*', -5.0, 25.0),
	      Arguments.of(-5.0, '/', -5.0, 1.0)
	      );
	    
 	}
	
	
	 @Test
	 @DisplayName("Division by zero Exception test")
	 void  testCalculateDivisionByZero() throws DivisionByZeroException {
		 
		 Exception exception1 = assertThrows(DivisionByZeroException.class, () -> calculator.calculate(0.0, '/'));
		 assertThat(exception1.getMessage(), is("Division by ZERO is NOT allowed!"));
		 
	 }
	 
	 
	 @Test
	 @DisplayName("Not supported operation test")
	 void testCalculateDivisionByZeroNotSupportedOperation() {
		 
		 Exception exception1 = assertThrows(NotSupportedOperationException.class, () -> calculator.calculate(5.0, '%'));
		 assertThat(exception1.getMessage(), containsString("used operator that is NOT supported"));
		  
		 Exception exception2 = assertThrows(NotSupportedOperationException.class, () -> calculator.calculate(5.0, 'a'));
		 assertThat(exception2.getMessage(), containsString("used operator that is NOT supported"));
		 
		 Exception exception3 = assertThrows(NotSupportedOperationException.class, () -> calculator.calculate(5.0, '0'));
		 assertThat(exception3.getMessage(), containsString("used operator that is NOT supported"));
		 
		 Exception exception4 = assertThrows(NotSupportedOperationException.class, () -> calculator.calculate(5.0, '9'));
		 assertThat(exception4.getMessage(), containsString("used operator that is NOT supported"));
		 
	 }
	 
}
