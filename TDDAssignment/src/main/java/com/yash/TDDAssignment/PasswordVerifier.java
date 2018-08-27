package com.yash.TDDAssignment;

import java.util.regex.Pattern;

public class PasswordVerifier {

	public boolean verify(String password) {

		int count = 0;
		Pattern mustContainLowerCasePattern = Pattern.compile("[a-z]");
		Pattern upperCasePattern = Pattern.compile("[A-Z]");
		Pattern digitPattern = Pattern.compile("[0-9]");
		Pattern lengthPattern = Pattern.compile("\\w{9,}");

		if (password == null)
			throw new RuntimeException("Password cannot be null");

		if (mustContainLowerCasePattern.matcher(password).find()) {
			if (upperCasePattern.matcher(password).find())
				count++;
			else if (digitPattern.matcher(password).find())
				count++;
			else if (lengthPattern.matcher(password).find())
				count++;
		} else
			throw new RuntimeException("Password must contain atleast one lower case character");
		if (count == 1)
			return true;
		else
			throw new RuntimeException("Password not OK");

	}
}
