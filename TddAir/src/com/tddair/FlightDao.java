package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class FlightDao {

  private Map<String, Flight> flights = new HashMap<>();

  protected FlightDao() {
    addFlight("DFW", "ORD", 924, "AA", 242);
    addFlight("LGA", "CDG", 3620, "AF", 38);
    addFlight("LAX", "SYD", 7490, "QF", 191);
    addFlight("LAX", "HYD", 10000, "QF", 271);
  }

  public Flight getFlightBy(String flightNumber) {
    return flights.get(flightNumber);
  }

  protected void addFlight(String origin, String destination, int mileage, String airline, int number) {
    Flight flight = new Flight(origin, destination, mileage, airline, number);
    flights.put(flight.getFullFlightNumber(), flight);
  }
  
  public int calculateMiles(String flightNumber) {
    Flight flight = getFlightBy(flightNumber);
    return flight.getMileage();
  }
}
