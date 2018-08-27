package com.yash.TDDAssignment;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.mockito.InjectMocks;

public class WordOccuranceTest {

	@InjectMocks
	private WordOccurance wordOccurance;

	@Test
	public void shouldReturnUniqueWordCountWhenInputContainsSpaceDelimeter() {

		wordOccurance = new WordOccurance();

		Map<String, Long> stringWithOccurance = new HashMap<String, Long>();
		stringWithOccurance.put("boom",2L);
		stringWithOccurance.put("bang",1L);

		assertEquals(stringWithOccurance, wordOccurance.countUniqueWords("boom bang boom"));
	}

}
