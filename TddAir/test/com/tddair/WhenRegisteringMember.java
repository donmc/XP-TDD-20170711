package com.tddair;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenRegisteringMember {

	@Test
	public void shouldRegisterSuccessfullyTestNotNull() {
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
	
	@Test
	public void shouldRegisterSuccessfullyStatusCheck() {
		//set up
		TddAirApplication app = new TddAirApplication();
		
		String userName = "john";
	    String email = "john@aa.com";
	    app.registerMember(userName,email);
	    
	    //execute
	    Member member = app.lookupMember(userName); 
	    
	    	    //validate
        assertEquals("RED", member.getStatus());
		//fail("Not yet implemented");
	}
	
	

}
