package com.yash.TDDAssignment;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.mockito.InjectMocks;

public class UniqueWordCountTest {

	@InjectMocks
	private UniqueWordCount uniqueWordCount;

	@Test
	public void shouldReturnUniqueWordCountWhenInputContainsSpaceDelimeter() {

		uniqueWordCount = new UniqueWordCount();

		Map<String, Long> stringWithOccurance = new HashMap<String, Long>();
		stringWithOccurance.put("boom",2L);
		stringWithOccurance.put("bang",1L);

		assertEquals(stringWithOccurance, uniqueWordCount.countUniqueWords("boom bang boom"));
	}

}
