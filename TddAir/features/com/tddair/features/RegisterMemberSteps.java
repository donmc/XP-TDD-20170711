package com.tddair.features;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterMemberSteps {

  @When("^a member registers with username \"([^\"]*)\" and email \"([^\"]*)\"$")
  public void a_member_registers_with_username_and_email(String username, String email) throws Throwable {
   // app.register(username, email)
  }

  @Then("^member with id \"([^\"]*)\" should exist$")
  public void member_with_id_should_exist(String username) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^that member should have \"([^\"]*)\" status$")
  public void that_member_should_have_status(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^that member should have (\\d+) miles$")
  public void that_member_should_have_miles(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @When("^a customer registers with username \"([^\"]*)\" and email \"([^\"]*)\"$")
  public void a_customer_registers_with_username_and_email(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^an error message \"([^\"]*)\" is returned$")
  public void an_error_message_is_returned(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }
}
