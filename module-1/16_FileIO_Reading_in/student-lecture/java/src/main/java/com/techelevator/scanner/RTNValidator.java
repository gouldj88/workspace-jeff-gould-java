package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNValidator {
	
	// This program will validate bank routing numbers stored in a file
	// The file used is called: rtn.txt
	
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	public static void main(String[] args) throws FileNotFoundException {

		printApplicationBanner();
		// Instantiate a File object for the path returned from getInputFileFromUser() method
		File inputFile = getInputFileFromUser();				// Define file object for the file
																// We get the file path from a method
		try(Scanner fileScanner = new Scanner(inputFile)) {		// Define Scanner object for the file
			
			// If you try to read more lines than in the file, an Exception is thrown - program terminates with a message
			
			while(fileScanner.hasNextLine()) {					// Loop through the file as long as the file has a line to read
				String line = fileScanner.nextLine();			// Get the next line from a file and store in variable
				// once the data is in the program process, it is necessary
				String rtn = line.substring(0, 9);				// Extract the first 9 characters and store as rtn variable
				
				if(checksumIsValid(rtn) == false) {				// Pass the rtn variable to the validation method
					System.out.println(line);					// If valid, display it
				}
			}
		}
	}

	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 9000");
		System.out.println("******************");
		System.out.println();
	}

	@SuppressWarnings("resource")
	//	This method will get a path from a user and if a valid file, return a File object for the path
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);					//Instantiate an object for the keyboard
		System.out.print("Please enter path to input file >>> ");	//Display a user prompt for input
		String path = userInput.nextLine();							//Get a line of input from the keyboard
		
		File inputFile = new File(path);	//Instantiate a File object with a path entered by the user
		
		// Check to be sure what the user entered was valid, existing path to a file
		
		if(inputFile.exists() == false) { 					// Does the path given NOT exist?
			System.out.println(path+" does not exist");		// If so, display a message
			System.exit(1); 								// and end the program
		} else if(inputFile.isFile() == false) {			// was the path given NOT a file?
			System.out.println(path+" is not a file");		// if so, display message
			System.exit(1); 								// Ends the program
		}
		// If we get here, we know the path given was a valid existing file
		return inputFile;
	}

	private static boolean checksumIsValid(String routingNumber) {
		int checksum = 0;
		for(int i = 0; i < 9; i++) {
			int digit = Integer.parseInt(routingNumber.substring(i, i+1));
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
}
