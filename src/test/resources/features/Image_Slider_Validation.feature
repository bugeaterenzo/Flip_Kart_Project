@Image_Slider_Validation
Feature: Image Slider Validation

  Scenario: User should be able to use slider buttons
    When the user clicks next slide
    Then the slider should show the next element
    And when the user clicks previous slide
    Then the slider should show the previous element

