package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenCompletingFlight {
	
	TddAirApplication tddAirApplication = new TddAirApplication();
	private Member donmcMember = null;
	private Member bobMember = null;
	
	@Before
	public void setUp() throws Exception {
		tddAirApplication = new TddAirApplication();		
		
		tddAirApplication.registerMember("donmc", "don@improving.com");		
		donmcMember = tddAirApplication.lookupMember("donmc");
		
		tddAirApplication.registerMember("bob", "bob@aa.com");		
		bobMember = tddAirApplication.lookupMember("bob");
		bobMember.setYtdMiles(24500);
		
	}

	@Test
	public void shouldAccumulateMiles() {	
		tddAirApplication.completingFlight(donmcMember.getUsername(),"AA242");

		assertEquals(924, donmcMember.getYtdMiles());
		assertEquals(10924, donmcMember.getBalance());
	}
	
	@Test
	public void shouldBeStatusRed() {
		tddAirApplication.completingFlight(donmcMember.getUsername(), "AA242");
		
		assertEquals(Status.Red, donmcMember.getStatus());
		
	}
	
	@Test
	public void shouldPromteToGreen() {
		tddAirApplication.completingFlight(bobMember.getUsername(), "AA242");
		
		assertEquals(Status.Green, bobMember.getStatus());
	}

}
