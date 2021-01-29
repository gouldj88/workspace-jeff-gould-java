package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCigarParty {

	private CigarParty testCode = new CigarParty();
	
	@Test
	public void testHaveParty() {
		assertFalse("Value returned should be false", testCode.haveParty(30, false));
		assertTrue("Value returned should be true", testCode.haveParty(50, false));
		assertTrue("Value returned should be true", testCode.haveParty(70, true));
	}

}
