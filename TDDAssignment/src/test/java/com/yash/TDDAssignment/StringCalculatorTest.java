package com.yash.TDDAssignment;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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

		Mockito.doNothing().when(logger).info("3");

		assertEquals(3, stringCalculator.addString("//;\n1;2"));
		Mockito.verify(logger).info("3");

	}

}
