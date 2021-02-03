package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FizzWriter {

	public static void main(String[] args) throws IOException {

		File outputFile = new File("FizzBuzz.txt");
		outputFile.createNewFile();
		PrintWriter writerFile = new PrintWriter(outputFile);
		
		for(Integer i = 1; i < 301; i++) {
			String loop = i.toString();
			if(i % 5 == 0 && i % 3 == 0) {
				writerFile.println("FizzBuzz");
			}
			else if(i % 5 == 0 || loop.contains("5")) {
				writerFile.println("Buzz");
			}
			else if(i % 3 == 0 || loop.contains("3")) {
				writerFile.println("Fizz");
			}
			else writerFile.println(i);
		}
		writerFile.close();
	}

}
