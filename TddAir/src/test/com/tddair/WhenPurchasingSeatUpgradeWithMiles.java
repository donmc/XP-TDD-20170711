package test.com.tddair;

import com.tddair.DuplicateMemberException;
import com.tddair.FakeFlightDao;
import com.tddair.FakeMemberDao;
import com.tddair.FlightDao;
import com.tddair.InSufficientMilesException;
import com.tddair.InvalidEmailException;
import com.tddair.Member;
import com.tddair.MemberDao;
import com.tddair.MemberFlightUtil;

import com.tddair.TddAirApplication;








import org.junit.Test;

import static org.junit.Assert.assertEquals;



/**
 * Created by agrawm2 on 7/12/2017.
 */
public class WhenPurchasingSeatUpgradeWithMiles {

	MemberDao memberDao = new FakeMemberDao();
	FlightDao flightDao = new FakeFlightDao();
	MemberFlightUtil memberFlightUtil = new MemberFlightUtil(memberDao, flightDao);
    MemberMother memMother = new MemberMother(memberFlightUtil);
    TddAirApplication app = new TddAirApplication();

    @Test
    public void shouldIncreaseSeatUpgradeOnPurchase() {
    	try {
			Member redMember = memMother.createRedMember();
			int currentSeatUpgradeBal =  redMember.getSeatUpgradeBalance();
			redMember.purchaseAndUpdateBalanceForSeatUpgrade(1);
			assertEquals(++currentSeatUpgradeBal, redMember.getSeatUpgradeBalance());
			
		} catch (DuplicateMemberException | InvalidEmailException e) {			
			e.printStackTrace();
		}
    }
    
    @Test(expected=InSufficientMilesException.class)
    public void shouldThrowErrorForInSufficientBalance() throws DuplicateMemberException, InvalidEmailException {
    	try{
			Member redMember = memMother.createRedMember();
			
			redMember.purchaseAndUpdateBalanceForSeatUpgrade(2);
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
			
			
		
    }
    
 
   


}
