Feature: Register Member
  As a frequent flyer
  I want to become a member
  so that I can start to accumulate miles

  Scenario: Success
    When a member registers with username "donmc" and email "don@improving.com"
    Then member with id "donmc" should exist
    And that member should have "RED" status
    And that member should have 0 miles

  Scenario Outline: Invalid Email
    When a customer registers with username <username> and email <email>
    Then an error message "Invalid Email. Please try again." is returned

    Examples: 
      | email              | username |
      | "bobimproving.com" | "cob"    |
      | "bob@improving"    | "don"    |
      | "@improving.com"   | "rod"    |
      | "don@hotmail.qqq"  | "rod"    |
