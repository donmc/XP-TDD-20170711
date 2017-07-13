package test.com.tddair;

import com.tddair.DuplicateMemberException;
import com.tddair.FakeFlightDao;
import com.tddair.FakeMemberDao;
import com.tddair.FlightDao;
import com.tddair.InvalidCreditCardException;
import com.tddair.InvalidEmailException;
import com.tddair.Member;
import com.tddair.MemberDao;
import com.tddair.MemberFlightUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by agrawm2 on 7/13/2017.
 */
public class WhenPurchasingSeatUpgradeWithCreditCard {

    MemberDao memberDao = new FakeMemberDao();
    FlightDao flightDao = new FakeFlightDao();
    MemberFlightUtil memberFlightUtil = new MemberFlightUtil(memberDao, flightDao);
    MemberMother memMother = new MemberMother(memberFlightUtil);

    @Test
    public void shouldPurchaseSeatWithValidCreditCard() throws DuplicateMemberException, InvalidEmailException{
        Member redMember = memMother.createRedMember();
        redMember.purchaseSeatUpgradeWithCreditCard(111111111, 1);
        assertEquals(1,redMember.getSeatUpgradeBalance());
    }

    @Test (expected = InvalidCreditCardException.class)
    public void shouldRejectPurchaseSeatWithInvalidCreditCard() throws DuplicateMemberException, InvalidEmailException{
        Member redMember = memMother.createRedMember();
        redMember.purchaseSeatUpgradeWithCreditCard(999999999, 1);

    }
}
