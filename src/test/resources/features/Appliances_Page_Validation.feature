@Appliances_Page_Validation
Feature: Appliances Page Validation

  Scenario: User sees a prompt message when entering the page
    When the user navigates to the appliances page
    Then the url link should be "tvs-and-appliances-new-clp-store"

