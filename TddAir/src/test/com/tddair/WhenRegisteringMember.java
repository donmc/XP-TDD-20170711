package test.com.tddair;

import com.tddair.Member;
import com.tddair.TddAirApplication;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Created by agrawm2 on 7/12/2017.
 */
public class WhenRegisteringMember {

    @Test
    public void shouldRegisterSuccessfully(){
        //setup
        String username = "manikume24";
        String email = "manish.jaipatna@gmail.com";
        TddAirApplication app = new TddAirApplication();
        app.regisetrMember(username,email);
        //execute
        Member member = app.lookupMember(username);
        //validate
        assertNotNull(member);

    }
}
