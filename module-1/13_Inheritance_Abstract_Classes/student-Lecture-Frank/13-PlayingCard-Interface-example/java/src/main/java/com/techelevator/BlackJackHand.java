package com.techelevator;

import java.util.ArrayList;

// A BlackJackHand is a type of CardHand. "type of" means interface

public class BlackJackHand	 implements CardHand {	

	private int numCardsInHand = 2;			// Every CardHand has a number of starting cards in a hand
	
	private ArrayList<PlayingCard> aHand;	// Represent the hand as ArrayList
	
	public BlackJackHand() {
		aHand = new ArrayList<PlayingCard>(numCardsInHand);
	}
	
	// We need to override the methods that are required by the CardHand interface
	
	@Override
	public ArrayList<PlayingCard> getHand() {
		return aHand;
	}

	@Override
	public void addCard(PlayingCard aCard) {
		aHand.add(aCard);		// Use the ArrayList add() to add a card to the hand
		numCardsInHand++;
	}

	@Override
	public void emptyHand() {
		aHand.clear();			// Use the ArrayList clear() to empty the hand

	}

	@Override
	public void show() {
		for (PlayingCard aCard : aHand)
		{
			System.out.println(aCard);
		}
			return;
	}
	// Methods to provide additional functionality beyond what is required by a CardHand
	// Do not code @Override to ask the compiler to verify they are proper overrides since they are not overrides
	public void dealHand(CardDeck aDeck) {
		for (int i=0; i < numCardsInHand; i++ ) {
			aHand.add(aDeck.dealCard());
		}	
	}
	
}
	
