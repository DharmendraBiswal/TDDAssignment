package com.yash.TDDAssignment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;

public class FizzBuzzTest {

	@InjectMocks
	private FizzBuzz fizzBuzz;

	@Test
	public void shouldReturnFizzWhenInputDivisibleByThree() {

		fizzBuzz = new FizzBuzz();

		assertEquals("Fizz", fizzBuzz.stringAsPerDivisibility(6));
	}

	@Test
	public void shouldReturnBuzzWhenInputDivisibleByFive() {

		fizzBuzz = new FizzBuzz();

		assertEquals("Buzz", fizzBuzz.stringAsPerDivisibility(25));
	}

	@Test
	public void shouldReturnFizzBuzzWhenInputDivisibleByThreeAndFive() {

		fizzBuzz = new FizzBuzz();

		assertEquals("FizzBuzz", fizzBuzz.stringAsPerDivisibility(15));
	}

	@Test
	public void shouldReturnSameNumberWhenInputNotDivisibleByThreeAndFive() {
		fizzBuzz = new FizzBuzz();
		
		assertEquals("7", fizzBuzz.stringAsPerDivisibility(7));
	}
}
