package com.tddair;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenRegisteringMember {

	@Test
	public void shouldRegisterSuccessfullyTestNotNull() {
		Member member = setup(); 
	    
	    //validate
        assertNotNull(member);

	}
	
	@Test
	public void shouldRegisterSuccessfullyStatusCheck() {
		Member member = setup(); 
	    
	    //validate
        assertEquals("RED", member.getStatus());
	}
	
	@Test
	public void shouldRegisterError() {
		Member member = setup(); 
	    
	    //validate
        assertEquals("User Already Exists", member.getStatus());
	}

	public Member setup() {
		//set up
		TddAirApplication app = new TddAirApplication();
		
		String userName = "john";
	    String email = "john@aa.com";
	    app.registerMember(userName,email);
	    
	    //execute
	    Member member = app.lookupMember(userName);
		return member;
	}
	

}
