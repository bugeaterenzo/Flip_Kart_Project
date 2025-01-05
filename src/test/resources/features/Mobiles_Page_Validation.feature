@Mobiles_Page_Validation
Feature: Mobiles Page Validation

  Scenario: User sees a prompt message when entering the page
    When the user navigates to the mobiles page
    Then the title message "Mobile Phones- Buy mobile phones online at best prices in India" should be displayed

