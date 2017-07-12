package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {

	private Map<String, Member> members = new HashMap<>();

	protected MemberDao() {
		registerMember("john", "john@email.com");
	}

	/**
	 * 
	 * @param username
	 * @param email
	 * @return
	 */
	protected boolean registerMember(String username, String email) {
		try {
			Member member = new Member(username, email);
			members.put(member.getUsername(), member);
			member.setStatus("RED");
			member.setRegistered(true);
			member.setYtdMiles(0);
			member.setBalance(0);
			return true;
		} catch (Exception ex) {
			return false;
		}

	}

	public Member getMember(String username) {
		return members.get(username);
	}
}
