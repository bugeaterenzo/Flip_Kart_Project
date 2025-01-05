@Search
Feature: Flipkart search functionality

  Scenario Outline: Searching for products on Flipkart
    Given I am on the Flipkart homepage
    When I search for "<searchQuery>"
    Then I should see a message or the requested product for "<searchQuery>"

    Examples:
      | searchQuery     |
      | car             |
      | Smartphone      |


