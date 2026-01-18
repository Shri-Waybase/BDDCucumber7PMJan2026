
@AddCustomer @Regression
Feature: Add Customer feature

  Background: Launch the browser and maximize it (precondition)
    Given    The user open the browser
    And      The user maximize the browser

  Scenario: To validate the add customer functionality
    Given The user is on the Login page
    When  The user enters valid "admin" and "admin"
    And   The user clicks on the login button
    And   The user can see the dashboard
    And   The user click on the Add Customer link
    And   The user enters Name,Address,ContactOne,ContactTwo
    And   The user click on add button
    Then  The user is added successfully

@DuplicateCustomer
  Scenario: To validate the add duplicate customer functionality
    Given The user is on the Login page
    When  The user enters valid username and password
    And   The user clicks on the login button
    And   The user can see the dashboard
    And   The user click on the Add Customer link
    And   The user enters Name,Address,ContactOne,ContactTwo
    And   The user click on add button
    Then  The user can see duplicate customer entry
