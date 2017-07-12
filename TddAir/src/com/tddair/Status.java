package com.tddair;

public enum Status {
	Red, Green, Blue, Gold;
	
	
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
	
}
