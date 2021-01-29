package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LectureTest {

    Lecture exercises = new Lecture();

    @Test
    public void testReturnArray() {
    	//	Since the method we are testing returns an int[] - we use arrertArrayEquals to check the result
    	// the Arrange, Act and Assert are combined into one statement
        assertArrayEquals(new int[] { 80, 8080, 443 }, exercises.returnArray());
    }
    
    /*
     * int [] nums = new int [];  // Arrange - define teh data to be tested
     * 
     * 		nums[0] = 80;		// Act - generate
     * 		nums[1] = 8080; 	// test result
     * 		nums[2] = 443;		// we expect
     */

    @Test
    public void testReturnFirstElement() {
    	//	Since the method we are testing returns an int, we use assertEquals
        assertEquals("That's not the first element in that array", 80, exercises.returnFirstElement());
    }

    @Test
    public void testReturnLastElement() {
        assertEquals("That's not the last element", 443, exercises.returnLastElement());
    }

    @Test
    public void testReturnFirstElementOfParam() {
    	// The method we are testing returns an int, so we use assertEquals to check it
    	// But also, the method receives a parameter which is an int[], we need to pass an int[] to it when we test
        assertEquals("That's not the first element from {5, 10, 15}", 5,
                exercises.returnFirstElementOfParam(new int[] { 5, 10, 15 })); // combined Arrange, Act, Assert into one statement
        assertEquals("That's not the first element from {10, 20, 30, 40, 50}", 10,
                exercises.returnFirstElementOfParam(new int[] { 10, 20, 30, 40, 50 }));
    }

    @Test
    public void testReturnLastElementOfParam() {
        assertEquals("That's not the last element from {5, 10, 15}", 15,
                exercises.returnLastElementOfParam(new int[] { 5, 10, 15 }));
        assertEquals("That's not the last element from {10, 20, 30, 40, 50}", 50,
                exercises.returnLastElementOfParam(new int[] { 10, 20, 30, 40, 50 }));
    }

    @Test
    public void testReturnVariableFromBlock() {
        assertEquals(15, exercises.returnVariableFromBlock(3));
    }

    @Test
    public void testReturnOperationInBlock() {
    	// Since the method we are testing returns boolean, we use assertTrue or assertFalse
        assertTrue("Not true yet!", exercises.returnOperationInBlock());
    }

    @Test
    public void testReturnVariableInScope() {
    	// Because the method returns a double, we need to fudge-factor to test for equals
        assertEquals("Not that one, try again.", 5.0, exercises.returnInScopeVariable(), 0.001);
    }

    @Test
    public void testReturnCounterFromLoop() {
        assertTrue("Not true yet!", exercises.returnCounterFromLoop());
    }

    @Test
    public void testReturnCorrectCount() {
        assertTrue("Not Correct Yet!", exercises.returnCorrectCount());
    }

    @Test
    public void testReturnCorrectCountTimes() {
        assertTrue("Not Correct Yet!", exercises.returnCountCorrectTimes());
    }

    @Test
    public void testReturnSumEveryOtherNumber() {
        assertTrue("Not Correct Yet!", exercises.returnSumEveryOtherNumber());
    }
}