package com.techelevator;

// The import statement includes java code into your code that you need for what you are trying to do
// Usually this is code for Classes you use but have not defined yourself
//
// The format of the import statement: package-name.class-name
//
//     package  .class
import java.util.ArrayList; // Give me access to the code that supports ArrayLists
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		// ArrayList is a type of list that acts similar to an array
		// 			ArrayList has elements that are stored in which they are added to the ArrayList
		
		// Two ways to define a new ArrayList:
		// 		1. ArrayList<data-type-it-holds> name = new ArrayList();
		//		2. List<data-type-it-holds> name = new ArrayList();        // More about this next week.
		
		// Define a new ArrayList to hold Strings representing people's names
		
		ArrayList<String> names = new ArrayList();    // new, empty ArrayList of Strings
		
		//  the .add() method is used to add elements to an ArrayList
		names.add("Jason"); // adds a String object to the ArrayList
		names.add("Sam");
		names.add("Avery");
		names.add("Daniel");
		names.add("D");
		names.add("Joel");
//		names.add(1);   		// error because we are trying to add an int to an ArrayList of Strings
		
		// .size() method returns the number of elements in the ArrayList
		
		System.out.println("Our ArrayList contains: " + names.size() + " elements.");
		
		
		
		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		// .get(index) will retrieve the elements at the index specified - similar to array[index]
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println("Element #" + i + ": " + names.get(i));  // display the element at index i
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		
		names.add("Avery");    // We can add "Avery" even though it already exists in the ArrayList

		for (int i = 0; i < names.size(); i++) {
			System.out.println("Element #" + i + ": " + names.get(i));  // display the element at index i
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		
		// .add(index, object) - index is the index where you want the object to be inserted
		// Insert an element at index 3
		names.add(3, "Anne");  // Place "Anne" at index 3 and push everyone else down
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println("Element #" + i + ": " + names.get(i));  // display the element at index i
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		// .remove(index) - remove the element at the index and move all the elements up one
		
		names.remove("Joel"); // remove by name
		names.remove(4);      // remove by index
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println("Element #" + i + ": " + names.get(i));  // display the element at index i
		}
		
		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		// .contains(object) - will return true if the object is in the ArrayList, false if not
		
		System.out.println("Is Sam in the list: " + names.contains("Sam"));
		
		if (names.contains("Anne"))
			System.out.println("Anne is in our list");
		else {
			System.out.println("Anne is not in the list");
		}

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		//.indexOf(object) - return the index of the first occurrence of the object in the ArrayList
		
		System.out.println("The first time Avery appears in the list is at index " + names.indexOf("Avery"));
		
		// .lastIndexOf(object) - returns the index of the LAST occurrence of the object in the ArrayList
		
		names.add("Avery");
		System.out.println("The last time Avery appears in the list is at index " + names.lastIndexOf("Avery"));

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		// .toArray(new datatype[0]) - convert an ArrayList into an array and return the array
		
		// Convert the ArrayList<String> into a String[]
		
		String[] namesArray = names.toArray(new String[0]);  // [0] holds a place for the # of elements
		
		// Note: .length for an array does not have () - because length is a property of array
		//		 .size for an ArrayList HAS () - because size() is a method in the ArrayList class
		//										 methods always have ()
		//		 a property is a value automatically associated with a data structure
		// 
		//       Whenever you see a word that is not "if", "for", or "while", followed by parenthesis, its a method.
		
		for (int i = 0; i < namesArray.length; i++) {
			System.out.println("Element #" + i + ": " + namesArray[i]);
		}

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");
		
		// Collections.sort(ArrayListName) - The Collections class provides a sort() method
		//									 that can be used with any type of collection object
		

		Collections.sort(names); // Uses Collections class sort() method to sort the ArrayList

		for (int i = 0; i < names.size(); i++) {
			System.out.println("Element #" + i + ": " + names.get(i));
		}
		
		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(names);
		for (int i = 0; i < names.size(); i++) {
			System.out.println("Element #" + i + ": " + names.get(i));
		}
		
		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		// for-each loop is a short hand for-loop when you need to go through the entire array/ArrayList
		// 
		// for-each loop always goes from the beginning to the end of the array/ArrayList. Cannot stop and start anywhere else.
		// Cannot skip elements with a for-each loop, either. All elements are always processed.
		// You don't know which element is being processed in the loop. There is no index to tell you.
		// Format: for(datatype element-name : array/ArrayList-name)
		
		//		   each time through the loop, the element-name is assigned the current element.
		//		   use the element-name in the loop to reference the current element being processed
		
		// Use for-each loop to display all the elements in the names ArrayList
		//     curr-elem  : ArrayList name
		for (String aName : names) // Similar to for(int i = 0; i < names.size(); i++)
		{
			System.out.println("The current element is: " + aName);  // in a regular for-loop we'd use names.get(i) instead of aName
		}
		
		
	}
}
