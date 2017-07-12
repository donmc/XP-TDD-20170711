package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class FlightTest {

  @Test
  public void testFlightCreation_Success() {
    Flight flight = new Flight("DFW", "ORD", 980, "AA", 234);
    assertEquals("DFW", flight.getOrigin());
    assertEquals(980, flight.getMileage());
  }
  
  @Test
  public void testFlightCreation_InvalidOriginLength() {
    
    try {
      new Flight("DFTW", "ORD", 980, "AA", 234);
      fail("Should throw IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid origin code", e.getMessage());
    }
    
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testFlightCreation_NullOrigin() {
    new Flight(null, "ORD", 980, "AA", 234);
  }
  
  @Test
  public void testGetFullFlightNumber_Success() {
    // Setup
    Flight flight = new Flight("DFW", "ORD", 980, "AA", 234); 
        
    // Execute
    String flightNo = flight.getFullFlightNumber();
    
    // Verify
    assertEquals("AA234", flightNo);
    
  }
  
  @Test
  public void testGetFullFlightNumber_NullAirline() {
    // Setup
    Flight flight = new Flight("DFW", "ORD", 980, null, 234); 
        
    // Execute
    String flightNo = flight.getFullFlightNumber();
    
    // Verify
    assertEquals("UNKNOWN", flightNo);
    
  }
  
  @Test
  public void testGetFullFlightNumber_NoFlightNo() {
    // Setup
    Flight flight = new Flight("DFW", "ORD", 980, "AA", 0); 
        
    // Execute
    String flightNo = flight.getFullFlightNumber();
    
    // Verify
    assertEquals("UNKNOWN", flightNo);
    
  }

}
