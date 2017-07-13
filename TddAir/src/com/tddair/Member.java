package com.tddair;

import java.util.ArrayList;
import java.util.List;

public class Member {
	
	private String userName;
	private String emailId;
	private String status;
	private int miles;
	private int balance;
	private int eligibleSeatUpgradeBalance;
	


	private List<Flight> flightList;
	
	public Member(String userName,String emailId) {
		this.userName = userName;
		this.emailId = emailId;
		flightList = new ArrayList<>();
		this.miles = 0;
		this.balance =10000;
		this.status="RED";
	}
	
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMiles() {
		return miles;
	}

	public void setMiles(int miles) {
		this.miles = miles;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void addFlight(Flight flight) {
		this.miles += flight.getMileage();
		this.balance += flight.getMileage();
	}


	public void upgradeSeats(int inputBalanceMiles, int seatQuantity) {
		if ("RED".equalsIgnoreCase(getStatus()) && inputBalanceMiles >= 10000) {
			setEligibleSeatUpgradeBalance(1);
			setBalance(balance-10000);
		}
	}




	public int getEligibleSeatUpgradeBalance() {
		return eligibleSeatUpgradeBalance;
	}


	public void setEligibleSeatUpgradeBalance(int eligibleSeatUpgradeBalance) {
		this.eligibleSeatUpgradeBalance = eligibleSeatUpgradeBalance;
	}

}
