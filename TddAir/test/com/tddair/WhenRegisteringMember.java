package com.tddair;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenRegisteringMember {

	@Test
	public void shouldRegisterSuccessfully() {
		//set up
		TddAirApplication app = new TddAirApplication();
		
		String userName = "john";
	    String email = "john@aa.com";
	    app.registerMember(userName,email);
	    
	    //execute
	    Member member = app.lookupMember(userName); 
	    
	    //validate
        assertNotNull(member);
		//fail("Not yet implemented");
	}

}
