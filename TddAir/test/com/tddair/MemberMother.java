package com.tddair;

public class MemberMother {
	Member redGuy;
	Member greenGuy;
	TddAirApplication app;
	
	public MemberMother() {
		setUpRedGuy();
		setUpGreenGuy();
	}
	
	public Member setUpRedGuy() {
		app = new TddAirApplication();		
		
		
		app.registerMember("donmc", "donmc@improving.com");
		redGuy = app.lookupMember("donmc");
		redGuy.setSeatupgradeQuantity(1);
		app.seatUpgrade(redGuy);
		
		return redGuy;
	}
	
	public Member setUpGreenGuy() {
		app = new TddAirApplication();		
		
		
		app.registerMember("green", "greenmember@improving.com");
		greenGuy = app.lookupMember("green");
		greenGuy.setSeatupgradeQuantity(2);
		greenGuy.setBalance(20000);
		greenGuy.setStatus(Status.Green);
		
		app.seatUpgrade(greenGuy);
		
		return greenGuy;
	}	
}
