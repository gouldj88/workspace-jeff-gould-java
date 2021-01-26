package com.techelevator;

import java.util.ArrayList;
import java.util.List;

/**
 * BankCustomer
 */
public class BankCustomer {
	
	private String name;
	private String address;
	private String phoneNumber;
	private Accountable newAccount;

    private List<Accountable> accounts = new ArrayList<>();   // List of Accountable objects
    
    public Accountable[] getAccounts() {
    	return accounts.toArray(new Accountable[accounts.size()]); 
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void addAccount (Accountable newAccount) {
		accounts.add(newAccount);
	}
	
	public boolean isVip() {
		int totalBalance = 0;
		for (Accountable accounts : accounts) {
		totalBalance += accounts.getBalance();
			
		}
		if (totalBalance >= 25000) {
			return true;
		}
		return false;
	}
	
}