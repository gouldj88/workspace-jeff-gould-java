package com.techelevator;

public class ItalianCard  extends PlayingCard { // subclass of PlayingCard
	
	public ItalianCard() { // Default constructor
	// Because this is a subclass, we need to run a constructor of the super class.
	// The superclass has only one 3-arg constructor that takes: value, suit, color
	//
	// Default Italian Card: 1, SWORDS, RED
	super(1, "SWORDS", "RED");
	
}

}
