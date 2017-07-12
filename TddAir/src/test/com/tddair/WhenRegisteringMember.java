package test.com.tddair;

import com.tddair.Member;
import com.tddair.TddAirApplication;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;



/**
 * Created by agrawm2 on 7/12/2017.
 */
public class WhenRegisteringMember {
	
	 Member member ;
	 

    @Test
    public void shouldLookupMemberSuccessfully(){    
    	 //setup
    	String username = "manikume24";
        String email = "manish.jaipatna@gmail.com";
        TddAirApplication app = new TddAirApplication();
        app.registerMember(username,email);
        //execute
        member = app.lookupMember(username);
        //validate
        assertNotNull(member);      
        assertEquals("RED",member.getStatus() );  
        assertEquals("0",String.valueOf(member.getYtdMiles())); 
        assertEquals("0",String.valueOf(member.getBalance())); 
        
    }
    
    
    @Test
    public void shouldRegisterdAndLookupAnotherMemberSuccessfully(){    
    	 //setup
    	String username = "bob";
        String email = "bob@aa.com";
        TddAirApplication app = new TddAirApplication();
        app.registerMember(username,email);
        //execute
        member = app.lookupMember(username);
        //validate
        assertNotNull(member);      
        assertEquals("RED",member.getStatus() );  
        assertEquals("0",String.valueOf(member.getYtdMiles())); 
        assertEquals("0",String.valueOf(member.getBalance())); 
        
    }
    
    
    
   
}
