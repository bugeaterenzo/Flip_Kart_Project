@SignupPage
Feature: Sign-Up Page Validation
  As a user, I want to validate that the Sign-Up Page is displayed correctly after clicking the sign-up button.

  Scenario: Validate the Sign-Up Page is Displayed
    Given the user is in flipkart homepage and clicks on the sign-up button
    Then the sign-up page should be displayed
    And the URL must be "https://www.flipkart.com/account/login?signup=true&ret=/"
