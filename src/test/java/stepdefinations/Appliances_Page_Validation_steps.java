package stepdefinations;

import base.setup_and_teardown;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Appliances_Page.Appliances_Elements_And_Actions;


public class Appliances_Page_Validation_steps extends setup_and_teardown {


    Appliances_Elements_And_Actions appliances_actions;


    @Before
    public void set()
    {
        setup();
        this.appliances_actions = new Appliances_Elements_And_Actions(driver);
    }

    @When("the user navigates to the appliances page")
    public void the_user_navigates_to_the_appliances_page() {

        appliances_actions.navigate_to_appliances_page();

    }

    @Then("the url link should be {string}")
    public void the_url_link_should_be(String expected_url) {

        boolean result = appliances_actions.verify_appliances_url(expected_url);
        Assert.assertTrue(result ,"The url dose not match!");
        String post = (result) ? "The appliances url Matches !" : "The appliances url Dosnt Match !";
        System.out.println(post);

    }


    @After
    public void tear()
    {
        tear_down();
    }


}
