package com.tddair;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class WhenRegisteringMembers {

	@Test
	public void shouldLookupMemeberSuccessfully() {
		//setup
		String username = "domnc";
		String email = "dom@improving.com";
		TddAirApplication app = new TddAirApplication();
		app.registerMember(username, email);
		
		
		
		//execute
		Member mem  = app.lookupMemeber(username, email);
		
		//validate
		assertNotNull(mem);
	}

}
