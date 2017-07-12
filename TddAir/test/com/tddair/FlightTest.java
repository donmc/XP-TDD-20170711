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
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidScenario(){
		//Setup
		
		Flight flight = new Flight("DFW1", "ORD",980, null,234);
				
		
	}
	
	@Test
	public void testInvalidOriginCode(){
		//Setup
	  try{	
		Flight flight = new Flight("DFW1", "ORD",980, null,234);
		fail("Should throw Exception");
	  }
	  catch(IllegalArgumentException ex){
		 assertEquals(ex.getMessage(),"Invalid origin code" );
	  }
	  
	}
	
	@Test
	public void testInvalidDestination(){
		//Setup
	  try{	
		Flight flight = new Flight("DFW", "ORD1",980, null,234);
		fail("Should throw Exception");
	  }
	  catch(IllegalArgumentException ex){
		 assertEquals(ex.getMessage(),"Invalid destination code" );
	  }
	  
	}
	
	@Test
	public void testInvalidMileage(){
		//Setup
	  try{	
		Flight flight = new Flight("DFW", "ORD",980, null,90);
		fail("Should throw Exception");
	  }
	  catch(IllegalArgumentException ex){
		 assertEquals(ex.getMessage(),"Mileage must be greater than 100" );
	  }
	  
	}

}
