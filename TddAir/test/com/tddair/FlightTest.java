package com.tddair;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * 
 * @author Tanmoy
 *
 */
public class FlightTest {

	@Test
	public void testGetFullFlightNumber_Success() {
		//Setup
		Flight flight = new Flight("DFW","ORD",980,"AA",234);		
		//Execute
		String flightNum = flight.getFullFlightNumber();
		//Verify
		assertEquals("AA234", flightNum);
		//Teardown
	}
	
	
	@Test
	public void testGetFullFlightNumber_NoFlightNo() {
		//Setup
		Flight flight = new Flight("DFW","ORD",980,"AA",0);		
		//Execute
		String flightNum = flight.getFullFlightNumber();
		//Verify
		assertEquals("UNKNOWN", flightNum);
		//Teardown
	}
	
	@Test
	public void testGetFullFlightNumber_NullAirline() {
		//Setup
		Flight flight = new Flight("DFW","ORD",980,null,234);		
		//Execute
		String flightNum = flight.getFullFlightNumber();
		//Verify
		assertEquals("UNKNOWN", flightNum);
		//Teardown
	}

}
