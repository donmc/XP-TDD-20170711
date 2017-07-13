package com.tddair;

public interface MemberDao {

	/**
	 * @param username
	 * @param email
	 * @return
	 */
	public abstract boolean registerMember(String username, String email)
			throws DuplicateMemberException, InvalidEmailException;

	public abstract Member getMember(String username);

}