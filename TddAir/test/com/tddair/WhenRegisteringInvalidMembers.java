package com.tddair;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenRegisteringInvalidMembers {

  @Test(expected=DuplicateUserNameException.class)
  public void shouldErrorWithDuplicateUsername() {
    TddAirApplication app = new TddAirApplication();
    app.registerMember("donmc", "don@improcing.com");
    app.registerMember("donmc", "don@improcing.com");
  }
  
  
  
  @Test(expected=IllegalArgumentException.class)
  public void shouldErrorWithInvalidEmail () {
    TddAirApplication app = new TddAirApplication();
    app.registerMember("donmc", "donimprocing.com");
    
  }  
  
  @Test(expected=IllegalArgumentException.class)
  public void shouldErrorWithInvalidEmail_noDotCom () {
    TddAirApplication app = new TddAirApplication();
    app.registerMember("donmc", "j@j");
    
  }

}
