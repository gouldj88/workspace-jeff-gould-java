package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringBits {
	
	private StringBits testCode = new StringBits();

	@Test
	public void TestGetStringBits() {
		assertEquals("Wrong return", "Hlo", testCode.getBits("Hello"));
		assertEquals("Wrong return", "H", testCode.getBits("Hi"));
		assertEquals("Wrong return", "Hello", testCode.getBits("Heeololeo"));
	}

}
