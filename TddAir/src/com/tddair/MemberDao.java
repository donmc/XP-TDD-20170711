package com.tddair;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {

    private Map<String, Member> members = new HashMap<>();

    protected MemberDao() {
        try {
            registerMember("john", "john@email.com");
        } catch (DuplicateMemberException e) {
            e.printStackTrace();
        } catch (InvalidEmailException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param username
     * @param email
     * @return
     */
    protected boolean registerMember(String username, String email) throws DuplicateMemberException, InvalidEmailException {

        if (getMember(username) == null) {

            if (validEmail(email)) {
                Member member = new Member(username, email);
                members.put(member.getUsername(), member);
                member.setStatus("RED");
                member.setRegistered(true);
                member.setYtdMiles(0);
                member.setBalance(0);
                return true;
            } else {
                throw new InvalidEmailException("Email Id Invalid");
            }
        } else {
            throw new DuplicateMemberException("Duplicate Member");
        }


    }

    private boolean validEmail(String email) {

        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;

    }

    public Member getMember(String username) {
        return members.get(username);
    }
}
