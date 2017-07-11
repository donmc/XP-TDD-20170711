package com.tddair;

import static org.junit.Assert.*;

import org.junit.Test;

public class FlightTest {

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
