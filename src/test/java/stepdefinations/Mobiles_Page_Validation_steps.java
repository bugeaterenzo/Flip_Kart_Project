package stepdefinations;

import base.setup_and_teardown;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Grocery_Page.Grocery_Elements_And_Actions;
import pages.Mobiles_Page.Mobiles_Elements_And_Actions;

public class Mobiles_Page_Validation_steps extends setup_and_teardown {


    Mobiles_Elements_And_Actions mobiles_actions;

    @Before
    public void set()
    {
        setup();
        this.mobiles_actions = new Mobiles_Elements_And_Actions(driver);
    }

    @When("the user navigates to the mobiles page")
    public void the_user_navigates_to_the_grocery_page() {

        mobiles_actions.navigate_to_mobiles_page();

    }


    @Then("the title message {string} should be displayed")
    public void the_title_message_should_be_displayed(String expected_message) {

        String actual_message = mobiles_actions.verify_mobiles_title_message();
        Assert.assertEquals(actual_message, expected_message, "The Message dose not match!");
        String post = (actual_message.equals(expected_message)) ? "The Grocery Page Message Matches !" : "The Grocery Page Message Dosnt Match !";
        System.out.println(post);

    }


    @After
    public void tear()
    {
        tear_down();
    }


}
