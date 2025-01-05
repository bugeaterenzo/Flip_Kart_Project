@add_to_cart
Feature: add to cart functionality

  Scenario Outline: Searching for products on Flipkart
    Given I am on the Flipkart homepage
    When I search for "<searchQuery>"
    Then I should see a message or the requested product for "<searchQuery>"
    And when I click on the product and click add to cart
    Then the product should be add to the cart

    Examples:
      | searchQuery     |
      | Smartphone      |