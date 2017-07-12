package com.tddair;

public enum StatusEnum {
	Red, Green, Blue, Gold;

	public static StatusEnum calculateStatus(int ytdMiles) {
		StatusEnum status = StatusEnum.Red;
		if(ytdMiles >= 75000){
			status =  StatusEnum.Gold;
		}else if (ytdMiles >= 50000){
			status =  StatusEnum.Blue;
		}else if(ytdMiles >=25000){
			status = StatusEnum.Green;
		}
		
		return status;
	}

}
