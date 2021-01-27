package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

// Simulate a deck of PlayingCards

public class CardDeck {
	// In case you forgot, a LinkedList is a Queue - first in, first out structure
	LinkedList<PlayingCard> deckOfCards = new LinkedList<PlayingCard>();
	private int numCardsInDeck = 54;

	public CardDeck() {
		resetDeck(true); // reset deck with jokers
	}

	public void showDeck() {
		System.out.println("Number of Cards in Deck: " + deckOfCards.size());
		for (PlayingCard aCard : deckOfCards) {
			System.out.println(aCard);
		}
	}

	public boolean anyCardsInDeck() {
		if (deckOfCards.size() > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public PlayingCard dealCard() {
		if (deckOfCards.size() > 0) {		//As long as there are cards in the deck
			return deckOfCards.remove(); 	// return the top/first card and remove it from the queue
		}
		else {
			 return null;		// If no cards in deck, return null
		}
	}

	public void resetDeck(boolean withJoker) {
		deckOfCards.clear();	// remove all cards in the deck

		for (int i = 1; i < 14; i++) {	// Add all the Clubs to the deck
			deckOfCards.add(new PlayingCard(i, "CLUBS"));
		}
		for (int i = 1; i < 14; i++) {	// Add all the Hearts to the deck
			deckOfCards.add(new PlayingCard(i, "HEARTS"));
		}
		for (int i = 1; i < 14; i++) {	// Add all the Spades to the deck
			deckOfCards.add(new PlayingCard(i, "Spades"));
		}
		for (int i = 1; i < 14; i++) {	// Add all the diamonds to the deck
			deckOfCards.add(new PlayingCard(i, "DIAMONDS"));
		}

		if (withJoker) {
			deckOfCards.add(new PlayingCard(0, "JOKER"));
			deckOfCards.add(new PlayingCard(0, "JOKER"));
		}
	}

	public void shuffleDeck() { 				// Shuffle the deck
		resetDeck(false);						// Give me a new deck with no joker
		Collections.shuffle(deckOfCards);		// 
	}

}