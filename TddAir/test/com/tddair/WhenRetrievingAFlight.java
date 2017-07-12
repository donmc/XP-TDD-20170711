package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenRetrievingAFlight {

  private Flight returnedFlight;

  @Before
  public void setup() {
 
    TddAirApplication app = new TddAirApplication();
    app.addFlight("DFW", "BOS", 1500, "AA", 654);
    
    returnedFlight = app.getFlightByFlightNumber("AA654");
  }
  
  @Test
  public void shouldBeFoundByFlightNumber() {
    assertNotNull(returnedFlight);
    
  }
  
  @Test
  public void shouldHaveCorrectFlightNumber() {
    assertEquals("AA654", returnedFlight.getFullFlightNumber());
  }
  
  @Test
  public void shouldHaveCorrectDestination() {
    assertEquals("BOS", returnedFlight.getDestination());
  }

}
