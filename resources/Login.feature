@Login@Regression
Feature: To validate the login functionality of ScriptingLogic Platform

  Background: Launch the browser and maximize it (precondition)
  Given   User launch the browser
  And     User maximize the browser

  @validLogin
  Scenario: As a user I want to Login to scriptingLogic platform with valid credentials
    Given The user is on the Login page
#   When  The user enters valid username and password
    When  The user enters valid "admin" as username and "admin" as password
    And   The user clicks on the login button
    Then  The user can see the dashboard

@InvalidLogin
  Scenario: As a user I want to Login to scriptingLogic platform with invalid credentials
    Given The user is on the Login page
#   When  The user enters invalid username and password
    When  The user enters invalid "invUse1" as  username and "invPass1" as password
    And   The user clicks on the login button
    Then  The user can see error message

 @blankLogin
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



    @UsingExampleKey
  Scenario Outline: To check the Login for total 5 users
    Given The user is on the Login page
    When  The user enters  "<username>" and "<password>"
    And   The user clicks on the login button
    Then  The user can see the dashboard

    Examples:
      | username | password |
      | admin    | admin    |
      | admin1   | admin1   |
      | manager  | manager  |
      | user01   | user01   |
      | testuser | test123  |
