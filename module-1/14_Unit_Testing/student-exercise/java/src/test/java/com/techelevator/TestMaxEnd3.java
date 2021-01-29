package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMaxEnd3 {

	private MaxEnd3 testCode = new MaxEnd3();
	
	@Test
	public void TestMakeArray() {
		assertArrayEquals(new int[] {3,3,3}, testCode.makeArray(new int[] {1, 2, 3}));
		assertArrayEquals(new int[] {11,11,11}, testCode.makeArray(new int[] {11, 5, 9}));
		assertArrayEquals(new int[] {3,3,3}, testCode.makeArray(new int[] {2, 11, 3}));
	}

}
