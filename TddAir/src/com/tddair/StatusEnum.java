package com.tddair;

public enum StatusEnum {
	Gold(75000), Blue(50000),Green(25000),Red(0);
	
	private int threshold;
	
	private StatusEnum(int threshold){
		this.threshold = threshold;
	}

	public static StatusEnum calculateStatus(int ytdMiles) {
		StatusEnum finalStatusEnum = StatusEnum.Red;
		for (StatusEnum status: StatusEnum.values()) {
			if(ytdMiles >= status.threshold){
				finalStatusEnum = status;
				return finalStatusEnum;
			}
		}
		return finalStatusEnum;
		
	}

}
