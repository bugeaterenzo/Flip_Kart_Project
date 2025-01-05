package stepdefinations;

import base.setup_and_teardown;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Grocery_Page.Grocery_Elements_And_Actions;
import utils.Wait_Utils;


public class Grocery_Page_Validation_steps extends setup_and_teardown {

    Grocery_Elements_And_Actions grocery_actions;

    @Before
    public void set()
    {
        setup();
        this.grocery_actions = new Grocery_Elements_And_Actions(driver);
    }

    @When("the user navigates to the grocery page")
    public void the_user_navigates_to_the_grocery_page() {

       grocery_actions.navigate_to_grocery_page();

    }


    @Then("the prompt message {string} should be displayed")
    public void the_prompt_message_should_be_displayed(String expected_message) {

        String actual_message = grocery_actions.verify_pincode_message();
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
