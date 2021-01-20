package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Exercises {

	/*
	 Note, for-each is preferred, and should be used when possible.
	 */

	/*
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 array2List( {"Apple", "Orange", "Banana"} )  ->  ["Apple", "Orange", "Banana"]
	 array2List( {"Red", "Orange", "Yellow"} )  ->  ["Red", "Orange", "Yellow"]
	 array2List( {"Left", "Right", "Forward", "Back"} )  ->  ["Left", "Right", "Forward", "Back"]
	 */
	public List<String> array2List(String[] stringArray) 
	{
		ArrayList<String> result = new ArrayList();
		
		// go through the array that is passed in, one element at a time - for loop
		// assign each element in the array to the ArrayList
		
		for(int i = 0; i < stringArray.length; i++) {
			result.add(stringArray[i]); // add the current element to the ArrayList
		}
		
		return result;
	}

	/*
	 Given a list of Strings, return an array containing the same Strings in the same order
	 list2Array( ["Apple", "Orange", "Banana"] )  ->  {"Apple", "Orange", "Banana"}
	 list2Array( ["Red", "Orange", "Yellow"] )  ->  {"Red", "Orange", "Yellow"}
	 list2Array( ["Left", "Right", "Forward", "Back"] )  ->  {"Left", "Right", "Forward", "Back"}
	 */
	public String[] list2Array(List<String> stringList) 
	{
		// Turning a ListArray into an array
		// Go through ListArray and store in String array
		String[] result = new String[stringList.size()]; // returning a String array
		
		for(int i = 0; i < stringList.size(); i++)
		{
			result[i] = stringList.get(i);
		}
		return result;
	}

	/*
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 except for any words that contain exactly 4 characters.
	 no4LetterWords( {"Train", "Boat", "Car"} )  ->  ["Train", "Car"]
	 no4LetterWords( {"Red", "White", "Blue"} )  ->  ["Red", "White"]
	 no4LetterWords( {"Jack", "Jill", "Jane", "John", "Jim"} )  ->  ["Jim"]
	 */
	public List<String> no4LetterWords(String[] stringArray) // Takes a normal String array and returns ArrayList 
	{ 
		//First convert an array to an ArrayList
		
		ArrayList<String> names = new ArrayList(); // ArrayList to be returned
		String currentElem = "";
		for (int i = 0; i < stringArray.length; i++) // iterates through the given String array
		{
			currentElem = stringArray[i];
			names.add(stringArray[i]); //add name to end of ArrayList from index i of String
			if(currentElem.length() == 4)
			{
				names.remove(currentElem);
			}

		}
		return names;
	}

	/*
	 Given an array of ints, divide each int by 2, and return an ArrayList of Doubles.
	 arrayInt2ListDouble( {5, 8, 11, 200, 97} ) -> [2.5, 4.0, 5.5, 100, 48.5]
	 arrayInt2ListDouble( {745, 23, 44, 9017, 6} ) -> [372.5, 11.5, 22, 4508.5, 3]
	 arrayInt2ListDouble( {84, 99, 3285, 13, 877} ) -> [42, 49.5, 1642.5, 6.5, 438.5]
	 */
	public List<Double> arrayInt2ListDouble(int[] intArray) 
	{
		ArrayList<Double> numbers = new ArrayList(); // ArrayList that will hold the numbers
		
		for (int i = 0; i < intArray.length; i++)
		{
			// First position in the ArrayList takes first position in the array
			double calcNum = intArray[i] / 2.0; // takes the value of the number in the array at index i and divides by two, stores in variable
			numbers.add(calcNum); // adds the result of calcNum and adds to the ArrayList
		}
		return numbers; //returns the ArrayList
	}

	/*
	 Given a List of Integers, return the largest value.
	 findLargest( [11, 200, 43, 84, 9917, 4321, 1, 33333, 8997] ) -> 33333
	 findLargest( [987, 1234, 9381, 731, 43718, 8932] ) -> 43718
	 findLargest( [34070, 1380, 81238, 7782, 234, 64362, 627] ) -> 64362
	 */
	public Integer findLargest(List<Integer> integerList) 
	{
		int max = 0;
		for(int i = 0; i < integerList.size(); i++)   //Iterate through the ArrayList
		{
			if(integerList.get(i) >= max) // if current index number is greater than the max number
			{
				max = integerList.get(i); //store the current index number as the max number
			}							  //if not, do nothing
		}
		return max; // return the value of the largest number stored in this variable
	}

	/*
	 Given an array of Integers, return a List of Integers containing just the odd values.
	 oddOnly( {112, 201, 774, 92, 9, 83, 41872} ) -> [201, 9, 83]
	 oddOnly( {1143, 555, 7, 1772, 9953, 643} ) -> [1143, 555, 7, 9953, 643]
	 oddOnly( {734, 233, 782, 811, 3, 9999} ) -> [233, 811, 3, 9999]
	 */
	public List<Integer> oddOnly(Integer[] integerArray) 
	{
		ArrayList<Integer> odds = new ArrayList(); // Will store the odd values in this ArrayList
		
		for (int i = 0; i < integerArray.length; i++) // Iterates through the given array\
			if((integerArray[i] % 2) != 0) // If the number at index does not equal 0 (odd number)...
			{
				odds.add(integerArray[i]); //add to end of ArrayList
			}							   //if not, do nothing
		return odds;
	}

	/*
	 Given a List of Integers, and an int value, return true if the int value appears two or more times in
	 the list.
	 foundIntTwice( [5, 7, 9, 5, 11], 5 ) -> true
	 foundIntTwice( [6, 8, 10, 11, 13], 8 -> false
	 foundIntTwice( [9, 23, 44, 2, 88, 44], 44) -> true
	 */
	//return bool                //take ArrayList		    takes int
	public boolean foundIntTwice(List<Integer> integerList, int intToFind)  //Will take the given integer and search through the given ArrayList
	{
		int counter = 0; //will count the number of times the given integer is found in the array
		for(int i = 0; i < integerList.size(); i++) // will iterate through each element of the ArrayList
		{
			if(integerList.get(i) == intToFind) // If given integer is found at this index location
			{
				counter++; //Increment counter
			}			   //If not, do nothing
		}
		
		if (counter >= 2)
		return true;
		
		return false;
	}

	/*
	 Given an array of Integers, return a List that contains the same Integers (as Strings). Except any multiple of 3
	should be replaced by the String "Fizz", any multiple of 5 should be replaced by the String "Buzz",
	and any multiple of both 3 and 5 should be replaced by the String "FizzBuzz"
	** INTERVIEW QUESTION **
	
	fizzBuzzList( {1, 2, 3} )  ->  [1, 2, "Fizz"]
	 fizzBuzzList( {4, 5, 6} )  ->  [4, "Buzz", 6]
	 fizzBuzzList( {7, 8, 9, 10, 11, 12, 13, 14, 15} )  ->  [7, 8, "Fizz", "Buzz", 11, "Fizz", 13, 14, "FizzBuzz"]
	
	 HINT: To convert an integer x to a string you can call x.toString() in your code (e.g. if x = 1 then x.ToString()
	 equals "1")
	 */
	//     return ArrayList          takes array of integers
	public List<String> fizzBuzzList(Integer[] integerArray) 
	{
		ArrayList<String> fizzList = new ArrayList();
		
		for (int i = 0; i < integerArray.length; i++)
		{
			if ((integerArray[i] % 5.0 == 0) && (integerArray[i] % 3.0 == 0))
			{
				fizzList.add("FizzBuzz");
			}
			else if (integerArray[i] % 5.0 == 0)
			{
				fizzList.add("Buzz");
			}
			else if (integerArray[i] % 3.0 == 0)
			{
				fizzList.add("Fizz");
			}
			else fizzList.add(integerArray[i].toString());
		}
		return fizzList;

	}

	/*
	 Given two lists of Integers, interleave them beginning with the first element in the first list followed
	 by the first element of the second. Continue interleaving the elements until all elements have been interwoven.
	 Return the new list. If the lists are of unequal lengths, simply attach the remaining elements of the longer
	 list to the new list before returning it.
	 interleaveLists( [1, 2, 3], [4, 5, 6] )  ->  [1, 4, 2, 5, 3, 6]
	 */
	//return ArrayList              takes ArrayList         and ArrayList
	public List<Integer> interleaveLists(List<Integer> listOne, List<Integer> listTwo) 
	{
		ArrayList<Integer> result = new ArrayList(); // will store the values from listOne and listTwo

		return result;
	}

}
