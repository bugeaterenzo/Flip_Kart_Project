package stepdefinations;

import base.setup_and_teardown;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Flight_Bookings_Page.Flight_Bookings_Elements_Actions;


public class Flight_Page_Validation_steps extends setup_and_teardown  {

    Flight_Bookings_Elements_Actions flight_action;


    @Before
    public void set()
    {
        setup();
        this.flight_action = new Flight_Bookings_Elements_Actions(driver);
    }

    @When("the user navigates to the Flight page")
    public void the_user_navigates_to_the_appliances_page() {

        flight_action.navigate_to_flight_page();

    }

    @Then("the form should be visible and url link must contain {string}")
    public void the_form_should_be_visible_and_url_link_must_contain(String partial_url) {

        boolean result = flight_action.verify_flight_url_and_form(partial_url);
        Assert.assertTrue(result ,"The form is not visible and the url dose not match!");
        String post = (result) ? "The flight url Matches and the form is visible !" : "The flight url dose not Match and the form is not visible !";
        System.out.println(post);

    }


    @After
    public void tear()
    {
        tear_down();
    }

}
