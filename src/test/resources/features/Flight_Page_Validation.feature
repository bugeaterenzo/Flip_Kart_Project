@Flight_Page_Validation
Feature: Flight Page Validation

  Scenario: User sees a form when entering the page
    When the user navigates to the Flight page
    Then the form should be visible and url link must contain "flights"

