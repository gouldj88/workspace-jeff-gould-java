package com.techelevator.myFileReadingCode;

import java.io.File;	// include the code to support Java file i/o
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyFileReader {
	// "throws" tell the compiler to know that your code might throw an exception
	public static void main(String[] args) throws FileNotFoundException {
		
		// Read the data from a file containing lines of numbers separated by commas
		// Display the line we read from the file
		// Sum the numbers
		// Average the numbers
		// Print the sum and average
		
		int sum = 0;
		double average = 0;
		// 
		// Instantiate/define a file object for the file containing the data.
		File theFile = new File("./data/numbers.txt"); // "." start where you are. /data then go to the data folder.  /numbers.txt then the file called numbers.txt
		
		// Instantiate a Scanner object for the file
		Scanner fileReader = new Scanner(theFile);
		
		// Loop through the file one line at a time
		while(fileReader.hasNext()) {							// As long as the file has a next line to read
			String aLine = fileReader.nextLine(); 				// Get the next line from the file
			System.out.println("The line read: " + aLine);		// Display the line from the file
			String[] theNumbers = aLine.split(",");				// Split the line based on the comma
			for (int i = 0; i < theNumbers.length; i++) {		// Loop through the String number values, one at a time
				int aNumber = Integer.parseInt(theNumbers[i]);	// Convert the current element in theNumbers to an int
				sum = sum + aNumber;
				
			}
			average = (double)sum / theNumbers.length;
			System.out.println("Sum: " + sum + " Avg: " + average);
		}	// end of the while loop
		fileReader.close(); // Close the Scanner to avoid a resource leak
}	// end of main()
}