package com.tddair;

public class TddAirApplication {

  private FlightDao flights = new FakeFlightDao(); // TODO: use Spring
  private MemberDao members = new MemberDao();

  public TddAirApplication() {
  }

  /**
   * Adds a flight to the system.
   * 
   * @param origin
   *          the three letter airline code for origin airport
   * @param destination
   *          the three letter airline code for destination airport
   * @param mileage
   *          the miles between origin and destination
   * @param airline
   *          the two letter airline code
   * @param number
   *          the numbered flight number
   */
  public void addFlight(String origin, String destination, int mileage, String airline, int number) {
    flights.addFlight(origin, destination, mileage, airline, number);
  }

  public Flight getFlightByFlightNumber(String flightNumber) {
    return flights.getFlightBy(flightNumber);
  }

  public void registerMember(String username, String email) {
    validateEmail(email);
    members.register(username, new Member(username, email));

  }

  private void validateEmail(String email) {
    if (!email.contains("@")) {
      throw new IllegalArgumentException();
    }
    if (!email.contains(".com")) {
      throw new IllegalArgumentException();
    }
  }

  public Member lookupMember(String username) {
    return members.lookup(username);
  }

  public void completeFlight(String username, String flightNumber) {
    Member member = members.lookup(username);
    Flight flight = flights.getFlightBy(flightNumber);
    member.completeFlight(flight);
    
  }
}
