package com.tddair;

public class Member {

	private String userName;
	private String email;
	private String status;
	private int ytdMiles;
	private int balance;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
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
