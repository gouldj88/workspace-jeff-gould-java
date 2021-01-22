package com.techelevator;

public class HomeworkAssignment 
{
	private int earnedMarks;
	private int possibleMarks;
	private String submitterName;
	
	//---------------------------------------------------------------------------------
	
	public int getEarnedMarks() 
	{
		return earnedMarks;
	}
	
	public void setEarnedMarks(int earnedMarks) 
	{
		this.earnedMarks = earnedMarks;
	}
	
	public int getPossibleMarks() 
	{
		return possibleMarks;
	}
	
	public String getSubmitterName() 
	{
		return submitterName;
	}
	
	public HomeworkAssignment(int possibleMarks, String submitterName) // 2-argument constructor
	{
		this.possibleMarks = possibleMarks;
		this.submitterName = submitterName;
	}
	                                  
	// A derived attribute/value - a method determines and returns
	// we make it public so anyone with an object of this class can access the methods
	
	public String getLetterGrade() 
	{
		String letterGrade = ""; // Hold the letter grade to be returned
		double percent = (double)earnedMarks / possibleMarks; // We are allowed to use the data members because this method is a member of the class
		
		if (percent >= 0.90) 
		{
			letterGrade = "A";
		}
		else if (percent >= 0.80)
		{
			letterGrade = "B";
		}
		else if (percent >= 0.70) 
		{
			letterGrade = "C";
		}
		else if (percent >= 0.60) 
		{
			letterGrade = "D";
		}
		else
		{
			letterGrade = "F";
		}
		
		
		return letterGrade;		// return the letterGrade
	}
}
