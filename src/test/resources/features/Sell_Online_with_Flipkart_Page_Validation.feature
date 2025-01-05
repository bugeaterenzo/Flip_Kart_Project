@SellPage
Feature: Sell Online with Flipkart Page Validation
  As a user, I want to validate that the Sell Online with Flipkart page is displayed correctly after clicking the "Become a Seller" button.

  Scenario: Validate the Sell Online with Flipkart Page is Displayed
    Given the user is on the Flipkart homepage and clicks on the "Become a Seller" button
    Then the Sell Online with Flipkart page should be displayed
    And then the URL must be "https://seller.flipkart.com/sell-online?utm_source=fkwebsite&utm_medium=websitedirect"
