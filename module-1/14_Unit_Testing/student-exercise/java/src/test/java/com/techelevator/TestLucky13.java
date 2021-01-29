package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLucky13 {

	private Lucky13 testCode = new Lucky13();
	@Test
	public void TestGetLucky() {
		assertTrue("Wrong return", testCode.getLucky(new int[] {0, 2, 4}));
		assertFalse("Wrong return", testCode.getLucky(new int[] {1, 2, 3}));
		assertFalse("Wrong return", testCode.getLucky(new int[] {1, 2, 4}));
	}

}
