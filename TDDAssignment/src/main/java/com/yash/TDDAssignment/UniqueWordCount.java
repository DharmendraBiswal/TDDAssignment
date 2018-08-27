package com.yash.TDDAssignment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueWordCount {

	public Map<String, Long> countUniqueWords(String line) {

		String[] subStrings = line.split(" ");
		Map<String, Long> wordWithOccurance = new HashMap<String, Long>();

		wordWithOccurance = Arrays.stream(subStrings)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		return wordWithOccurance;
	}

}
