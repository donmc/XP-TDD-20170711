package com.tddair;

public enum StatusEnum {
	Gold(75000, 7000, 60), Blue(50000, 8000, 75),Green(25000, 9000, 90),Red(0, 10000, 100);
	
	private int threshold;
	private int milesPerUpgrade;
	private int costPerUpgrade;
	
	
	private StatusEnum(int threshold, int milesPerUpgrade, int costPerUpgrade ){
		this.threshold = threshold;
		this.milesPerUpgrade = milesPerUpgrade;
		this.costPerUpgrade = costPerUpgrade;
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

	public int getThreshold() {
		return threshold;
	}

	

	public int getMilesPerUpgrade() {
		return milesPerUpgrade;
	}

	
	public int getCostPerUpgrade() {
		return costPerUpgrade;
	}

	
	
	

}
