package com.techelevator;

public class FranksArrayExample {
	
	public static void main(String[] args) {  
		
		System.out.println("Welcome to Frank's Array Example Program"); 

		int score1 = 10;
		int score2 = 20;
		int score3 = 30;
		int score4 = 50;
		int score5 = 90;
		
		int sum = 0;
		double avg = 0.0;
		
		sum = score1 + score2 + score3 + score4 + score5; // change in data required a change in code
		avg = sum / 5;										// change in data required a change in code
		
		// This code is tightly coupled because changes to the data require changes to code
		// Tightly coupled code is considered a bad practice because one might forget to change the code in one or more places
		
		System.out.println("Sum of the scores is " + sum);
		System.out.println("Avg of scores is " + avg);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------
		
		//Use an array to hold and process the scores to make the code loosely coupled
		//
		//Loosely coupled code means that changes in the data do not require changes in the code
		//The code is not directly bound to the data
		
		int[] scores = new int[5]; // define a new array with 3 elements
		
		scores[0] = 10;   //first element equal to 10
		scores[1] = 20;   //second element equal to 20
		scores[2] = 30;   //third element equal to 30
		scores[3] = 80;   //added this AFTER the code was written and tested
		scores[4] = 120;  //added this AFTER the code was written and tested
		
		//can also define and intialize at the same time. int[] scores = {10, 20, 30, 40, 50};
		
		// changing the data did NOT require any changes to the code - loosely coupled
		
		sum = 0; // reset sum to 0 to remove the previous value in sum
		// use a for-loop to process each element in the array to determine the sum
		
		// for loop will iterate through a block of code until a condition is false
		// a loop variable is defined in the for-loop and incremented each time through the loop
		// a condition in the for-loop is tested BEFORE each loop to see if it should loop
		// you will loop as long as the condition is true
		// 
		// for(int i=0; i < scores.length; i++)  the value in i will start at 0 and increment to the length of the array (0,1,2,3)
		//   1. i will be set to zero
		//	 2. check to see if i is less than the number of elements in the array (i < 3). If i is less than 0, 1, or 2, loop will execute. If i = 3, exit loop
		//   3. if #2 is true, continue to step 4; if #2 is false, we exit the loop
		//   4. execute the statements in the block
		//   5. increment i (add 1)
		//   6. go back to step 2
		//
		
		
		//     init       condition       increment
		for(int i = 0; i < scores.length; i++) {  // loop while i is a valid index for the array scores (i < scores.length)
			sum = sum + scores[i]; // add the element in scores[i] to sum; scores[i] is called the current element in the array
			
		}
		//at the end of the loop, sum will contain the total of all the elements
		
		avg = sum / scores.length; // divide sum by the number of elements in the array to get the average
		
		System.out.println("Sum of the scores is " + sum);
		System.out.println("Avg of scores is " + avg);
	}
}