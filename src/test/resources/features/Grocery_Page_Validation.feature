@Grocery_Page_Validation
Feature: Grocery Page Validation

  Scenario: User sees a prompt message when entering the page
    When the user navigates to the grocery page
    Then the prompt message "Verify Delivery Pincode" should be displayed

