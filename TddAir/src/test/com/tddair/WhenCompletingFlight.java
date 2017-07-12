package test.com.tddair;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.tddair.DuplicateMemberException;
import com.tddair.InvalidEmailException;
import com.tddair.Member;
import com.tddair.StatusEnum;
import com.tddair.TddAirApplication;

public class WhenCompletingFlight {
	
	TddAirApplication app = new TddAirApplication();
	
	@Before
	public void setUp(){
		try {
			app.registerMember("manish", "manish@gmail.com");
		} catch (DuplicateMemberException | InvalidEmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		app.addFlight("DFW", "MAA", 2500, "AA", 242);
		app.addFlight("MAA", "DFW", 10000, "AA", 356);
		app.addFlight("BOS", "CCU", 15000, "QR", 2345);
		app.addFlight("CHI", "DEL", 20000, "MF", 3456);
	}
	
	
	@Test
	public void shouldUpdateYTDMilesStatusAndBalanceForFirstFlight(){
		String username = "manish";
		String flightNumber = "AA242";
		Member member = app.memberCompleteFlight(username, flightNumber);
		assertEquals(2500, member.getYtdMiles());
		assertEquals(StatusEnum.Red, member.getStatus());
		assertEquals(12500, member.getBalance());
		
	}
	
	
	@Test
	public void shouldUpdateStatusFromRedToGreenForGT25000AndLT50000Miles(){
		String username = "manish";
		String flightNumber = "MF3456";
		Member member = app.memberCompleteFlight(username, flightNumber);
		flightNumber = "QR2345";
		member = app.memberCompleteFlight(username, flightNumber);
		assertEquals(35000, member.getYtdMiles());
		assertEquals(StatusEnum.Green, member.getStatus());
		assertEquals(45000, member.getBalance());
		
	}

	
	@Test
	public void shouldUpdateStatusFromGreenToBlueForGT50000AndLT75000Miles(){
		String username = "manish";
		String flightNumber = "MF3456";
		Member member = app.memberCompleteFlight(username, flightNumber);
		flightNumber = "QR2345";
		member = app.memberCompleteFlight(username, flightNumber);
		flightNumber = "QR2345";
		member = app.memberCompleteFlight(username, flightNumber);
		flightNumber = "MF3456";
		member = app.memberCompleteFlight(username, flightNumber);
		assertEquals(70000, member.getYtdMiles());
		assertEquals(StatusEnum.Blue, member.getStatus());
		assertEquals(80000, member.getBalance());
		
	}
	
	
	
	@Test
	public void shouldUpdateStatusFromBlueToGoldForGT75000Miles(){
		String username = "manish";
		String flightNumber = "MF3456";
		Member member = app.memberCompleteFlight(username, flightNumber);
		flightNumber = "QR2345";
		member = app.memberCompleteFlight(username, flightNumber);
		flightNumber = "QR2345";
		member = app.memberCompleteFlight(username, flightNumber);
		flightNumber = "MF3456";
		member = app.memberCompleteFlight(username, flightNumber);
		flightNumber = "AA356";
		member = app.memberCompleteFlight(username, flightNumber);
		assertEquals(80000, member.getYtdMiles());
		assertEquals(StatusEnum.Gold, member.getStatus());
		assertEquals(90000, member.getBalance());
		
	}
	
}
