package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAnimalGroupName {
	
//	First we need to define an object with the methods that we want to test
	
	private AnimalGroupName testCode = new AnimalGroupName(); // Object with the methods we want to test

	@Test // Here's a JUnit test
	public void test_correct_animal_group_name_returned_based_on_animal() {	// JUnit test method
	// The methods that are in the class we are testing are: 
	// 		String getHerd(String animalName)
	//
	//	The method returns a String - assertEquals
	// Test 1 - send "Elephant", expect "Herd"
	// Test 2 - send it "Walrus", expect "unknown"
	// Test 3 - send it "elephant", expect "Herd"
	// Test 4 - send it "ELEPHANT", expect "Herd"
	// Test 5 - send it "ELepHaNt", expect "Herd"
	
		assertEquals("Wrong animal group returned", "Herd", testCode.getHerd("Elephant"));
		assertEquals("Wrong animal group returned", "unknown", testCode.getHerd("Walrus"));
		assertEquals("Wrong animal group returned", "Herd", testCode.getHerd("elephant"));
		assertEquals("Wrong animal group returned", "Herd", testCode.getHerd("ELEPHANT"));
		assertEquals("Wrong animal group returned", "Herd", testCode.getHerd("Elephant"));
		assertEquals("Wrong animal group returned", "Herd", testCode.getHerd("ELepHaNt"));
	}
}
