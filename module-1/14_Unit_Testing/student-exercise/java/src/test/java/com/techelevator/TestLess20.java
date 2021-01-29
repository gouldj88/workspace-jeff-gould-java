package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLess20 {
	
	private Less20 testCode = new Less20();

	@Test
	public void TestIsLessThanMultipleOf20() {
		assertTrue("Wrong Return", testCode.isLessThanMultipleOf20(18));
		assertTrue("Wrong Return", testCode.isLessThanMultipleOf20(19));
		assertFalse("Wrong Return", testCode.isLessThanMultipleOf20(20));
	}

}
