package com.tddair;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import org.junit.Test;

public class FlightTest {

	@Test
	public void testFlightConstructor() {
		
		Flight flight = new Flight("DFW", "ORD", 5000, "AA", 10);
		assertEquals("DFW", flight.getOrigin());
		assertEquals("ORD", flight.getDestination());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testFlightConstructorFail() {
		
		Flight flight = new Flight(null, "ORD", 5000, "AA", 10);
	}
	
	@Test
	public void testFlightConstructorFail_InvalidOriginLength() {
		
		try{
			Flight flight = new Flight("DFWFTWTH", "ORD", 5000, "AA", 10);
			fail("Should throw IllegalArgumentException");
		}catch(IllegalArgumentException ex) {
			//assert instanceOf(IllegalArgumentException.class);
		}
		
	}
		
	@Test
	public void testFullFlightNumber() {
		
		Flight flight = new Flight("DFW", "ORD", 5000, "AA", 10);
		String actual = flight.getFullFlightNumber();
		String expected = "AA10";
		assertEquals(actual,expected);
	}
	
	@Test
	public void testFullFlightNumberNull() {
		
		Flight flight = new Flight("DFW", "ORD", 5000, null, 10);
		String actual = flight.getFullFlightNumber();
		String expected = "UNKNOWN";
		assertEquals(actual,expected);
	}
	
	@Test
	public void testFullFlightNumberInvalidFlight() {
		
		Flight flight = new Flight("DFW", "ORD", 5000, "AA", 0);
		String actual = flight.getFullFlightNumber();
		String expected = "UNKNOWN";
		assertEquals(actual,expected);
	}
	
	
	
	

}
