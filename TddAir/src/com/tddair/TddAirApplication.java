package com.tddair;

public class TddAirApplication {

    private FlightDao flights = new FlightDao();
    private MemberDao members = new MemberDao();

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
		
		accumulateMiles(member, flight);
		updateBalanceWithFlightMiles(member, flight);
		
		updateStatusBasedonYtdMiles(member);
		return member;
		
	}

	private void updateStatusBasedonYtdMiles(Member member) {
		if(member.getYtdMiles() > 25000 && member.getYtdMiles() <= 50000){
			member.setStatus(StatusEnum.Green);
		}else if(member.getYtdMiles() > 50000 && member.getYtdMiles() <= 75000){
			member.setStatus(StatusEnum.Blue);
		}else if(member.getYtdMiles() > 75000 ){
			member.setStatus(StatusEnum.Gold);
		}
	}

	private void updateBalanceWithFlightMiles(Member member, Flight flight) {
		member.setBalance(flight.getMileage() + member.getBalance());
	}

	private void accumulateMiles(Member member, Flight flight) {
		member.setYtdMiles(member.getYtdMiles() + flight.getMileage());
	}


}
