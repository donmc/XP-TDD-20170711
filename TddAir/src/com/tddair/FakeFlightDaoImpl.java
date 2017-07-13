package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class FakeFlightDaoImpl implements FlightDao {

  private Map<String, Flight> flights = new HashMap<>();

  protected FakeFlightDaoImpl() {
    addFlight("DFW", "ORD", 924, "AA", 242);
    addFlight("LGA", "CDG", 3620, "AF", 38);
    addFlight("LAX", "SYD", 7490, "QF", 191);
    addFlight("LAX", "HYD", 10000, "QF", 271);
  }

  /* (non-Javadoc)
   * @see com.tddair.FlightDao#getFlightBy(java.lang.String)
   */
  @Override
  public Flight getFlightBy(String flightNumber) {
    return flights.get(flightNumber);
  }

  /* (non-Javadoc)
   * @see com.tddair.FlightDao#addFlight(java.lang.String, java.lang.String, int, java.lang.String, int)
   */
  @Override
  public void addFlight(String origin, String destination, int mileage, String airline, int number) {
    Flight flight = new Flight(origin, destination, mileage, airline, number);
    flights.put(flight.getFullFlightNumber(), flight);
  }
  
  /* (non-Javadoc)
   * @see com.tddair.FlightDao#calculateMiles(java.lang.String)
   */
  @Override
  public int calculateMiles(String flightNumber) {
    Flight flight = getFlightBy(flightNumber);
    return flight.getMileage();
  }
}
