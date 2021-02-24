package com.techelevator.reservations.controllers;

// This will handle API calls sent to the server with the paths specified in the @RequestMapping
// API handlers == controllers

// Typically controllers find the data the callers needs and returns it

// Usually the data is retrieved by the controller using a DAO of some sort

// A controller normally does not have a lot of logic - it's job is to get data and return it to the caller

// Controllers are part of the MVC design pattern to structuring applications

// MVC stands for Model View Controller

// Model - data for the application
// View - how data is displayed to the user / any user interaction
// Controller - coordinates data transfer between the Model and the View


// In this application:

//	Model - handled by DAOs
//	View - handled by client
//	Controller - receives requests via API call from client, find data based on request, and return it


import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.MemoryHotelDAO;
import com.techelevator.reservations.dao.MemoryReservationDAO;
import com.techelevator.reservations.dao.ReservationDAO;
import com.techelevator.reservations.models.Hotel;
import com.techelevator.reservations.models.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController	// This tells the server that there are controllers in here to handle specified URL paths

public class HotelController {
	
	// Define references for each DAO we will use:
    private HotelDAO hotelDAO;
    private ReservationDAO reservationDAO;

    // Constructor for this class of controllers:
    public HotelController() {
        this.hotelDAO = new MemoryHotelDAO();						// Instantiate an object with the HotelDAO methods and assign to reference
        this.reservationDAO = new MemoryReservationDAO(hotelDAO);	// Instantiate an object with the ReservationDAO methods and assign to reference
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    // Assign a URL path to a method and HTTP request combination to a method
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)	// This method will handle HTTP GET URLs sent to the server with the /hotels path
    public List<Hotel> list() {
    	System.out.println("Called with the path /hotels");
        return hotelDAO.list();	// run the hotelDAO list() and returned what it returns to the API caller
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)	// This method will handle HTTP GET URLs sent to the server with the /hotels path
    public Hotel get(@PathVariable int id) {
    	System.out.println("Called with the path /hotels/" + id);
        return hotelDAO.get(id);
    }
    // Write a controller that will return all the reservations when we get the path "/reservations"
    // We will use the ReservationDAO findAll() method to get the reservations
    
    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> anyName() {
    	System.out.println("Called with the path /reservations");
    	return reservationDAO.findAll();
    }
    
    // Write a controller to add a Reservation to the Reservation resource on this server
    @RequestMapping(path = "/hotels/{id}/reservations", method = RequestMethod.POST)
    public Reservation whateverName(@RequestBody Reservation aReservation	// Take the data in the request body and instantiate a reservation object
    							   ,@PathVariable("id") int hotelId) {		// take the id from the path and store it in an int called hotelId
    	System.out.println("Called with the path /hotels/" + hotelId + "/reservations");
    	
    	return reservationDAO.create(aReservation, hotelId);	// Use the create method in the reservation DAO to create
    	
    }
    
    
}
