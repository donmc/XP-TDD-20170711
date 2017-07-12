package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class TddAirApplication {

  private FlightDao flights = new FlightDao();
  private Map<String,Member> members = new HashMap<String,Member>();

  public TddAirApplication() {
  }

  /**
   * Adds a flight to the system.
   * 
   * @param origin the three letter airline code for origin airport
   * @param destination the three letter airline code for destination airport
   * @param mileage the miles between origin and destination
   * @param airline the two letter airline code
   * @param number the numbered flight number
   */
  public void addFlight(String origin, String destination, 
                        int mileage, String airline, int number) {
    flights.addFlight(origin, destination, mileage, airline, number);
  }

  
  public Flight getCompleteFlight(String flightNumber) {
	  return flights.getFlightBy(flightNumber);
  }
  
  /**
   * 
   * @param username
   * @param email
   */
	public void registerMember(String username, String email) {
		// TODO Auto-generated method stub
		Member member = new Member(username,email);
		
		populateMember(username, email, member);
		
		if(!members.containsKey(username)) {
			members.put(username,member);
		} else {
			throw new RuntimeException("Duplicate User Name:"+username);
		}
	}

	private void populateMember(String username, String email, Member member) {
		if(validateEmailId(email)) {
			member.setEmail(email);
		}
		member.setUsername(username);

	}

	private boolean validateEmailId(String email) {
		
		if(email!=null && email.contains("@")) {
			return true;
		} else {
			throw new  RuntimeException("Invalid Email Id:"+email);
		}
	}

	public Member lookupMember(String username) {
		// TODO Auto-generated method stub
		return members.get(username);
	}


	public void completingFlight(String userName, String flightNum) {
		
		Flight flight = flights.getFlightBy(flightNum);
		Member member = members.get(userName);
		
		member.completeFlight(flight);
	}
}
