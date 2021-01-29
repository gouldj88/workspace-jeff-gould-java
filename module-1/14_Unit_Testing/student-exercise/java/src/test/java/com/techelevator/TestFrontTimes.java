package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFrontTimes {
	private FrontTimes testCode = new FrontTimes();

	@Test
	public void TestGenerateString() {
		assertEquals("Wrong Return", "ChoCho", testCode.generateString("Chocolate", 2));
		assertEquals("Wrong Return", "ChoChoCho", testCode.generateString("Chocolate", 3));
		assertEquals("Wrong Return", "AbcAbcAbc", testCode.generateString("Abc", 3));
	}

}
