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
import calculators.CalculatorAdvanced;
import exceptions.NotSupportedOperationException;
import exceptions.NumberNotInAreaException;

@DisplayName("I'm a Test CalculatorAdvanced Class")
class CalculatorAdvancedTest {
	
	private CalculatorAdvanced calculatorA = new CalculatorAdvanced();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		calculatorA.setCurrentValue(0.0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		assertThat(calculatorA, notNullValue());
	}
	
	@ParameterizedTest
	@DisplayName("Parameterised constructor test")
	@MethodSource("metodaSaParametrimaConstructor")
	public void testParametrized(Double value){
		
		CalculatorAdvanced c = new CalculatorAdvanced (value);
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
	@DisplayName("CalculateAdvanced method test")
	@MethodSource("metodaSaParametrimaCalculateA")
	public void testParametrized(Double currentValue, char action, Double result) throws NumberNotInAreaException, NotSupportedOperationException{
		
		calculatorA.setCurrentValue(currentValue);
		calculatorA.calculateAdvanced(action);
		assertThat(calculatorA.getCurrentValue(), is(result));
		
	}
	
	public static Stream<Arguments> metodaSaParametrimaCalculateA() {
	    return Stream.of(
	      Arguments.of(2.0, '0', 1.0),
	      Arguments.of(0.0, '0', 1.0),
	      Arguments.of(2.0, '1', 2.0),
	      Arguments.of(1.0,'1',1.0),
	      Arguments.of(0.0, '1', 0.0),
	      Arguments.of(10.0, '1', 10.0),
	      Arguments.of(-1.0,'1',-1.0),
	      Arguments.of(-3.0, '3', -27.0),
	      Arguments.of(-3.0, '4', 81.0),
	      Arguments.of(2.0, '2', 4.0),
	      Arguments.of(2.0, '5', 32.0),
	      Arguments.of(2.0, '9', 512.0),
	      Arguments.of(0.0, '!', 1.0),
	      Arguments.of(1.0, '!', 1.0),
	      Arguments.of(5.0, '!', 120.0),
	      Arguments.of(10.0, '!', 3628800.0)
	      
	      );
	    
	}
	
	
	 @Test
	 @DisplayName("Number not in area Exception test for calculateAdvanced method")
	 void testNumberNotInAreaCalculateA() { 
		 
		 calculatorA.setCurrentValue(11.0);
		 Exception exception1 = assertThrows(NumberNotInAreaException.class, () -> calculatorA.calculateAdvanced('!'));
		 assertThat(exception1.getMessage(), is("CurrentValue must be within the limits of the interval [0, 10]!"));
		 
		 calculatorA.setCurrentValue(-1.0);
		 Exception exception2 = assertThrows(NumberNotInAreaException.class, () -> calculatorA.calculateAdvanced('!'));
		 assertThat(exception2.getMessage(), is("CurrentValue must be within the limits of the interval [0, 10]!"));
		 
		 calculatorA.setCurrentValue(56.0);
		 Exception exception3 = assertThrows(NumberNotInAreaException.class, () -> calculatorA.calculateAdvanced('!'));
		 assertThat(exception3.getMessage(), is("CurrentValue must be within the limits of the interval [0, 10]!"));
		 
		 calculatorA.setCurrentValue(-11.0);
		 Exception exception4 = assertThrows(NumberNotInAreaException.class, () -> calculatorA.calculateAdvanced('!'));
		 assertThat(exception4.getMessage(), is("CurrentValue must be within the limits of the interval [0, 10]!"));
		 
	 }
	 
	 
	 @Test
	 @DisplayName("Not supported operation Exception test for calculateAdvanced method")
	 void testNotSupportedOperationCalculateA() {
		 
		 Exception exception1 = assertThrows(NotSupportedOperationException.class, () -> calculatorA.calculateAdvanced('?'));
		 assertThat(exception1.getMessage(), is("Argumet must be '!' or number within the limits of the interval [0, 9]!"));
		 
		 Exception exception2 = assertThrows(NotSupportedOperationException.class, () -> calculatorA.calculateAdvanced('A'));
		 assertThat(exception2.getMessage(), is("Argumet must be '!' or number within the limits of the interval [0, 9]!"));
		 
	 }
	 
	 
	 @ParameterizedTest
	 @DisplayName("HasCharacteristic method test")
	 @MethodSource("metodaSaParametrimaHasCharacteristics")
	 public void testParametrizedHasCharacteristics(Double currentValue, char action, Boolean result) throws NumberNotInAreaException, NotSupportedOperationException {
			
			calculatorA.setCurrentValue(currentValue);
			assertThat(calculatorA.hasCharacteristic(action), is(result));
			
	}
		
		public static Stream<Arguments> metodaSaParametrimaHasCharacteristics() {
		    return Stream.of(
		    		
		      Arguments.of(22.0, 'A', false),
		      Arguments.of(1.0, 'A', true),
		      Arguments.of(153.0, 'A', true),
		      Arguments.of(370.0, 'A', true),
		      Arguments.of(407.0, 'A', true),
		      Arguments.of(56.0, 'A', false),
		      Arguments.of(1.0, 'P', true),
		      Arguments.of(2.0, 'P', false),
		      Arguments.of(6.0, 'P', true),
		      Arguments.of(28.0, 'P', true),
		      Arguments.of(1234.0, 'P', false)
		      );
		    
		}
		
		@Test
		 @DisplayName("Number not in area Exception test for hasCharacteristic method")
		 void testNumberNotInAreaHasCharacteristics() {
			 
			 calculatorA.setCurrentValue(0.0);
			 Exception exception1 = assertThrows(NumberNotInAreaException.class, () -> calculatorA.hasCharacteristic('A'));
			 assertThat(exception1.getMessage(), containsString("currentValue is < 1"));
			 
			 calculatorA.setCurrentValue(0.0);
			 Exception exception2 = assertThrows(NumberNotInAreaException.class, () -> calculatorA.hasCharacteristic('P'));
			 assertThat(exception2.getMessage(), containsString("currentValue is < 1"));
			 
			 calculatorA.setCurrentValue(-1.0);
			 Exception exception3 = assertThrows(NumberNotInAreaException.class, () -> calculatorA.hasCharacteristic('A'));
			 assertThat(exception3.getMessage(), containsString("currentValue is < 1"));
			 
			 calculatorA.setCurrentValue(-1.0);
			 Exception exception4 = assertThrows(NumberNotInAreaException.class, () -> calculatorA.hasCharacteristic('P'));
			 assertThat(exception4.getMessage(), containsString("currentValue is < 1"));
			 
			 calculatorA.setCurrentValue(-11.0);
			 Exception exception5 = assertThrows(NumberNotInAreaException.class, () -> calculatorA.hasCharacteristic('A'));
			 assertThat(exception5.getMessage(), containsString("currentValue is < 1"));
			 
			 calculatorA.setCurrentValue(-11.0);
			 Exception exception6 = assertThrows(NumberNotInAreaException.class, () -> calculatorA.hasCharacteristic('P'));
			 assertThat(exception6.getMessage(), containsString("currentValue is < 1"));
			 
		 }
		
		@Test
		 @DisplayName("Not supported operation Exception test for hasCharacteristics method")
		 void testNotSupportedOperationHasCharacteristics() {
			 
			 Exception exception1 = assertThrows(NotSupportedOperationException.class, () -> calculatorA.hasCharacteristic('B'));
			 assertThat(exception1.getMessage(), is("Argument must have value 'A' or 'P'!"));
			 
			 Exception exception2 = assertThrows(NotSupportedOperationException.class, () -> calculatorA.hasCharacteristic('!'));
			 assertThat(exception2.getMessage(), is("Argument must have value 'A' or 'P'!"));
			 
			 Exception exception3 = assertThrows(NotSupportedOperationException.class, () -> calculatorA.hasCharacteristic('1'));
			 assertThat(exception3.getMessage(), is("Argument must have value 'A' or 'P'!"));
			 
		 }
}
