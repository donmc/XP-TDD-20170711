package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenPurchasingSeatUpgradeWithCC {
	private Member member;

	@Before
	public void setUp() throws Exception {
		String userName="donmc";
		String emailId = "donmc@hotmail.com";
		member = new Member(userName,emailId);
		Flight flight = new Flight("DFW", "ORD", 15000, "AA", 10);
		member.addFlight(flight);
	}
	
	@Test
	public void shouldPurchaseWithValidCC() {
	    SpyCas spy = new SpyCas();
        member.setSpy(spy);
		member.upgradeSeats("1234123412341234", 1);
		assertEquals(1,member.getEligibleSeatUpgradeBalance());
		assertEquals(100,spy.getAmount());
	}

}
