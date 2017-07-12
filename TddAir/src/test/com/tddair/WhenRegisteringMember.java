package test.com.tddair;

import com.tddair.DuplicateMemberException;
import com.tddair.InvalidEmailException;
import com.tddair.Member;
import com.tddair.StatusEnum;
import com.tddair.TddAirApplication;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


/**
 * Created by agrawm2 on 7/12/2017.
 */
public class WhenRegisteringMember {

    Member member;
    TddAirApplication app = new TddAirApplication();

    @Test
    public void shouldLookupMemberSuccessfully() {
        //setup
        String username = "manikume24";
        String email = "manish.jaipatna@gmail.com";

        try {
            app.registerMember(username, email);
        } catch (DuplicateMemberException e) {
            e.printStackTrace();
        } catch (InvalidEmailException e) {
            e.printStackTrace();
        }
        //execute
        member = app.lookupMember(username);
        //validate
        assertNotNull(member);
        assertEquals(StatusEnum.Red, member.getStatus());
        assertEquals(0,member.getYtdMiles());
        assertEquals(10000,member.getBalance());

    }


    @Test
    public void shouldRegisterdAndLookupAnotherMemberSuccessfully() {
        //setup
        String username = "bob";
        String email = "bob@aa.com";
        //TddAirApplication app = new TddAirApplication();
        try {
            app.registerMember(username, email);
        } catch (DuplicateMemberException e) {
            e.printStackTrace();
        } catch (InvalidEmailException e) {
            e.printStackTrace();
        }
        //execute
        member = app.lookupMember(username);
        //validate
        assertNotNull(member);
        assertEquals(StatusEnum.Red, member.getStatus());
        assertEquals(0,member.getYtdMiles());
        assertEquals(10000,member.getBalance());

    }

    @Test
    public void shouldRejectDuplicateMemberRegistration() {
        String username = "john";
        String email = "john@email.com";
        //TddAirApplication app = new TddAirApplication();
        try {
            app.registerMember(username, email);
            fail("Duplicate Member");
        } catch (DuplicateMemberException e) {
            assertEquals("Duplicate Member", e.getMessage());
        } catch (InvalidEmailException e) {
            assertEquals("Email Id Invalid", e.getMessage());
        }

    }

    @Test
    public void shouldRejectInvalidEmailId() {
        String username = "neha";
        String email = "neha.com";
        //TddAirApplication app = new TddAirApplication();
        try {
            app.registerMember(username, email);
            //fail("Duplicate Member");
        } catch (DuplicateMemberException e) {
            assertEquals("Duplicate Member", e.getMessage());
        } catch (InvalidEmailException e) {
            assertEquals("Email Id Invalid", e.getMessage());
        }

    }


}
