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
	
	
}
