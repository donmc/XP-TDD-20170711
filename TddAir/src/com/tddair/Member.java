package com.tddair;

/**
 * Created by agrawm2 on 7/12/2017.
 */
public class Member {
	
	private String username;
	private String email;
	private boolean registered;
	private StatusEnum status;
	private int ytdMiles;
	private int balance;
	
	private int seatUpgradeBalance;
	

	public Member(String username, String email) {
		this.username = username;
		this.email = email;	
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isRegistered() {
		return registered;
	}
	public void setRegistered(boolean registered) {
		this.registered = registered;
	}
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	public int getYtdMiles() {
		return ytdMiles;
	}
	public void setYtdMiles(int ytdMiles) {
		this.ytdMiles = ytdMiles;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void updateBalanceWithFlightMiles(int balance,int mileage) {
		this.balance = (mileage + balance);
	}


	public void updateStatusBasedonYtdMiles(int ytdMiles) {
		this.status=StatusEnum.calculateStatus(ytdMiles);
	}


	public void accumulateMiles( int ytdMiles, int flightMileage) {
		this.setYtdMiles(ytdMiles + flightMileage);
		
	}

	
	

	public int getSeatUpgradeBalance() {
		return seatUpgradeBalance;
	}


	public void setSeatUpgradeBalance(int seatUpgradeBalance) {
		this.seatUpgradeBalance = seatUpgradeBalance;
	}


	public void purchaseAndUpdateBalanceForSeatUpgrade(int noOfSeats) throws InSufficientMilesException{
		  StatusEnum status = this.getStatus();     
	        int milesPerUpgrade = status.getMilesPerUpgrade();
	        int totalMilesForUpgrade = noOfSeats * milesPerUpgrade;
	        if(this.balance < totalMilesForUpgrade){
	        	throw new InSufficientMilesException("No enough balance miles for the purchase!");
	        }
	        
	        this.balance-= totalMilesForUpgrade;
	        this.seatUpgradeBalance+= noOfSeats;
		
	}


	
	
	
}
