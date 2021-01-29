package com.techelevator;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestWordCount {
	
	private WordCount testCode = new WordCount();

	@Test
	public void TestGetCount() {
		Map<String, Integer> result = new HashMap<>();
		result.put("ba", 2);
		result.put("black", 1);
		result.put("sheep", 1);
		
		Map<String, Integer> result2 = new HashMap<>();
		result2.put("a", 2);
		result2.put("b", 2);
		result2.put("c", 1);
		
		String[] test = new String[] {"ba", "ba", "black", "sheep"};
		String[] test2 = new String[] {"a", "b", "a", "c", "b"};
		
		assertEquals("Wrong return", result, testCode.getCount(test));
		assertEquals("Wrong return", result2, testCode.getCount(test2));
	}

}
