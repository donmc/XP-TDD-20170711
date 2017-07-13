package test.com.tddair;

import com.tddair.DuplicateMemberException;
import com.tddair.FlightDao;
import com.tddair.InvalidEmailException;
import com.tddair.Member;
import com.tddair.MemberDao;
import com.tddair.MemberFlightUtil;

/**
 * Created by agrawm2 on 7/13/2017.
 */
public class MemberMother {

    private MemberDao memberDao;
    private FlightDao flightDao;
    private MemberFlightUtil memberFlightUtil;

    public MemberMother(MemberFlightUtil memberFlightUtil){
        this.memberFlightUtil = memberFlightUtil;
        this.memberDao = memberFlightUtil.getMemberDao();
        this.flightDao =  memberFlightUtil.getFlightDao();
    }

    public Member createRedMember()  throws DuplicateMemberException, InvalidEmailException {
      flightDao.addFlight("DFW", "MAA", 24000, "AA", 242);
      memberDao.registerMember("manish","test@gmail.com");
      return memberFlightUtil.memberCompleteFlight("manish","AA242");

    }

    public Member createGreenMember() throws DuplicateMemberException, InvalidEmailException {
        flightDao.addFlight("DFW", "MAA", 45000, "AA", 243);
        memberDao.registerMember("manish","test@gmail.com");
        return memberFlightUtil.memberCompleteFlight("manish","AA243");

    }

    public Member createBlueMember() throws DuplicateMemberException, InvalidEmailException {
        flightDao.addFlight("DFW", "MAA", 70000, "AA", 244);
        memberDao.registerMember("manish","test@gmail.com");
        return memberFlightUtil.memberCompleteFlight("manish","AA244");

    }

    public Member createGoldMember() throws DuplicateMemberException, InvalidEmailException {
        flightDao.addFlight("DFW", "MAA", 80000, "AA", 245);
        memberDao.registerMember("manish","test@gmail.com");
        return memberFlightUtil.memberCompleteFlight("manish","AA245");

    }
}
