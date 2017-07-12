package com.tddair;

public class Member {

	private String username;
	private String email;

	private int ytdMiles;
	private String balance;
	private Status status;

	

	public Member(String username, String email, int ytdMiles, String balance) {
		super();
		this.username = username;
		this.email = email;
		this.ytdMiles = ytdMiles;
		this.status = Status.Red;
		this.balance = balance;

	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}
	public int getYtdMiles() {
		return ytdMiles;
	}

	public String getBalance() {
		return balance;
	}

	public Status getStatus() {
		return status;
	}

}
