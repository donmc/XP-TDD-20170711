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

	public void registerMember(String username, String email) {
		// TODO Auto-generated method stub
		Member member = new Member();
		members.put(username,member);
		
	}

	public Member lookupMember(String username) {
		// TODO Auto-generated method stub
		return members.get(username);
	}
}
