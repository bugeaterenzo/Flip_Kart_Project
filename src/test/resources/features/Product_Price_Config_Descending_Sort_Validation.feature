@Mens_Top_Wear_Page_descending_sort_Validation
Feature: Men's Top Wear Page descending sort Validation

  Scenario: User should be able to configure product prices
    Given the user navigates to Men's Top Wear page
    When the user clicks [ Price -- High to Low ] config option
    Then the products should be listed in descending format

