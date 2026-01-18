
@forgotPassword@Regression
Feature: To validate the forgot password functionality

  Background: Launch the browser and maximize it (precondition)
    Given    launch the browser
    And      maximize the browser

  Scenario: As a user I want to reset the password by clicking on forgot password link
    Given The user is on the Login page
    When  The user clicks on the forgot password link
    And   The user enter the movie name
    And   The user click on the submit button
    Then  The use can see the message
