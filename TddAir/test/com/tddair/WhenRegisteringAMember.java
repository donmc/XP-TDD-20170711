package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WhenRegisteringAMember {

	TddAirApplication app = new TddAirApplication();
	Member member;
	
	@Before
	public void setup() throws Exception {
		String userName = "bob";
		app.registerMember(userName, "bob@example.com");
		member = app.lookupMember(userName);
	}
	
	@Test
	public void shouldLookupSuccessfully() {
		assertNotNull(member);
	}

	@Test
	public void newMemberShouldBeInRedStatus() {
		assertEquals("Red", member.getStatus());
	}

	@Test
	public void newMemberShouldHaveZeroYTDMiles() {
		assertEquals(0, member.getYtdMiles());
	}
	
	@Test
	public void newMemberShouldHave10KBalance() {
		assertEquals(10000, member.getBalance());
	}
	
	@Test
	public void registrationWithSameUsernameThrowsException() {
		try {
			app.registerMember("bob", "bob@example.com");
			fail();
		} catch(Exception ex) {
			assertEquals("Duplicate user name", ex.getMessage());
		}
	}
	
	@Test 
	public void registrationWithInvalidEmailThrowsException() {
		try {
			app.registerMember("Bob", "bob_example.com");
			fail();
		} catch(Exception ex) {
			assertEquals("Invalid email", ex.getMessage());
		}
	} 
}
