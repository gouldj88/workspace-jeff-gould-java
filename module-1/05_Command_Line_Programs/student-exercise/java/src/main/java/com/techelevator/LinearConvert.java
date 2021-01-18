package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		
		int userLength;
		String userUnit;
		
		System.out.println("Please enter a length: ");
		userLength = keyboard.nextInt();
		
		System.out.println("Is the measurement in (m)eter or (f)eet? ");
		userUnit = keyboard.next();
		
		if (userUnit.equals("f"))
		{		
			System.out.println(userLength + "f is " + (int)(userLength * 0.3048) + "m");
		}
		else if (userUnit.equals("m"))
		{
			System.out.println(userLength + "m is " + (int)(userLength * 3.2808399) +"f");
		}
		else
		{
			System.out.println("Incorrect entry. Program ending.");
		}
		
		
	}

}
