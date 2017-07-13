package com.tddair;

import java.util.HashMap;

public class FakeMemberDaoImpl implements MemberDao {

  private HashMap<String, Member> members = new HashMap<String, Member>();

  /*
   * (non-Javadoc)
   * 
   * @see com.tddair.MemberDao#registerMember(java.lang.String, java.lang.String)
   */
  @Override
  public void registerMember(String userName, String email) throws RegisterMemberException {
    if (lookupMember(userName) != null) {
      throw new RegisterMemberException("Duplicate user name");

    }
    if (email.indexOf('@') == -1) {
      throw new RegisterMemberException("Invalid email");
    }

    // new member
    Member member = new Member(userName, email);
    // add member to collection
    members.put(userName, member);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.tddair.MemberDao#lookupMember(java.lang.String)
   */
  @Override
  public Member lookupMember(String userName) {

    // TODO Auto-generated method stub
    return members.get(userName);
  }

  public void updateMember(Member member) {
    members.put(member.getUserName(), member);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.tddair.MemberDao#completedFlight(java.lang.String, int)
   */
  @Override
  public void completedFlight(String userName, int mileage) {

    Member member = lookupMember(userName);
    member.completeFlight(mileage);

    updateMember(member);

  }

}
