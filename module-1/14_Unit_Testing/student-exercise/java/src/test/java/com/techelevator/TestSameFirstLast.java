package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSameFirstLast {
	
	private SameFirstLast testCode = new SameFirstLast();
	
	@Test
	public void TestIsItTheSame() {
		assertFalse("Wrong return", testCode.isItTheSame(new int[] {1, 2, 3}));
		assertTrue("Wrong return", testCode.isItTheSame(new int[] {1, 2, 3, 1}));
		assertTrue("Wrong return", testCode.isItTheSame(new int[] {1, 2, 1}));
	}
}
