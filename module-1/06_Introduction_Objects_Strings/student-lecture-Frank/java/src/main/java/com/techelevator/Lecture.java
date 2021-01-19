package com.techelevator;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */

		/*
		 * Two ways to create a String:
		 * String name = new String("some value");
		 * -or-
		 * String name = "some value";
		 * 
		 * A string literal is enclosed in " "
		 * A char literal is enclosed in ' ' 
		 * 
		 * A String is NOT a character and a character is NOT a String
		 */

			String softDrink = "Diet Mtn Dew";
			
			String beverage = softDrink + " by Pepsi";
			
			System.out.println(beverage); // expecting to see "Diet Mtn Dew by Pepsi"

//--------------------------------------------------------------------------------------------------------		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();
		
		/*
		 * 
		 * A String is a class
		 * 
		 * a Class is a description of what an object of a class should look like and what the object can do.
		 * An object is an instance of a class
		 * 
		 * In cooking, a recipe describes the ingredients and process for creating a food dish.
		 * 
		 * A cake recipe describes how to make a cake - it is NOT the cake
		 * The cake that you make from a recipe is an instance of the recipe (an object)
		 * 
		 * A class contains methods to interact and manipulate objects of that class
		 * 
		 * A method is a function that is associated with a class
		 * 
		 * A member method is a method associated with a specific class
		 * 
		 * To use a method for a class: anObjectOfTheClass.method(paramenters)
		 */

		/* Commonly used String Class methods:  stringname.methodname(parameters)
		 *
		 * .length() - return the number of characters in a String
		 * .charAt(index) - returns the character at the index - 0 is first character
		 * .endsWith(search-string) - return true if the String ends with the search-string 
		 * .startsWith(search-string) - return true if the String starts with the search-string
		 * .indexOf(search-string) - return the index of the start of the 1st occurrence of search-string in the String
		 * .lastIndexOf(search-string) - return the index of the start of the last occurrence of search-string in the Stri
		 * .substring(start-index) - return from the start-index to rest of String
		 * .substring(start-index,end-index) - return from the start-index to the end-index (but not the char at end-index)
		 * .toLowerCase() - return the String in all lowercase
		 * .toUpperCase() - retrn the String in all uppercase
		 * .trim() - return the String with spaces removed from beginning and end of the String
		 * .split(delimiter) - returns and array of strings containing the characters between the delimiter specified
		 */
		// indexes: 0123456789 10 11 12 13
		String name = "Baker Mayfield";
		System.out.println("The variable name contains: " + name);
		System.out.println("The length of the value in name is: " + name.length());
		
		System.out.println("Does name end with 'field'? " + name.endsWith("field"));
		System.out.println("Does the name end with the word 'Baker'? " + name.endsWith("Baker"));
		
		System.out.println("Does name end with 'field'? " + name.startsWith("field"));
		System.out.println("Does the name end with the word 'Baker'? " + name.startsWith("Baker"));
		System.out.println("Does the name end with the word 'baker'? " + name.startsWith("baker"));
		
		if (name.startsWith("Baker"))
		{
			System.out.println("Yay");
		}
		else {
			System.out.println("Boo");
		}
		
		System.out.println("Does the name contain 'May'? " + name.contains("May"));
		// charAt(index) - index starts at 0 - positions start at 1
		System.out.println("The char 'k' is at position 4 is " + name.charAt(3));
		System.out.println("What index is 'f'? " + name.indexOf("f"));
		System.out.println("Name in all lowercase is: " + name.toLowerCase());
		System.out.println("Name in all uppercase is: " + name.toUpperCase());
		//can chain methods together
		System.out.println("name in all lowercase is: " + name.toUpperCase().indexOf("F"));
		System.out.println("The characters from the 5th to the end of the name are: " + name.substring(4)); // gives characters from the index specified to the end (index starts at 0).
		System.out.println("The characters from position 2 to position 8 are: " + name.substring(1, 8)); // gives me chars from the start index to the end index but NOT including char at end of index. Specify index to be one more than index you want included
		
		
		
//--------------------------------------------------------------------------------------------------------	
		
		/*   A String may also be created easily from an array of characters (char) */

		char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' }; // Array of characters
		
		String hello1 = new String(helloArray);  // Create a String using the array of characters
		String hello2 = new String(helloArray);  // Create a String using the array of characters
		
//--------------------------------------------------------------------------------------------------------			
		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */

		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

//--------------------------------------------------------------------------------------------------------			
		System.out.println();
		System.out.println("**************************");
		System.out.println("****** USING .split ******");
		System.out.println("**************************");
		System.out.println();
		
		String movieTitle = "External Sunshine of the Spotless Mind";
		//Display each word in the movie title on a separate line
		// That means we need to split the title based on the space
		//The String.split method will separate String into parts and return an array of Strings
		
		String[] wordsInTitle = movieTitle.split(" "); //separate movie title into individual words based on space

		for (int i = 0; i < wordsInTitle.length; i++)
		{                     
			System.out.println(wordsInTitle[i]);
		}


	}
}
