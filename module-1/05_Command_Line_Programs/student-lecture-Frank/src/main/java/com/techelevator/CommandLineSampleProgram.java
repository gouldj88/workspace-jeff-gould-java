package com.techelevator;
// IF we use something that is not part of the standard Java language we need to import the code that supports it
import java.util.Scanner; // Give me access to the Scanner stuff provided by Java

public class CommandLineSampleProgram {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Frank's Command Line Sample Program");
		
		// This code will read input from the keyboard and process it
		
		// Define an object to represent the keyboard in this program
		// Scanner is the class that java provides for us to define keyboard
		
		Scanner keyboard = new Scanner(System.in); // create scanner object from the keyboard
		
		String aLine; // Will hold the line of input from the keyboard
		
		System.out.println("Please enter a line: ");
		aLine = keyboard.nextLine(); // go to the user input object and get the nextLine
		
		System.out.println("You entered " + aLine); //display line entered by the user
		
		System.out.println("Please enter a whole number: ");
		int aNumber = keyboard.nextInt(); //Get an int from the keyboard
		keyboard.nextLine(); // remove the enter left in the keyboard buffer by nextInt
		System.out.println("You entered the number: " + aNumber); //Show what we got
		
		// int theNumber = Integer.parseInt(aLine);
		
		// We can use the Interger.parseInt() or Double.parseDouble() to convert a String to a numeric
		System.out.println("Half of that number is: " + aNumber / 2);
		
		// Get a series of values from a user and determine the sum and average
		// 1. Ask the user to enter a value or indicate that they are done ("N" = done)
		// 2. If they are not done:
		//    a. convert the value entered in to a numeric
		//    b. add the converted value to a sum
		//    c. count that they entered a number so we can calculate the average
		// 3. Once they are done, display the sum and the average
		
		String theValue =  ""; // hold the value entered by the user
		double sum = 0;        // hold the sum of the values they enter- double because we are allowing decimal values
		int numNums = 0;       // hold the number of values they enter
		
		// In this case we will specify a never ending loop by looping while true
		while(true) { // loop until we break out of loop
			System.out.println("Enter 'N' to end");
			theValue = keyboard.nextLine(); // Get input from user
			if (theValue == "N") {				// if they entered "N":
				break;						// end the loop
			}
			double valueEnter = Double.parseDouble(theValue); //Convert what they entered from a String to a double
			sum = sum + valueEnter;
			numNums++;
			
		}
		System.out.println("The sum of the numbers is: " + sum);
		System.out.println("You entered " + numNums + " numbers");
		System.out.println("The average of the numbers is: " + (sum/numNums));
		                          
	}

}
