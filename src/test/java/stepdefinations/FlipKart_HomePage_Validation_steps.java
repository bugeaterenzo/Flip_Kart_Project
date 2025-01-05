package stepdefinations;

import base.setup_and_teardown;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.testng.Assert;

import pages.FlipKart_Home_Page.FlipKart_HomePage_Actions;


public class FlipKart_HomePage_Validation_steps extends setup_and_teardown {


    FlipKart_HomePage_Actions home_page_actions;

    @Before
    public void set()
    {
    setup();
    this.home_page_actions = new FlipKart_HomePage_Actions(driver);
    }

    // this approach is wrong...!
    // FlipKart_HomePage_Actions home_page_actions = new FlipKart_HomePage_Actions(driver);



    @Given("the user launches the browser and navigates to {string}")
    public void the_user_launches_the_browser_and_navigates_to(String url) {

    boolean result =  home_page_actions.validate_flipkart_url(url);

    Assert.assertTrue(result , "The flipkart url dose not match!");

    }


    @Then("the page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {

    boolean result = home_page_actions.validate_flipkart_title(expectedTitle);

    Assert.assertTrue(result , "The flipkart title dose not match! ");

    }

    @Then("the Flipkart logo should be displayed")
    public void the_flipkart_logo_should_be_displayed() {
        // Call the validate_flipkart_logo() method and store the result
        boolean isLogoDisplayed = home_page_actions.validate_flipkart_logo();

        // Assert that the logo is displayed
        Assert.assertTrue(isLogoDisplayed, "The Flipkart logo is not displayed on the page!");
    }


    @After
    public void tear()
    {
        if (driver != null ) tear_down();
    }


}











