package com.techelevator.reservations.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Reservation {
	
	// We can use validation annotations to verify data is what we expect
	//     aka Bean Validation
	// The controller processing objects of this class must be told to apply validation criteria by adding @Valid to the parameter
	
	@Min (value=1)				// make sure the min value for id is at least 1
    private int id;
	
	@Min (value=1)				// make sure min value for hotelID is at least 1
    private int hotelID;
	
	@NotBlank
    private String fullName;
    
    @NotNull					// make sure checkinDate is not null
    private String checkinDate;
    
    @NotNull					// make sure checkoutDate is not null
    private String checkoutDate;
    
    @Min(value=1, message="Must have at least one guest for a reservations")
    @Max(value=4, message="Cannot have more than four guests")
    private int guests;

    public Reservation() {

    }

    public Reservation(int id, int hotelID, String fullName, String checkinDate, String checkoutDate, int guests) {
        this.id = id;
        this.hotelID = hotelID;
        this.fullName = fullName;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.guests = guests;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    @Override
    public String toString() {
        return "\n--------------------------------------------" + "\n Reservation Details"
                + "\n--------------------------------------------" + "\n Id: " + id + "\n Hotel Id: " + hotelID
                + "\n Full Name: " + fullName + "\n Checkin Date: " + checkinDate + "\n Checkout Date: " + checkoutDate
                + "\n Guests: " + guests;
    }
}
