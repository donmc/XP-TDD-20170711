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
	public void shouldRegisterSuccessfullyMilesCheck() {
		Member member = setup(); 
	    
	    //validate
        assertEquals(0, member.getMiles());
	}

	@Test
	public void shouldRegisterSuccessfullyBalanceCheck() {
		Member member = setup(); 
	    //System.out.println(");
	    //validate
        assertEquals(10000, member.getBalance());
	}

	@Test
	public void shouldRegisterError() {
		try {
			Member member = setup1(); 
			fail("Should throw exception");
		}catch(Exception e) {
			//validate

		}
	    
	}

	public Member setup() {
		//set up
		TddAirApplication app = new TddAirApplication();
		
		String userName = "john";
	    String email = "john@aa.com";
	    app.registerMember(userName,email,null);
	    
	    //execute
	    Member member = app.lookupMember(userName);
		return member;
	}
	
	public Member setup1() {
		//set up
		TddAirApplication app = new TddAirApplication();
		
		String userName = "john";
	    String email = "john@aa.com";
	    String oldUserName = "john";
	    app.registerMember(userName,email,oldUserName);
	    
	    //execute
	    Member member = app.lookupMember(userName);
		return member;
	}
}
