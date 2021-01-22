package com.techelevator;

import java.util.HashMap; // include the code to support a hashmap
import java.util.LinkedHashMap;
import java.util.Map;     // include the code to support a generic map
import java.util.Set;     // include the code to support a set
import java.util.TreeMap;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		// A Map is a Collections to hold and access key-value pairs
		// The key is a unique value that identifies the pair
		// The value is what you want to associate with the key
		// A Map is also known as an "associative array"
		
		//A key must be unique within the Map
		
		//Types of Maps:
		//	1. HashMap - the entries are stored in an unknown order
		//	2. TreeMap - the entries are stored in key sequence
		//	3. LinkedHashMap - the entries are stored in the order they are added to the Map
		
		//To define a Map:
		//	1. Map<key-data-type, value-data-type> nameOfMap = new type-of-map();        Example: Map<String, String> myMap = new HashMap();
		//	2. type-of-map<key-data-type, value-data-type> nameOfMap = type-of-map();    Example: HashMap<String, String> myMap = new HashMap();
		
		
		//Define a Map where the key is a String and the value is a String:
		// Map<String, String> myMap = new HashMap<String, String>();
		// HashMap<String, String> myMap = new HashMap<String, String>();
		
		// Define a map to associate a person's name to where they live = ex. "Frank" - "Mayfield"
		// Key - person's name      - a String
		// Value - where they live  - a String
		
		//   key    value     name          type of map
		Map<String, String> residence = new LinkedHashMap();  //LinkedHashMap stores in entry sequence - when you care about the order
															  //TreeMap stores in alphabetical key sequence - best when you're doing a lot of searching
															  //HashMap stores in unknown sequence - best when you don't care about the sequence
		
		//Let's add a few people to the Map
		// .put(key, value) will add an entry to a Map
		residence.put("Frank", "Mayfield");
		residence.put("Jeff", "Istanbul");
		residence.put("Brianna", "North Tonawanda");
		residence.put("D", "Wakanda");
		residence.put("Sam", "Youngstown");
		residence.put("Avery", "Cleveland Heights");
		residence.put("Daniel", "Lakewood");
		residence.put("Wally", "Mayfield");
		
		// To access a Map:  .get(key-value) - value associated with the key is what is returned
		//					 .get returns null if the key is not in the map
		
		System.out.println("D lives in: " + residence.get("D"));
		System.out.println("Brianna lives in: " + residence.get("Brianna"));
		System.out.println("Jeff lives in: " + residence.get("Jeff"));
		
		String name = "Sam";
		
		System.out.println(name + " lives in: " + residence.get(name));
		
		System.out.println("-----------------------------------------------------------------------------------");
		
		// To process all the entries in the Map, you need to get a list of keys in the map and then use those keys to process the entries
		
		//We need to get the list of keys out of the Map and then iterate through that list of keys using some form of for-loop
		
		// .keySet() - returns the list of keys in a Map as a Set object
		// A Set object is a member of the Collection class Set
		// A Set class is an unordered set of elements that must be unique
		// This is different from an ArrayList because elements in an ArrayList do not have to be unique
		// 
		// To define a Set: Set<data-type>
		//
		//Get the list of keys in our Map
		Set<String> theKeys = residence.keySet(); // Use String because they keys are Strings
		
		// Go through the set of keys using for-each loop since we want to process all they keys
//      for(data-type name-of-element : object-with-elements)
		for (String anElement: theKeys) { // Loop through the keys assigning the current key to anElement	
			String theValue = residence.get(anElement); // get the value for the current key and store it in theValue
			System.out.println(anElement + " lives in " + theValue);
		}
		System.out.println("-----------------------------------------------------------------------------------");
		// .remove(key-value) will remove an entry from the Map
		residence.remove("Frank"); //Remove entry with key Frank
		
		System.out.println("Frank lives in: " + residence.get("Frank"));
		
		System.out.println("-----------------------------------------------------------------------------------");
		
		//Since keys must be unique in a Map, if you try to add a key that already exists, the key and the value will be overwritten/updated
		
		System.out.println("Try to add Daniel living in Timbuktu");
		
		residence.put("Daniel", "Timbuktu"); //Entry is updated/overwritten, not added
		
		for (String anElement: theKeys) { // Loop through the keys assigning the current key to anElement	
			String theValue = residence.get(anElement); // get the value for the current key and store it in theValue
			System.out.println(anElement + " lives in " + theValue);
		}
		System.out.println("-----------------------------------------------------------------------------------");
		
		Map<String, Integer> nameAge = new TreeMap();
		
		//			 key          val
		nameAge.put("Jeff"		, 12);
		nameAge.put("Kyle"		, 15);
		nameAge.put("Stacy"		, 17);
		nameAge.put("Christa"	, 13);
		nameAge.put("Kim"		, 18);
		nameAge.put("Chris"		, 19);
		
		Set<String> names = nameAge.keySet();
		
		for (String element : names)
		System.out.println(nameAge.get(element));

		
		int[] numbers = new int[1];
		
		numbers[0] = 1;
		
		int hello = numbers[0];
		System.out.print(hello);
		
	}

}
