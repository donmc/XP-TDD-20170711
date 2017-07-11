package com.tddair;

import static org.junit.Assert.*;

import org.junit.Test;

public class FlightTest {

	@Test
	public void testGetFlightNuberSuccess() {
		//Setup
		Flight flight = new Flight("DFW", "ORD",980, "AA",234);
		
		//Execute
		 String flightNumber = flight.getFullFlightNumber();
		
		 //Verify
		//assertNull(flightNumber);
	    assertEquals(flightNumber, "AA234");
		
	}
	
	@Test
	public void testGetFlightNuberFail() {
		//Setup
		Flight flight = new Flight("DFW", "ORD",980, null,234);
		
		//Execute
		 String flightNumber = flight.getFullFlightNumber();
		
		 //Verify
		//assertNull(flightNumber);
	    assertEquals(flightNumber, "UNKNOWN");
		
	}

}
