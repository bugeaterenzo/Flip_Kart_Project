@DownloadPage
Feature: Download App Page Validation
  As a user, I want to validate that the Download App page is displayed correctly after clicking the "Download App" button.

  Scenario: Validate the Download App Page is Displayed
    Given the user is on the Flipkart homepage and hovers over dropdown and clicks on the "Download App" button
    Then then URL should be "https://www.flipkart.com/mobile-apps?otracker=ch_vn_mobile_apps"
