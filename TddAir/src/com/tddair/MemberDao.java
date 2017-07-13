package com.tddair;

public interface MemberDao {

  void registerMember(String userName, String email) throws RegisterMemberException;

  /**
   * Ability to lookup member information by userName
   *  
   * @param userName
   * @return
   */
  Member lookupMember(String userName);

  /**
   * 
   * @param userName
   * @param mileage
   */
  void completedFlight(String userName, int mileage);

}