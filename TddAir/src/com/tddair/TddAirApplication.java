package com.tddair;

public class TddAirApplication {

  private MemberDao members = new MemberDao();
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

public void registerMember(String username, String email) throws Exception {
	// TODO Auto-generated method stub
	Member member = members.getMember(username);
	if (member!=null)
		throw new Exception ("username is not unique");
	
	if(email==null){
		throw new Exception ("Email is not valid");
	}
	if(!email.contains("@")){
		throw new Exception ("Email is not valid");
	}
	
	members.addMember(username, email, "Red", 10000 );
    	
}

public Member lookupMember(String username) {
	// TODO Auto-generated method stub
	return members.getMember(username);
}

public void completeFlight(String username, String flightNumber) {
	// TODO Auto-generated method stub
	Flight flight= flights.getFlightBy(flightNumber);
	Member member = members.getMember(username);
	member.miles = member.miles+flight.getMileage();
	if(member.miles<=25000){
		member.status = "RED";
	}else
		if(member.miles<50000){
			member.status = "GREEN";
		}
		else if(member.miles<100000){
			member.status = "BLUE";
		}
		
		
	}
	
}

