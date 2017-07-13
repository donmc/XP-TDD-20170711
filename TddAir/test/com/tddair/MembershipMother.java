package com.tddair;

public class MembershipMother {

  public Member createMember(TddAirApplication app, MembershipStatus status, 
      int mileage) throws RegisterMemberException {

    // create new member
    String userName = status.getStatusLabel() + "_member";
    app.registerMember(userName, userName.concat("@example.com"));

    Member createdMember = app.lookupMember(userName);
    createdMember.setBalance(mileage);
    createdMember.setStatus(status);
    
    ((FakeMemberDaoImpl) app.getMembers()).updateMember(createdMember);

    return createdMember;
  }
}
