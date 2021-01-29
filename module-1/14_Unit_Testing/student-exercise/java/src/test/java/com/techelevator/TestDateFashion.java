package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDateFashion {
	private DateFashion testCode = new DateFashion();
	
	@Test
	public void TestGetATable() {
		assertEquals("Value returned should be 2", 2, testCode.getATable(5, 10));
		assertEquals("Value returned should be 0", 0, testCode.getATable(5, 2));
		assertEquals("Value returned should be 1", 1, testCode.getATable(5, 5));
	}

}
