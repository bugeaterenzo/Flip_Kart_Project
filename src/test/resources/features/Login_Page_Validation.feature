@LoginPage
Feature: Login Page Validation


  Scenario: Validate the Login Page is Displayed
    When the user clicks on the login button
    Then the login page should be displayed
    And the URL should be "https://www.flipkart.com/account/login?ret=/"



