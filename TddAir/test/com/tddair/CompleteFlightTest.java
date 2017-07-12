package com.tddair;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CompleteFlightTest {
	private Member member;

	@Before
	public void setUp() throws Exception {
		String userName="donmc";
		String emailId = "donmc@hotmail.com";
		member = new Member(userName,emailId);
		Flight flight = new Flight("DFW", "ORD", 5000, "AA", 10);
		member.addFlight(flight);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldAccumulateMiles() {
      assertEquals(10924,member.getMiles());
	}

}
