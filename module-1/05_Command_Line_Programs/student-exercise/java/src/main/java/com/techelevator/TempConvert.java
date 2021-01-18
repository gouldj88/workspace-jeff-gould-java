package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in); // creates the scanner object
		
		int userTemp;
		String degreeUnit;
		
		System.out.println("Please enter the temperature: "); // prompts user to enter a temperature
		userTemp = keyboard.nextInt(); // Takes user input as a string and stores in a String variable userTemp
		
		// double tempDouble = Double.parseDouble(userTemp);
		
		System.out.println("Is the temperature enterd in (C)elsius or (F)ahrenheit? "); // Prompts the user to enter a value
		degreeUnit = keyboard.next(); // Takes user input and stores in a string variable degreeUnit
		
		
		if (degreeUnit.equals("F"))	
		{
			int tC = (userTemp - 32) * 5 / 9;
			System.out.println(userTemp + "F is " + tC + "C.");
			
		}
		else if (degreeUnit.equals("C"))
		{
			int tF = (userTemp * 9 / 5) + 32;
			System.out.println(userTemp + "C is " + tF + "F");
		}
		else
		{
			System.out.println("Incorrect entry. Program ending.");
		}
		
	}

}