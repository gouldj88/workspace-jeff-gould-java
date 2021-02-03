package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) throws FileNotFoundException {
		//Ask where the quiz file is
		//User enters file path


		File fileInputPath = new File("./test_quiz.txt");
		Scanner fileReader = new Scanner(fileInputPath);
		
		ArrayList <String> genQuestions= new ArrayList();
		
		while(fileReader.hasNext()) {
			String currentLine = fileReader.nextLine();
			String[] getArray = currentLine.split("|");

				}
			
		}

		
		//while(fileReader.hasNextLine()) {
			
		//}
		//Read the first line
		//Print out the first line question/answers minus the asterisk in the correct answer
		//Prompt the user to to answer the question
		//Print out correct if the correct answer is given. Otherwise, print out incorrect
		//Do the same thing with the next question

	}

}
