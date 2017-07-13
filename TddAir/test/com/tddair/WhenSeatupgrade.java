package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenSeatupgrade {
	
	private Member donMember;
	private Member greenMember;
	
	private TddAirApplication app;
	@Before
	public void setUp() throws Exception {
		app = new TddAirApplication();		
		
		app.registerMember("donmc", "donmc@improving.com");
		donMember = app.lookupMember("donmc");
		donMember.setSeatupgradeQuantity(1);
		
		app.registerMember("green", "greenmember@improving.com");
		greenMember = app.lookupMember("green");
		greenMember.setSeatupgradeQuantity(2);
		greenMember.setBalance(20000);
		greenMember.setStatus(Status.Green);
		
		app.seatUpgrade(donMember);
		app.seatUpgrade(greenMember);
	}

	@Test
	public void shouldUpgradSeatSuccess() {
		assertEquals(true, donMember.isSeatUpgraded());
	}
	
	
	@Test
	public void shouldIncreaseSeatupgradeBalance() {
		assertEquals(1, donMember.getSeatupgradeQuantity());
	}
	
	@Test
	public void shouldDecreaseMilesBalance() {
		assertEquals(0, donMember.getBalance());
	}
	
	@Test
	public void shouldIncreaseSeatupgradeBalanceGreen() {
		assertEquals(2, greenMember.getSeatupgradeQuantity());
	}
	
	@Test
	public void shouldDecreaseMilesBalanceGreen() {
		assertEquals(0, greenMember.getBalance());
	}

}
