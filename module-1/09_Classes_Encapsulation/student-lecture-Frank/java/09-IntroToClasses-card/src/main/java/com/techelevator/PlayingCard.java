package com.techelevator;


// public indicates anyone may use this class - instantiate objects of the class
public class PlayingCard 
{
	// This is a class to represent a playing card
	//
	// A class has data (variables) and behaviors (methods)
	//
	// We have identified the following characteristics for a playing card:
	//		1. Value
	//		2. Suit
	//		3. Color
	//		4. Shape
	//		5. Face up/down
	//
	// The characteristics or data for a class may also be called attributes
	//
	// The attributes for a class are defined as member variables
	//
	// A variable is a "member" variable if it is defined in a class
	//
	// To define a member variable: access - public - anyone can access it
	//									     private - only members of the class can access it
	//								datatype
	//								name
	//
	// Using private on methods and variables implements encapsulation
	// Encapsulation means we are protecting the data from access outside of the class
	// 
	
	//----------------------------------------------------------------------------------------------------
	// Data Members of the Class
	//----------------------------------------------------------------------------------------------------
	
	
	
	private int     cardValue; // Ace = 1, Jack = 11, Queen = 12, King = 13
	private String  cardSuite; 
	private String  color;
	private String  shape;
	private boolean faceUp;
	
	//----------------------------------------------------------------------------------------------------
	// Methods of the Class
	//----------------------------------------------------------------------------------------------------
	
	//----------------------------------------------------------------------------------------------------
	// Constructors - initialize new objects - run automatically by Java
	//----------------------------------------------------------------------------------------------------
	// Every class should provide constructor methods to initialize objects of the class
	// If constructors are not provided, Java runs a default constructor (ctor) to initialize an object
	// The Java default constructor is going to set objects=null, numerics=0, booleans=false
	//
	// Constructors are special methods in a class: no return type (not even void), name is the same name as the class.
	
	//Define a default constructor for the class
	
	PlayingCard() //Default Constructor - takes no arguments and assigns default value to the data members
	{
		cardValue =  13;
		cardSuite = "Red";
		color     = "Diamonds";
		shape     = "Circle";
		faceUp    =  true;
	}
	
	// To allow a user to define any PlayingCard, we need to create a constructor that takes parameters for the values.
	PlayingCard (int theValue, String theColor, String theSuite)
	{
		cardValue = theValue; // Set the cardValue to the value parameter passed from the user
		cardSuite = theSuite; // Set the cardColor to the color parameter passed from the user
		color     = theColor; // Set the cardSuit to the suit parameter passed from the user
		shape     = "circle"; // cardShape will always be "circle"
		faceUp    = true;  // faceUp will always be true
		
	}
	
	//----------------------------------------------------------------------------------------------------
	// Getters / Setters - methods that allow the user to retrieve values and change values from object
	
	// Due to encapsulation(private members) there is no access to data outside the class
	// Getters and setters allow us to control access from outside the class through methods
	//
	// Not all data members need to have getters and setters
	//----------------------------------------------------------------------------------------------------
	
	//----------------------------------------------------------------------------------------------------
	// Additional Methods
	//----------------------------------------------------------------------------------------------------
	
	public int getCardValue() {
		return cardValue;
	}

	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}

	public String getCardSuite() {
		return cardSuite;
	}

	public void setCardSuite(String cardSuite) {
		this.cardSuite = cardSuite;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}

	// toString() which will return a PlayingCard object as a String
	public String toString() {
		return "PlayingCard [cardValue=" + cardValue + ", cardSuite=" + cardSuite + ", color=" + color + ", shape="
				+ shape + ", faceUp=" + faceUp + "]";
	}
	

}
