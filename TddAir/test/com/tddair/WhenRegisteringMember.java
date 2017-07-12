package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenRegisteringMember {
	
	private String username = "donmc";
    private String email = "don@improving.com";
    private TddAirApplication app = null;
    
	@Before
	public void setup (){		
		app = new TddAirApplication();
		app.registerMember(username, email);		
	}
	
	@Test
	public void shouldLookupMemberSuccessfully() {		
		// execute 
		Member member = app.lookupMember(username);
		
		// validate 
		
		assertNotNull(member);
	}

}
