package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


// This is the application program for the assessment

public class Module1CodingAssessment {

	public static void main(String[] args) {
		
		System.out.println("Module 1 Coding Assessment\n");
		
		TellerMachine machine1 = new TellerMachine("USBank", 1000.00, 0);
	}
		
	public void loadFile(String loadFileName) throws FileNotFoundException {
		
		File aFile = new File(loadFileName);
		Scanner inputDataFile = new Scanner(aFile);	
		
		String manufName = null;
		double depositAmt = 0;
		double withdrawalAmt = 0;
		
		while(inputDataFile.hasNext()) {				
			String aLine = inputDataFile.nextLine();	
			String[] valuesInLine = aLine.split(",");
			
			manufName = valuesInLine[0];
			depositAmt = Integer.parseInt(valuesInLine[1]);
			withdrawalAmt = Integer.parseInt(valuesInLine[2]);
		
		}
	}

}