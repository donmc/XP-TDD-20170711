package com.tddair;

public class Member {
	private String username;
	private String email;
	
	private boolean registered;
	private String status;
	private long ytdMiles;
	private long balance;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
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
	
	
	
}
