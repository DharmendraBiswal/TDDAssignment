package com.yash.TDDAssignment;

public class FizzBuzz {

	public String stringAsPerDivisibility(int number) {

		return number%3==0 && number%5==0 ? "FizzBuzz": number%5==0 ? "Buzz": number%3==0 ? "Fizz" : Integer.toString(number);

	}

}
