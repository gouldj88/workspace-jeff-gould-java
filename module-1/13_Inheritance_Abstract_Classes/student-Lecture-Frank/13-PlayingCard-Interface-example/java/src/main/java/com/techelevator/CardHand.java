package com.techelevator;

import java.util.ArrayList;


// Define the behaviors that must be implemented to be considered a CardHand


public interface CardHand { 	// If you want to be considered a CardHand, you MUST define these methods/behaviors
	
	public ArrayList<PlayingCard> getHand(); 	// If you want to be considered a CardHand, you must have a method that returns an ArrayList

	public void addCard(PlayingCard aCard);		// You also have to receive a PlayingCard to add to the hand
	
	public void emptyHand();					// You also have to be able to remove all PlayingCards from the hand

	public void show();							// You also have to be able to display all the cards in the hand

}
