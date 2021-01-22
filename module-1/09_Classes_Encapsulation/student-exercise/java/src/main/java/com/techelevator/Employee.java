package com.techelevator;

public class Employee {
	
	private int employeeID;
	private String firstName;
	private String lastName;
	private String fullName;
	private String department;
	private double annualSalary;
	
	public Employee(int employeeID, String firstName, String lastName, double salary) {
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		annualSalary = salary;
		fullName = lastName + ", " + firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public int getEmployeeId() {
		return employeeID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public double getAnnualSalary() {
		return annualSalary;
	}
	
	public void raiseSalary(double percent) {
		annualSalary = annualSalary + (annualSalary* 0.055);
	}
	
	
	
	
	
	
	
	
	
	
}





