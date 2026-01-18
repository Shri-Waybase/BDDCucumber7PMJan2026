@Login
Feature: To validate the login functionality of ScriptingLogic Platform

  Scenario: As a user I want to Login to scriptingLogic platform with valid credentials
    Given The user is on the Login page
#   When  The user enters valid username and password
    When  The user enters valid "admin" as username and "admin" as password
    And   The user clicks on the login button
    Then  The user can see the dashboard


  Scenario: As a user I want to Login to scriptingLogic platform with invalid credentials
    Given The user is on the Login page
#   When  The user enters invalid username and password
    When  The user enters invalid "invUse1" as  username and "invPass1" as password
    And   The user clicks on the login button
    Then  The user can see error message

  Scenario: As a user I want to Login to scriptingLogic platform with blank credentials
    Given The user is on the Login page
#   When  The user enters blank username and password
    When  The user enters blank "" as username and "" as password
    And   The user clicks on the login button
    Then  The user can see two error messages


  @DataTable
  Scenario: Login with datatable credentials
    Given I am on the Login page
    When  I enter user credentials
          |Username |Password|
          |admin    |admin   |
    And   I click on the login button
    Then  I can see dashboard