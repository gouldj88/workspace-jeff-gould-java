package com.techelevator.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.Department;
import com.techelevator.model.DepartmentDAO;


/**
 * Controller to handle API requests for the Department resource
 */
@RestController	// Tells the server this file contains controllers
public class DepartmentController {
	
	DepartmentDAO deptDAO;	// Define a reference to the deptDAO so we can access its methods
	
	// Constructor for this class - public, same name as the class
	// Use Spring dependency injection to instantiate a DepartmentDAO object and pass it to the constructor
	//		We need to include the @Component annotation in the JDBCDepartmentDAO so Spring knows
	//		its a candidate for dependency injection
	
	public DepartmentController(DepartmentDAO deptDAO) {
		this.deptDAO = deptDAO; // assign to our reference the deptDAO passed to the constructor
	}
	
	// This controller will handle the path "/departments"
	// to send back all the Departments
	
	@RequestMapping(path = "/departments", method = RequestMethod.GET) // The following function will handle /departments path
	public List<Department> listAllDepartments() {
		// Use the DepartmentDAO to get all the departments from the database and return them
		List<Department> theDepartments;
		
		theDepartments = deptDAO.getAllDepartments();	// Use the DAO method to retrieve all the Departments from the Department resource
		logAPICall("Called by /departments");
		return theDepartments;
	}
	
	// This controller will get a specific department from the Department resource based on it's ID
	// Use the DepartmentDAO getDepartmentById() method
	// The path the API will use to invoke this is: /department/id
	@RequestMapping(path = "/departments/{id}", method = RequestMethod.GET)
	public Department departmentsById(@PathVariable Long id) {
		logAPICall("Called by /departments/{id}");
		return deptDAO.getDepartmentById(id); // Call the DAO method
		
	}
	
public void logAPICall(String message) {
	 LocalDateTime now = LocalDateTime.now();
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm/dd/yyyy HH:mm:ss.A");
     String timeNow = now.format(formatter);
     System.out.println(timeNow + "-" + message);
 }

}


