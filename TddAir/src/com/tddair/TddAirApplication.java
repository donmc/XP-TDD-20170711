package com.tddair;

public class TddAirApplication {

    private FlightDao flights = new FakeFlightDao();
    private MemberDao members = new FakeMemberDao();

    public TddAirApplication() {
    }

    /**
     * Adds a flight to the system.
     *
     * @param origin      the three letter airline code for origin airport
     * @param destination the three letter airline code for destination airport
     * @param mileage     the miles between origin and destination
     * @param airline     the two letter airline code
     * @param number      the numbered flight number
     */
    public void addFlight(String origin, String destination,
                          int mileage, String airline, int number) {
        flights.addFlight(origin, destination, mileage, airline, number);
    }

    public void registerMember(String username, String email) throws DuplicateMemberException, InvalidEmailException {
        members.registerMember(username, email);
    }

    public Member lookupMember(String username) {
        return members.getMember(username);
    }

    /**
     * 
     * @param username
     * @param flightNumber
     * @return
     */
	public Member memberCompleteFlight(String username, String flightNumber) {
		Member member = members.getMember(username);
		Flight flight = flights.getFlightBy(flightNumber);
		
		member.accumulateMiles(member.getYtdMiles(), flight.getMileage());
		member.updateBalanceWithFlightMiles(member.getBalance(), flight.getMileage());
		
		member.updateStatusBasedonYtdMiles(member.getYtdMiles());
		return member;
		
	}

	

	

	


}
