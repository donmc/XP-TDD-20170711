package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenCompletingFlight {

  private TddAirApplication app;
  private Member donmcMember;
  private Member bobMember;
  private Member greenMember;
  private Member blueMember;
  
  @Before
  public void setup() {
    app = new TddAirApplication();
    app.registerMember("donmc", "don@gmail.com");
    donmcMember = app.lookupMember("donmc");

    app.registerMember("bob", "don@gmail.com");
    bobMember = app.lookupMember("bob");
    app.addFlight("XXX", "YYY", 24500, "TEST", 24500);
    app.completeFlight(bobMember.getUsername(), "TEST24500");

    app.registerMember("green", "don@gmail.com");
    greenMember = app.lookupMember("green");
    app.addFlight("XXX", "YYY", 45000, "TEST", 45000);
    app.completeFlight(greenMember.getUsername(), "TEST45000");

    app.registerMember("blue", "don@gmail.com");
    blueMember = app.lookupMember("blue");
    app.addFlight("XXX", "YYY", 74999, "TEST", 74999);
    app.completeFlight(blueMember.getUsername(), "TEST74999");
  }

  @Test
  public void shouldStayRed() {
    app.completeFlight(donmcMember.getUsername(), "AA242");
    
    assertEquals(Status.Red, donmcMember.getStatus());
  }
  
  @Test
  public void shouldAccumulateMiles() {
    app.completeFlight(donmcMember.getUsername(), "AA242");
    
    assertEquals(924, donmcMember.getYtdMiles());
    assertEquals(10924, donmcMember.getBalanceMiles());
  }
  
  @Test
  public void shouldPromoteToGreen() {
      app.completeFlight(bobMember.getUsername(), "AA242");
      assertEquals(Status.Green, bobMember.getStatus());
  }
  
   @Test
  public void shouldPromoteToBlue() {
    app.completeFlight(greenMember.getUsername(), "QF191");
    assertEquals(Status.Blue, greenMember.getStatus());
    
  }
  
   @Test
  public void shouldPromoteToGold() {
    app.completeFlight(blueMember.getUsername(), "AF38");
    assertEquals(Status.Gold, blueMember.getStatus());
    
  }
}
