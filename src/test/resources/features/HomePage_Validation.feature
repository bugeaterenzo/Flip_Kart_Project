@HomePage
Feature: Home Page Validation

  Scenario: User should be able to load Flipkart site homepage
    Given the user launches the browser and navigates to "https://www.flipkart.com/"
    Then the page title should be "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"
    Then the Flipkart logo should be displayed


