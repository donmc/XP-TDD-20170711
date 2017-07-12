package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import cucumber.api.java.Before;
import junit.framework.Assert;

public class WhenRegisteringMembers {

	private Member member;

	@Before
	public void setup() {
		// TODO Auto-generated method stub

		String username = "domnc";
		String email = "dom@improving.com";
		int ytdMiles =0 ;
		String balance = "10000";
		TddAirApplication app = new TddAirApplication();
		app.registerMember(username, email);

		// execute
		member = app.lookupMemeber(username, email, ytdMiles, balance);

	}

	@Test
	public void shouldLookupMemeberSuccessfully() {
		// setup
		setup();
		// validate
		assertNotNull(member);
	}
	
	@Test
	public void shouldLookupMemeberStatus() {
		// setup
		setup();
		// validate
		assertEquals(Status.Red, member.getStatus());
	}
	
	@Test
	public void shouldLookupMemeberUser() {
		// setup
		setup();
		// validate
		assertEquals("domnc", member.getUsername());
	}
	
	@Test
	public void shouldLookupMemeberEmail() {
		// setup
		setup();
		// validate
		assertEquals("dom@improving.com", member.getEmail());
	}
	
	@Test
	public void shouldLookupMemeberytdMiles() {
		// setup
		setup();
		// validate
		assertEquals(0, member.getYtdMiles());
	}
	
	@Test
	public void shouldLookupMemeberBalance() {
		// setup
		setup();
		// validate
		assertEquals("10000", member.getBalance());
	}
	
	@Test
	public void shouldRegisterMultipleMembers() {
		app.regist
	}
}
