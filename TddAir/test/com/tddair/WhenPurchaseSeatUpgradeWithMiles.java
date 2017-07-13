package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenPurchaseSeatUpgradeWithMiles {
	private Member member;

	@Before
	public void setUp() throws Exception {
		String userName="donmc";
		String emailId = "donmc@hotmail.com";
		member = new Member(userName,emailId);
		Flight flight = new Flight("DFW", "ORD", 924, "AA", 10);
		member.addFlight(flight);
	}

	
	@Test
	public void shouldIncreaseEligibleSeatUpgradeBalance() {
		member.upgradeSeats(10000, 1);
		assertEquals(1, member.getEligibleSeatUpgradeBalance());
	}
	
	@Test
	public void shouldDecreaseSeatUpgradeEndBalance() {
		member.upgradeSeats(10000, 1);
		assertEquals(924, member.getBalance());
	}

}
