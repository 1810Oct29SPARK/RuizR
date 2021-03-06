package com.revature.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	
	private Calculator c;

	@Before
	public void setCalculator() {
		this.c = new Calculator();
	}
	
	/*
	 * TDD: red-green refactoring start with requirement, write test, build code to
	 * match
	 * 
	 * Calculator requirements: 
	 * (Calculator class) (computes Double values of comma-separated string)
	 * 1. Calling add("") returns 
	 * 2. Calling add() with two comma-separated value return the sum of those values
	 * 3. Calling add() with null returns zero
	 * 4. Calling add() with >2 arguments throws CalculatorException
	 * 5. Calling add() with incorrect characters (anything but , and Doubles) throws CalculatorException
	 */
	
	//1
	@Test
	public void emptyStringReturnsZero() {
		assertEquals(0, c.add(""), .001); // floating-point assertions requires an offset	
	}
	
	//2
	@Test
	public void twoNumbersReturnsSum() {
		assertEquals(28.2,c.add("12.9, 15.3"),.001);
	}
	
	//3
	 @Test
     public void nullAdd() {
         assertEquals(0.0,c.add(null),.001);
     }
     
	 //4
     @Test(expected = CalculatorException.class)
     public void tooManyArguments() {
    	 try {
    		assertEquals(28.3, c.add(("12.9, 15.3, 0.1"), .001));
    		fail("Expected an CalculatorException to be thrown.");
    	 } catch (CalculatorException m) {
    		assertThat(m.getMessage();

    	 }
     }
	
}
