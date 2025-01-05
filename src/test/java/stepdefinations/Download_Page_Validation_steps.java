package stepdefinations;

import base.setup_and_teardown;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.Download_App_Page.Download_Page_Elements_And_Actions;

public class Download_Page_Validation_steps extends setup_and_teardown {

    Download_Page_Elements_And_Actions download_Page_Actions;

    @Before
    public void setUp() {
        setup();
        download_Page_Actions = new Download_Page_Elements_And_Actions(driver);
    }

    @Given("the user is on the Flipkart homepage and hovers over dropdown and clicks on the \"Download App\" button")
    public void the_user_clicks_on_the_download_app_button() {
        download_Page_Actions.navigate_to_download_page();
    }

    @Then("then URL should be {string}")
    public void then_url_should_be(String expectedUrl) {
        boolean isUrlCorrect = download_Page_Actions.validate_download_page_url();
        Assert.assertTrue(isUrlCorrect, "Expected URL: " + expectedUrl + ", but the actual URL does not match.");
        System.out.println(isUrlCorrect ? "URL Matches!" : "URL Doesn't Match!");
    }

    @After
    public void tearDown() {
        tear_down();
    }

}
