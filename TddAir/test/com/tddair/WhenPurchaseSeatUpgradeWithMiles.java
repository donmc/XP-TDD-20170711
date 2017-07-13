package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenPurchaseSeatUpgradeWithMiles {
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
	public void shouldIncreaseEligibleSeatUpgradeBalance() {
		member.upgradeSeats(10000, 1);
		assertEquals(1, member.getEligibleSeatUpgradeBalance());
	}
	
	@Test
	public void shouldDecreaseSeatUpgradeEndBalance() {
		member.upgradeSeats(10000, 1);
		assertEquals(15000, member.getBalance());
	}
	
	@Test
	public void shouldIncreaseMultipleQtyEligibleSeatUpgradeBalance() {
		member.upgradeSeats(20000, 2);
		assertEquals(2, member.getEligibleSeatUpgradeBalance());
	}
	
	@Test
	public void shouldDecreaseMultipleQtySeatUpgradeEndBalance() {
		member.upgradeSeats(20000, 2);
		assertEquals(5000, member.getBalance());
	}
	

}
