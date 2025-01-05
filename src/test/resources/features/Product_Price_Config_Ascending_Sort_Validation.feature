@Mens_Top_Wear_Page_Ascending_sort_Validation
Feature: Men's Top Wear Page Ascending Sort Validation

  Scenario: User should be able to configure product prices
    Given the user navigates to Men's Top Wear page
    When the user clicks [ Price -- Low to High ] config option
    Then the products should be listed in ascending format