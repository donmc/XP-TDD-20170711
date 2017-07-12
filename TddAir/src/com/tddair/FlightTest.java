package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class FlightTest {
	
	
	@Test
	public void testGetFullFlightNumberSuccess(){
		//SETUP
		Flight flight = new Flight("DFW", "MAA", 4500, "AA", 567) ;
		
		String flightNo = flight.getFullFlightNumber();
		
		assertEquals("AA567", flightNo);
			
	}
	
	
	@Test
	public void testGetFullFlightNumberNULLAirline(){
		//SETUP
		Flight flight = new Flight("DFW", "MAA", 4500, null, 567) ;
		
		String flightNo = flight.getFullFlightNumber();
		
		assertEquals("UNKNOWN", flightNo);
			
	}
		
	
	@Test
	public void testGetFullFlightNumberInvalidNumber(){
		//SETUP
		Flight flight = new Flight("DFW", "MAA", 4500, "AA", 0) ;
		
		String flightNo = flight.getFullFlightNumber();
		
		assertEquals("UNKNOWN", flightNo);
			
	}
	
	@Test
	public void testFlightConstructorSuccess(){
		Flight flight = new Flight("DFW", "MAA", 4500, "AA", 567) ;
		assertEquals("DFW", flight.getOrigin());
		assertEquals("MAA", flight.getDestination());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFlightConstructorOriginNull(){
		new Flight(null, "MAA", 4500, "AA", 567) ;
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFlightConstructorWithOriginInvalidLength(){
		new Flight("DFW123", "MAA", 4500, "AA", 567) ;
		
	}
	
	@Test
	public void testFlightConstructorWithOriginInvalidLengthTryCatch(){
		try{
		new Flight("DFW123", "MAA", 4500, "AA", 567) ;
		fail("Should have thrown a Illegal Argument Exception");
		}catch(IllegalArgumentException ex){
			assertEquals("Invalid origin code", ex.getMessage());
		}
	}
	

}
