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

  public Flight getFlightByFlightNumber(String flightNumber) {
    return flights.getFlightBy(flightNumber);
  }
}
