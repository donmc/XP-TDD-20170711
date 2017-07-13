package com.tddair;

public class Member {
	private String username;
	private String email;
	
	private boolean registered;
	private Status status;
	private long ytdMiles;
	private long balance;
	private boolean seatUpgraded;
	private int seatupgradeQuantity;
	
	public Member(String userName, String email) {
		this.username = userName;
		this.email = email;
		this.registered = true;
		this.status = Status.Red;
		this.ytdMiles = 0;
		this.balance = 10000;
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public long getYtdMiles() {
		return ytdMiles;
	}
	public void setYtdMiles(long ytdMiles) {
		this.ytdMiles = ytdMiles;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}

	public boolean isSeatUpgraded() {
		return seatUpgraded;
	}
	
	public void setSeatUpgraded(boolean seatUpgrade) {
		this.seatUpgraded = seatUpgrade;
	}
	
	
	public int getSeatupgradeQuantity() {
		return seatupgradeQuantity;
	}
	public void setSeatupgradeQuantity(int seatupgradeQuantity) {
		this.seatupgradeQuantity = seatupgradeQuantity;
	}

	public void completeFlight(Flight flight) {
		ytdMiles +=flight.getMileage();
		balance +=flight.getMileage();
		
		status = Status.calculateMiles(ytdMiles);		
		
	}
	
	public void upgradeSeat(int quantity) {
		seatUpgraded = true;		
		seatupgradeQuantity = quantity;
		balance -= 10000*quantity;
	}
	
}
