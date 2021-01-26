package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AmericanPlayingCard extends PlayingCard{
	//static means there is only one occurrence of the variable regardless of the number of objects
	//static variables are automatically created when the process starts
	//final means its a constant (cannot be changed after initialization)
	
	private static final int    DEFAULTCARDVALUE = 0;
	private static final String DEFAULTCOLOR     = "BLACK";
	private static final String DEFAULTSUIT      = "Joker";
	private static final int    MAXVALUE         = 13;
	private static final int    MINVALUE         = 0;
	private static Map<String,  String> suitMap  = new HashMap<String , String>();  
	private static Map<Integer, String> valueMap = new TreeMap<Integer, String>(); 
	
	// Because we need a static method to call initializeMaps
	//	and constructor cannot be static
	//	we use an anonymous method (method with no name) to call initializeMaps()
	// Static, Anonymous methods are automatically run when the process starts
	
	static {  // the method containing the call to initializeMaps
			  // must be static because the Maps are static
		initializeMaps();  // run the method to initialize Maps
	}
	
	public AmericanPlayingCard() 
	{
		super(DEFAULTCARDVALUE, DEFAULTSUIT, DEFAULTCOLOR);
	} 

	public AmericanPlayingCard(int value, String suit) {
		// a subclass must run a superclass constructor from it's constructor - super()
		// as the very first thing it does
		// 
		super(value,                                                        // Call super 3-arg constructor with values passed
			  suitMap.containsKey(suit) ? suit : DEFAULTSUIT,               // If valid suit passed, use it. Otherwise use DEFAULTSUIT
		      suitMap.get(suit) != null ? suitMap.get(suit) : DEFAULTCOLOR);// If valid suit passed, use color for suit. Otherwise use DEFAULTCOLOR  
		
		if (value > MAXVALUE) {
			setValue(MAXVALUE);
		}
		if (value < MINVALUE) {
			setValue(MINVALUE);
		}
	}

	static private void initializeMaps() {
		suitMap.put("SPADES"   , "BLACK");
		suitMap.put("CLUBS"    , "BLACK");
		suitMap.put("DIAMONDS" , "RED");
		suitMap.put("HEARTS"   , "RED");
		suitMap.put(DEFAULTSUIT, DEFAULTCOLOR);
		
		valueMap.put(0,"Joker");
		valueMap.put(1,"Ace");
		valueMap.put(2,"Two");
		valueMap.put(3,"Three");
		valueMap.put(4,"Four");
		valueMap.put(5,"Five");
		valueMap.put(6,"Six");
		valueMap.put(7,"Seven");
		valueMap.put(8,"Eight");
		valueMap.put(9,"Nine");
		valueMap.put(10,"Ten");
		valueMap.put(11,"Jack");
		valueMap.put(12,"Queen");
		valueMap.put(13,"King");
	}
	
	@Override
	public String toString() {
		return "AmericanPlayingCard: " 
	          +"Value: "  + valueMap.get(getValue())
	          +" - Color: " + suitMap.get(getSuit()) 
			  +" - Suit: "  + getSuit()
			  +" - super.toString()=" + super.toString() + "\n";
	}

	public void showCard() {
		System.out.println(this.toString());
	}

}
