package com.yash.TDDAssignment;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;

public class PasswordVerifierTest {

	@InjectMocks
	private PasswordVerifier passwordVerifier;
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void lengthShouldBeMoreThanEightCharacter() {
		passwordVerifier = new PasswordVerifier();

		assertEquals(true, passwordVerifier.verify("abdhdss12"));
	}

	@Test
	public void shouldThrowExceptionWhenInputIsNull() {

		passwordVerifier = new PasswordVerifier();

		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Password cannot be null");

		passwordVerifier.verify(null);
	}

	@Test
	public void shouldContainAtLeastOneUpperCaseCharacter() {

		passwordVerifier = new PasswordVerifier();

		assertEquals(true, passwordVerifier.verify("cfdgA"));
	}

	@Test
	public void shouldContainAtLeastOneLowerCaseCharacter() {

		passwordVerifier = new PasswordVerifier();

		assertEquals(true, passwordVerifier.verify("123Ab"));
	}

	@Test
	public void shouldThrowExceptionWhenInputDoesNotContainOneLowerCaseCharacter() {
		passwordVerifier = new PasswordVerifier();

		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Password must contain atleast one lower case character");

		passwordVerifier.verify("PASSWORD");
	}

	@Test
	public void shouldContainAtLeastOneDigit() {

		passwordVerifier = new PasswordVerifier();

		assertEquals(true, passwordVerifier.verify("avcd1s"));
	}

	@Test
	public void shouldThrowExceptionWhenInputDoesNotSatisfiesAtLeastThreeConditions() {
		passwordVerifier = new PasswordVerifier();

		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Password not OK");

		passwordVerifier.verify("asdf");
	}

	@Test
	public void passwordShouldOkWhenAtLeastThreeConditionSatisfies() {

		passwordVerifier = new PasswordVerifier();

		assertEquals(true, passwordVerifier.verify("abcdA"));
		assertEquals(true, passwordVerifier.verify("abcd1"));
		assertEquals(true, passwordVerifier.verify("AbCD"));
		assertEquals(true, passwordVerifier.verify("abcd123"));

	}
}
