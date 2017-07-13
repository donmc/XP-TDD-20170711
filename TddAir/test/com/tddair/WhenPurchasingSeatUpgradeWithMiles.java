package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenPurchasingSeatUpgradeWithMiles {
	
	private MemberMother mom;

	@Before
	public void setUp() throws Exception {	
		mom = new MemberMother();
	}

	@Test
	public void shouldUpgradSeatSuccess() {
		assertEquals(true, mom.redGuy.isSeatUpgraded());
	}
	
	
	@Test
	public void shouldIncreaseSeatupgradeBalance() {
		assertEquals(1, mom.redGuy.getSeatupgradeQuantity());
	}
	
	@Test
	public void shouldDecreaseMilesBalance() {
		assertEquals(0, mom.redGuy.getBalance());
	}
	
	@Test
	public void shouldIncreaseSeatupgradeBalanceGreen() {
		assertEquals(2, mom.greenGuy.getSeatupgradeQuantity());
	}
	
	@Test
	public void shouldDecreaseMilesBalanceGreen() {
		assertEquals(0, mom.greenGuy.getBalance());
	}

}
