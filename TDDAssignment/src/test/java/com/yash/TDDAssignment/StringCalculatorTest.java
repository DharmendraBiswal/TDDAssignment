package com.yash.TDDAssignment;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import java.util.logging.Logger;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StringCalculatorTest {

	@InjectMocks
	private StringCalculator stringCalculator;

	@Mock
	Logger logger;

	@Test
	public void shouldReturnZeroWhenInputIsEmpty() {

		stringCalculator = new StringCalculator();

		assertEquals(0, stringCalculator.addString(""));

	}

	@Test
	public void shouldReturnSameIntegerWhenInputWithoutComma() {

		stringCalculator = new StringCalculator();

		assertEquals(1, stringCalculator.addString("1"));
	}

	@Test
	public void shouldReturnSumOfTwoIntegersWhenInputIsTwoNumberSeparatedByComma() {

		stringCalculator = new StringCalculator();

		assertEquals(13, stringCalculator.addString("11,2"));

	}

	@Test
	public void shouldReturnSumOfIntegersWhenInputIsSeparatedByComma() {

		stringCalculator = new StringCalculator();

		assertEquals(18, stringCalculator.addString("11,2,5"));

	}

	@Test
	public void shouldReturnSumOfIntegersWhenInputIsSeparatedByCommaAndNewLine() {

		stringCalculator = new StringCalculator();

		assertEquals(12, stringCalculator.addString("1\n2,4\n5"));

	}

	@Test
	public void shouldReturnSumOfIntegersWhenInputContainsDifferentDelimeter() {

		stringCalculator = new StringCalculator();

		assertEquals(3, stringCalculator.addString("//;\n1;2"));

	}

	@Test
	public void shouldReturnSumOfIntegersWhenInputNumbersLessThanEqualsThousand() {

		stringCalculator = new StringCalculator();

		assertEquals(5, stringCalculator.addString("//;\n1;1001;4"));

	}

	@Test
	public void shouldReturnSumOfIntegersToLogger() {

		doNothing().when(logger).info("3");

		assertEquals(3, stringCalculator.addString("//;\n1;2"));
		verify(logger).info("3");

	}

	@Rule 
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void shouldThrowRuntimeExceptionWhenInputNumberIsNegative() {

		stringCalculator = new StringCalculator();

		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Negative numbers not allowed:[-1, -2]");
		
		stringCalculator.addString("//;\n1;1001;4;-1;5;-2");

	}

}
