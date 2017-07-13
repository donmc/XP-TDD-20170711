package com.tddair;

public enum Status {
	Gold(75000, 7000), Blue(50000, 8000), Green (25000, 9000), Red(0, 10000);
	
	private int threshold;
	private int milesCost;

	private Status(int threshold, int milesCost) {
		this.threshold = threshold;
		this.milesCost = milesCost;
	}
	public static Status calculateMiles(long ytdMiles) {
		Status status = Status.Red;
		
		if(ytdMiles >= 75000) {
			status = Status.Gold;
		} else if(ytdMiles >= 50000) {
			status = Status.Blue;
		} else 	if(ytdMiles >= 25000) {
			status = Status.Green;
		}
		

		return status;
	}

	public long getMilesCost(long balance) {
		// TODO Auto-generated method stub
		return balance - milesCost;
	}
	
}
