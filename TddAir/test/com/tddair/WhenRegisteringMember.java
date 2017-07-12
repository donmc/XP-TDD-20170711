package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class WhenRegisteringMember {
  
  private Member member;
  private TddAirApplication app;

  @Before
  public void setup() {
    // setup
    String username = "donmc";
    String email = "don@improving.com";
    app = new TddAirApplication();
    app.registerMember(username, email);
    
    member = app.lookupMember(username);
  }

  @Test
  public void shouldLookupMemberSuccessfully() {
    assertNotNull(member);
  }
  
  @Test
  public void shouldHaveCorrectUsername() {
    assertEquals("donmc", member.getUsername());
  }

  @Test
  public void shouldHaveCorrectEmail() {
    assertEquals("don@improving.com", member.getEmail());
  }
  
  @Test
  public void shouldHaveRedStatus() {
    assertEquals(Status.Red, member.getStatus());
  }

  @Test
  public void shouldHave0YtdMiles() {
    assertEquals(0, member.getYtdMiles());
  }

  @Test
  public void shouldHave10000BalanceMiles() {
    assertEquals(10000, member.getBalanceMiles());
  }
  
  @Test
  public void shouldRegisterMultipleMembers() {
    app.registerMember("bob", "bob@aa.com");
    Member newMember = app.lookupMember("bob");
    Member oldMember = app.lookupMember("donmc");
    assertEquals("bob", newMember.getUsername());
    assertEquals("donmc", oldMember.getUsername());
  }
  
  
  
}
