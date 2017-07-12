package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenRegisteringMember {
	
	private String username = null;
    private String email = null;
    private TddAirApplication app = null;
    private Member member = null;
    
	@Before
	public void setup (){		
		username = "donmc";
		email = "don@improving.com";		
		app = new TddAirApplication();
		
		app.registerMember(username, email);		
		member = app.lookupMember(username);
	}
	
	@Test
	public void shouldLookupMemberSuccessfully() {		
		assertNotNull(member);
	}
	
	@Test
	public void shouldLookupMemberRegisterd() {		
		assertTrue(member.isRegistered());
	}
	
	@Test
	public void shouldLookupMemberEmail() {
		assertEquals("don@improving.com", member.getEmail());
	}
	
	@Test
	public void shouldLookupMemberStatus() {
		assertEquals(Status.Red, member.getStatus());
	}
	
	@Test
	public void shouldLookupMemberBalance() {
		assertEquals(10000, member.getBalance());
	}
	
	@Test
	public void shouldcreateAnotherUser(){
		username = "bob";
		email = "bob@aa.com";
		
		app.registerMember(username, email);
		
		member = app.lookupMember(username);
		
		assertNotNull(member);
		assertEquals("bob", member.getUsername());		
	}
	
	@Test
	public void shouldNotAllowDuplicateUserNameMesage() {
		
		try {
			app.registerMember(username, email);
			fail("Should not execute this line!");
		} catch(RuntimeException e) {
			assertEquals("Duplicate User Name:"+username, e.getMessage());
		}
	}
	
	@Test
	public void shouldErrorBadEmailMessage() {
		username = "johnc";
		email = "john.com";		
		
		try {
			app.registerMember(username, email);	
			fail("Should not execute this line!");
		} catch(RuntimeException e) {
			assertEquals("Invalid Email Id:john.com", e.getMessage());
		}
		
	}
}
