package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {
	
		File inputFile = new File("./alices_adventures_in_wonderland.txt");
		
		Scanner readFile = new Scanner(inputFile);
		
		Scanner keyboard = new Scanner(System.in);
		
		int lineNumber = 0;
		

		System.out.println("What is the word you are looking for?");
		String userInput = keyboard.nextLine();
		
		System.out.println("Should the search be case sensitive? (Y/N)");
		String caseSens = keyboard.nextLine();

		
		while(readFile.hasNext()) {
			lineNumber++;
			String currentLine = readFile.nextLine();
			if(caseSens.equals("Y") && currentLine.contains(userInput)) {
				System.out.println(lineNumber + ": " + currentLine);
			}
			if(caseSens.equals("N") && currentLine.toLowerCase().contains(userInput.toLowerCase()))  {
				System.out.println(lineNumber + ": " + currentLine);
			}
			
		}
		readFile.close();
		keyboard.close();
	}

}
