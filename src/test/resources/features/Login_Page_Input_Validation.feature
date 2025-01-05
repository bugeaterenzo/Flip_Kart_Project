@Login_Page_Validation
Feature: Login Page Validation

  Scenario Outline: User sees an error message when entering invalid email or phone number
    When the user enters an invalid input value as "<invalid_email_or_phone>"
    And the user clicks the Request OTP button
    Then the error message "Please enter valid Email ID/Mobile number" should be displayed

    Examples:
      | invalid_email_or_phone      |
      | invalid_email@test          |
      | +19876543210                |
      | 123456789                   |
      | (123) 456-7890              |
