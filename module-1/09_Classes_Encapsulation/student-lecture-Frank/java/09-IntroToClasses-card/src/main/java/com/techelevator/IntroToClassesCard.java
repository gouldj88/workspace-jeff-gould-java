package com.techelevator;

public class IntroToClassesCard {
        //------------------------------------------------------------------------------------------------------------
        // Application program for the Intro To Classes App
        //------------------------------------------------------------------------------------------------------------
		//
		// Every Java application must have one method called main()
		//
		// main() is where execution of the program starts for any Java application
		//
		// main() is the Application Program
		//
		// An Application Program instantiates and manipulates objects to get its work done
		//
        public static void main(String[] args) {
        /*
        *  This program will demonstrate several concepts presented in the Java cohort
        *  in the topic Introduction to Classes 		
        */
        // To instantiate an object:
        	PlayingCard aCard = new PlayingCard();  // the () after the class name causes a constructor for the class to be run
        											// if no constructor for the class is found, a default constructor is run
        	
        	System.out.println(aCard); 	//display aCard
        								//System.out.println - display String
        								//Whatever you give inside () must be convertible to a String
        								//aCard is a PlayingCard type, which is not a String and can't be converted to a String
        								//System.out.println is going to look for a method to convert aCard to a String
        								//A class may provide a method called toString() to return a String representation of the object
        								//If a toString() is not provided for the class, an error occurs when a String is needed
        								//System.out.println looks for a toString() method for the PlayingCard class
        								//If a toString() is NOT found for the class of an object, it looks to any class in the family of classes the object belongs to
        								//PlayingCard does not have a toString() method, but its ancestor, the Object class, does have a toString() method.
        								//Object class toString() method returns: package-name.class-name@location
        	
        	PlayingCard anotherCard = new PlayingCard(1, "Black", "Clubs");
        	System.out.println("anotherCard is: " + anotherCard);
        	
        	PlayingCard card3 = new PlayingCard(9, "Red", "Hearts");
        	System.out.println("card3 is: " + card3);
        	
//        	System.out.println("THe value in card3 is" + card3.cardValue); this is an error because cardValue is private
        	System.out.println("The value in card3 is: " + card3.getCardValue());
        	
 //       	card3.cardValue = 1; // error because cardValue is private
        	card3.setCardValue(1);
        	System.out.println("The value in card3 is: "+ card3.getCardValue());
	
	}
}
		 

