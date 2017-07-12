package com.tddair;

public class TddAirApplication {

  private FlightDao flights = new FlightDao();

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

  public void registerMember(String userName, String email,String oldUserName) {
	if (oldUserName != null && userName.equals(oldUserName)) {
		throw new RuntimeException("User already exists");
	}
		
  }
	
  public Member lookupMember(String userName) {
	// TODO Auto-generated method stub
	Member member = new Member();
	member.setMiles(0);
	member.setBalance(10000);
	member.setStatus("RED");
	return member;
  }
}
