package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenPurchaseSeatUpgradeWithMilesFailed {
	private Member member;

	@Before
	public void setUp() throws Exception {
		String userName="donmc";
		String emailId = "donmc@hotmail.com";
		member = new Member(userName,emailId);
		Flight flight = new Flight("DFW", "ORD", 1000, "AA", 10);
		member.addFlight(flight);
	}
		
	@Ignore @Test
	public void shouldIncreaseMultipleQtyEligibleSeatUpgradeBalance() {
		member.upgradeSeats(1000, 2);
		assertEquals(0, member.getEligibleSeatUpgradeBalance());
	}
	
	@Ignore @Test
	public void shouldDecreaseMultipleQtySeatUpgradeEndBalance() {
		member.upgradeSeats(1000, 2);
		assertEquals(5000, member.getBalance());
	}
	

}
