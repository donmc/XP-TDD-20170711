package com.tddair;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenRegisteringMember {

	@Test
	public void shouldRegisterSuccessfully() {
		try { // setup
			String email = "test@test.com";
			String username = "User";
			TddAirApplication app = new TddAirApplication();
			app.registerMember(username, email);

			// execute
			Member member = app.lookupMember(username);

			// validate
			assertNotNull(member);
		} catch (Exception ex) {
			// assertEquals(ex.getMessage(),
		}
	}

	@Test
	public void shouldHaveUniqueUserNameForUserRegistration() {
		try { // setup
			String email = "test@test.com";
			String username = "User";
			TddAirApplication app = new TddAirApplication();
			app.registerMember(username, email);

			// execute
			email = "test@test.com";
			username = "User";
			//app = new TddAirApplication();
			app.registerMember(username, email);
			fail("Should throw exception");

		} catch (Exception ex) {
			assertEquals(ex.getMessage(), "username is not unique");
		}

	}
	
	@Test
	public void shouldHaveValidEmailId() {
		try { // setup
			String email = null;
			String username = "User";
			TddAirApplication app = new TddAirApplication();
	
			// execute
		
     		//app = new TddAirApplication();
			app.registerMember(username, email);
			fail("Should throw exception");

		} catch (Exception ex) {
			assertEquals(ex.getMessage(), "Email is not valid");
		}

	}

}
