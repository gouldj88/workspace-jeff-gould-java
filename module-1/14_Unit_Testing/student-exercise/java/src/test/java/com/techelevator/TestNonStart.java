package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNonStart {

	private NonStart testCode = new NonStart();
	@Test
	public void TestGetPartialString() {
		assertEquals("Wrong return", "ellohere", testCode.getPartialString("Hello", "There"));
		assertEquals("Wrong return", "avaode", testCode.getPartialString("java", "code"));
		assertEquals("Wrong return", "hotlava", testCode.getPartialString("shotl", "java"));
	}

}
