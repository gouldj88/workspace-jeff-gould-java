package com.techelevator;

public class TellerMachine {
	
	private String manufacturer;
	private double deposits;
	private double withdrawals;
	private double balance;
	
	public TellerMachine (String manufacturer, double deposits, double withdrawals) {
		this.manufacturer = manufacturer;
		this.deposits = deposits;
		this.withdrawals = withdrawals;
	}
	
	
	public void balance() {
		balance = balance + (deposits-withdrawals);
		
	}

	public double getBalance() {
		return balance;
	}


	@Override
	public String toString() {
		return "ATM - {" + manufacturer + "} - {" + balance + "}";
	}
	
	
}
