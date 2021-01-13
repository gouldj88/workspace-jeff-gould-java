// this is a comment
/* this is
 * a block comment
 */

package com.techelevator; // package the holds the classes for the application

public class Lecture { //A class within the application

	public static void main(String[] args) { // a function in the application
		
		//variables are used to hold data needed for the program
		//data and understanding the data is fundamental to writing a successful program
		//in Java a variable is defined: datatype name;
		//									datatype name = initial-value;
		//If an initial value is not specified when you define the variable
		//Its contents is unknown which may lead to errors or unpredictable results
		//Its a good idea to always initialize variables
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		int numberOfExercises = 26;

		System.out.println("The value in numerOfExercises is " + numberOfExercises);

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/

		double half = 0.5;
		System.out.println("half contains: " + half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/
		
		String name = "TechElevator";
		System.out.println(name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
		int seasonsOfFirefly = 1;
		System.out.println(seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
		String myFavoriteLanguage = "Java";
		System.out.println(myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/
		double pi = 3.1416;
		System.out.println(pi);
;
		/*
		7. Create and set a variable that holds your name.
		*/
		
		name = "Jeff";
		System.out.println(name);
		
		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		
		int mouse = 2;
		System.out.println(mouse);

		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/

		double batteryLife = 0.98;
		System.out.println(batteryLife);
		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		
		int difference = 121 - 27;
		System.out.println("Difference is " + difference);
		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/

		double sum  = 12.3 + 32.1;
		System.out.println("Sum is " + sum);
		/*
		12. Create a String that holds your full name.
		*/
		String fullName = "Jeff Gould";
		System.out.println("Full name: " + fullName);
		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		String helloName = "Hello, " + fullName;
		System.out.println(helloName);
		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		helloName = helloName + ", Esquire";
		System.out.println(helloName);
		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		helloName += ", Esquire";
		System.out.println(helloName);
		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		String saw = "Saw ";
		saw += 2;
		System.out.println(saw);
		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		saw +=0;
		System.out.println(saw);
		/*
		18. What is 4.4 divided by 2.2?
		*/
		System.out.println("4.4 Divided by 2.2: " + 4.4 / 2.2);
		/*
		19. What is 5.4 divided by 2?
		*/
		System.out.println("5.4 divided by 2: " + 5.4 / 2);
		/*
		20. What is 5 divided by 2?
		*/
		System.out.println("5 Divided by 2: " + 5 / 2);
		/*
		21. What is 5.0 divided by 2?
		*/
		System.out.println("5.0 Divided by 2: " + 5.0 / 2);
		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
		System.out.println("66.6 divided by 100: " + 66.6 / 100);
		System.out.println("Answer is correct.");
		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
		System.out.println("Remainder of 5 divided by 2 is " + 5 % 2);
		/*
		24. What is 1,000,000,000 * 3?
		*/
		System.out.println("1,000,000,000 / 3: " + (long)1000000000 * 3);
		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/
		boolean doneWithExercises = false;
		System.out.println("Done with exercise: " + doneWithExercises);
		/*
		26. Now set doneWithExercise to true.
		*/
		doneWithExercises = true;
		System.out.println("Done with excercise: " + doneWithExercises);
	}

private static String parseInt(int i) {
	// TODO Auto-generated method stub
	return null;
}

}
