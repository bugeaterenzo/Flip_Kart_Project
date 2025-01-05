package stepdefinations;

import base.setup_and_teardown;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.Sell_With_Us_Page.Sell_Page_Elements_And_Actions;


public class Sell_Online_with_Flipkart_Page_Validation_steps extends setup_and_teardown {

    Sell_Page_Elements_And_Actions sell_page_actions;


    @Before
    public void set()
    {
        setup();
        this.sell_page_actions = new Sell_Page_Elements_And_Actions(driver);
    }

    @Given("the user is on the Flipkart homepage and clicks on the \"Become a Seller\" button")
    public void the_user_is_on_the_flipkart_homepage_and_clicks_on_the_become_a_seller_button() {
        sell_page_actions.navigate_to_sell_page();
    }

    @Then("the Sell Online with Flipkart page should be displayed")
    public void the_sell_online_with_flipkart_page_should_be_displayed() {
        boolean isPageTitleValid = sell_page_actions.validate_sell_page_title();
        Assert.assertTrue(isPageTitleValid,"Sell Online with Flipkart page title is not displayed correctly");
    }

    @And("then the URL must be {string}")
    public void then_the_url_must_be(String expectedUrl) {
        boolean isUrlValid = sell_page_actions.validate_sell_page_url();
        Assert.assertTrue( isUrlValid,"The Sell Online with Flipkart page URL is not correct" );
        String post = (isUrlValid) ? "Url Matches !" : "Url Dosnt Match !";
        System.out.println(post);
    }

    @After
    public void tear()
    {

        tear_down();

    }

}
