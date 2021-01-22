package com.techelevator;

public class FruitTree
{
	private String typeOfFruit;
	private int piecesOfFruitLeft;

public FruitTree(String typeOfFruit, int startingPiecesOfFruit) //parameter constructor
{
	this.typeOfFruit = typeOfFruit;
	piecesOfFruitLeft = startingPiecesOfFruit;
}


public String getTypeOfFruit() {
	return typeOfFruit;
}


public int getPiecesOfFruitLeft() {
	return piecesOfFruitLeft;
}

public boolean pickFruit(int numberOfPiecesToRemove) {
	if (numberOfPiecesToRemove <= piecesOfFruitLeft) {
		piecesOfFruitLeft =  piecesOfFruitLeft - numberOfPiecesToRemove;
		return true;
	}
	return false;
}
}