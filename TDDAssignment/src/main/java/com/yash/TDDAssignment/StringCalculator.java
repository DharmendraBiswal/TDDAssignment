package com.yash.TDDAssignment;

import java.util.Arrays;
import java.util.logging.Logger;

public class StringCalculator {

	public Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public int addString(String value) {

		String delimeter = null;

		if (value.startsWith("//")) {

			delimeter = value.substring(2, 3);
			value = value.substring(value.indexOf("\n") + 1);

		}

		String[] subStrings = value.trim().length() < 1 ? new String[0] : value.split(",|\n|" + delimeter);

		int sum = Arrays.stream(subStrings).mapToInt(Integer::parseInt).filter(x -> x <= 1000).sum();

		logger.info("" + sum);

		return sum;

	}

}
