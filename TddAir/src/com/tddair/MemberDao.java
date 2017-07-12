package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {
  public Map<String, Member> members = new HashMap<>();

  public MemberDao() {
  }

  protected void register(String username, Member member) {
    if (members.containsKey(username)) {
      throw new DuplicateUserNameException();
    }
    members.put(username, member);
  }

  public Member lookup(String username) {
    return members.get(username);
  }
}