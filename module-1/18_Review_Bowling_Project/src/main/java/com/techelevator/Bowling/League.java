package com.techelevator.Bowling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class League {
	
	private String leagueName;
	private Map<Integer, ArrayList<Bowler>> leagueMembers; // key = teamNumber, value is a set of Bowlers
	
	// Default constructor
	public League() {
		leagueName = null;
		leagueMembers = null;
	}
	
	//2-arg constructor
	public League(String leagueName, String dataFileName) throws FileNotFoundException { 
		this.leagueName = leagueName;
		// Load the data from the file given into our leagueMembers using member function
		loadFile(dataFileName);	// Run the loadFile method, sending it the file to be loaded
	}
	// method to load the file given into leagueMembers - its private because we don't want users to be able to run it
	// Only members of the class can call this method
	private void loadFile(String fileNameToLoad) throws FileNotFoundException {
		File aFile = new File(fileNameToLoad);			//Define the file object
		Scanner inputDataFile = new Scanner(aFile);		//Define the scanner object
		
		int teamNumber = 0;
		int bowlerNumber = 0;
		String bowlerName = null;
		ArrayList<Integer> scores = new ArrayList<Integer>();
		
		while(inputDataFile.hasNext()) {				//Loop while the file has lines to read
			String aLine = inputDataFile.nextLine();	//Read a line from the file
			String[] valuesInLine = aLine.split(",");
	// Define variables needed to instantiate a bowler		
			teamNumber = Integer.parseInt(valuesInLine[0]); // convert the first value from the line to an int and store it
			bowlerNumber = Integer.parseInt(valuesInLine[1]);
			bowlerName = valuesInLine[2];
			
			scores.add(Integer.parseInt(valuesInLine[3]));
			scores.add(Integer.parseInt(valuesInLine[4]));
			scores.add(Integer.parseInt(valuesInLine[5]));
			
			// Define a bowler using the constructor for a bowler
			Bowler aBowler = new Bowler(teamNumber, bowlerNumber, bowlerName, scores);
			// Add the Bowler to the Map
			
		}
	}
}
