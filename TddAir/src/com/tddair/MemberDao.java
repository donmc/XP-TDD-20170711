package com.tddair;

import java.util.HashMap;

public class MemberDao {

	private HashMap<String,Member> members = new HashMap<String,Member>();
	
	public void registerMember(String userName, String email) throws Exception {
		if(lookupMember(userName)!=null) {
			throw new Exception("Duplicate user name");
			
		}
		if(email.indexOf('@')==-1) {
			throw new Exception("Invalid email");
		}
		Member member = new Member(userName,email);
		member.setStatus("Red");
		member.setYtdMiles(0);
		member.setBalance(10000);
		members.put(userName, member);
	}

	public Member lookupMember(String userName) {
		
		// TODO Auto-generated method stub
		return members.get(userName);
	}
		
	
	
}
