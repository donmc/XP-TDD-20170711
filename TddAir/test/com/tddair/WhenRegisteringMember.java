package com.tddair;

import static org.junit.Assert.*;

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

}
