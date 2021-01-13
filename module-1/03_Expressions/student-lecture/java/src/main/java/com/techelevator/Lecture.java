package com.techelevator;

public class Lecture {
    /*
    1. This method is named returnNotOne and it returns an int. Change
    it so that it returns something other than a 1.
    */
    public int returnNotOne() {
        return 42;
    }

    /*
    2. This method is named returnNotHalf and it returns a double. Change
    it so that it returns something other than a 0.5.
    */
    public double returnNotHalf() {
        return 5;
    }

    /*
    3. This method needs to return a String. Fix it to return a valid String.
    */
    public String returnName() {
        return "Hello";
    }

    /*
    4. This method currently returns an int. Change it so that it returns a double.
    */
    public double returnDoubleOfTwo() {
        return 2.0;
    }

    /*
    5. This method should return the language that you're learning. Change
    it so that it does that.
    */
    public String returnNameOfLanguage() {
        return "Java";
    }

    /*
    6. This method uses an if statement to define what to return. Have it
    return true if the if statement passes.
    
    format-1 of if: if (logical-expression) {
    					statements to be executed if logical-expression is true
    					}
    format-2 of if: if (logical-expression) {
    					statement to be executed if logical-expression is true
    					}
    					else {
    						statement to be executed if logical-expression is false
    						}
    						
   if statements provide a way to perform conditional processing
   
   logical-expression results in a true or false
   
   logical-expression uses the conditional operators (==, !=, >, <, <=, >=, &&, ||) (see the chart)
    */
    public boolean returnTrueFromIf() { //changed false to true
        if (true) {
            return true; //return terminates the function immediately
        }

        return false; //only get to this statement when the if statement is false
    }

    /*
    7. This method uses an if to check to make sure that one is equal
    to one. Make sure it returns true when one equals one.
    */
    public boolean returnTrueWhenOneEqualsOne() {
        if (1 == 1) {
            return true;
        }

        return false;
    }

    /*
    8. This method checks a parameter passed to the method to see if it's
    greater than 5 and returns true if it is.
    */
    public boolean returnTrueWhenGreaterThanFive(int number) 
    {
        if (number > 5) 
        {
        	return true;
        }
        else 
        {
        	return false;
        }
    }

    /*
    9. If you think about it, we really don't need the if statement above.
    How can we rewrite exercise 8 to have only one line of code?
    */
    public boolean returnTrueWhenGreaterThanFiveInOneLine(int number) {
        return false; // What can we put here that returns a boolean that we want?
    }

    /*
    10. This method will take a number and do the following things to it:
    * If addThree is true, we'll add three to that number
    * If addFive is true, we'll add five to that number
    * We'll then return the result
    */
    //													2				TRUE			TRUE
    public int returnNumberAfterAddThreeAndAddFive(int number, boolean addThree, boolean addFive) {
        if (addThree) { //true
            number = number + 3; //number = 2 + 3 = 5
        }

        // We can't use an else here. They could both be true, so we have to check each one.

        if (addFive) { // true
            number += 5; //number = 5 + 5
        }

        return number; // now equals 10
    }

    /*
    11. Write an if statement that returns "Fizz" if the parameter is 3 and returns an empty String for anything else.
    */
    public String returnFizzIfThree(int number) 
    {
    	if (number == 3) 
    	{
        return "Fizz";
    	}
    	return "";
    }

    /*
    12. Now write the above using the Ternary operator ?:. If you're not sure what this is, you can Google it.
    ternary operator is shorthand of if/else. Used when an if/else is not allowed.
    				if				true	  else	  false
    format: logical-expression ? value-if-true : value-if-false
    */
    public String returnFizzIfThreeUsingTernary(int number) {
        return number == 3 ? "Fizz" : ""; //Does same thing as #11
    }

    /*
    13. Write an if/else statement that returns "Fizz" if the parameter is 3, "Buzz" if the parameter is 5 and an empty String for anything else.
    */
    public String returnFizzOrBuzzOrNothing(int number) {
        return "";
    }

    /*
    14. Write an if statement that checks if the parameter number is either equal to or greater than 18. Return "Adult" if it is or "Minor" if it's not.
    */
    public String returnAdultOrMinor(int number) {
        if (true) {
            return "Adult";
        } else {
            return "Minor";
        }
    }

    /*
    15. Now, do it again with a different boolean opeation.
    */
    public String returnAdultOrMinorAgain(int number) {
        if (true) {
            return "Adult";
        } else {
            return "Minor";
        }
    }

    /*
    16. Return as above, but also return "Teen" if the number is between 13 and 17 inclusive.
    */
    public String returnAdultOrMinorOrTeen(int number) {
        if (true) {
            return "Adult";
        } else if (true) {
            return "Teen";
        } else {
            return "Minor";
        }
    }

}