Feature: Test Login Functionality
  Scenario: Check login is successful with valid credentials
    Given browser is open
    And user is on login page
    When user enters Username and Password
    And user clicks on login button
    Then user is navigated to home page
