package com.tddair;

public class MemberFlightUtil {
    private final MemberDao memberDao;
    private final FlightDao flightDao;

    public MemberFlightUtil(MemberDao memberDao, FlightDao flightDao) {
        this.memberDao = memberDao;
        this.flightDao = flightDao;
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public FlightDao getFlightDao() {
        return flightDao;
    }

    /**
     * @param username
     * @param flightNumber
     * @return
     */
    public Member memberCompleteFlight(String username, String flightNumber) {
        Member member = memberDao.getMember(username);
        Flight flight = flightDao.getFlightBy(flightNumber);

        member.accumulateMiles(member.getYtdMiles(), flight.getMileage());
        member.updateBalanceWithFlightMiles(member.getBalance(), flight.getMileage());

        member.updateStatusBasedonYtdMiles(member.getYtdMiles());
        return member;

    }

    public boolean purchaseSeatUpgradeWithMiles(String username, int quantity){
        Member member = memberDao.getMember(username);
        return false;

    }
}