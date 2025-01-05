package stepdefinations;

import base.setup_and_teardown;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.SignUp_Page.SignUp_Page_Elements_and_Actions;
import utils.Wait_Utils;

public class SignUp_Page_Validation_steps extends setup_and_teardown
{

    SignUp_Page_Elements_and_Actions singup_actions;


    @Before
    public void set()
    {
        setup();
        this.singup_actions = new SignUp_Page_Elements_and_Actions(driver);
    }



    @Given("the user is in flipkart homepage and clicks on the sign-up button")
    public void the_user_is_in_flipkart_homepage_and_clicks_on_the_sign_up_button() {

        singup_actions.navigate_to_signup_page();

    }

    @Then("the sign-up page should be displayed")
    public void the_sign_up_page_should_be_displayed() {
        Wait_Utils.global_thread_pause();
        boolean result =  singup_actions.validate_signup_page_title();
        Assert.assertTrue(result, "This is not the sing up page!");
        System.out.println("Title displayed : " + result);

        Wait_Utils.global_thread_pause();
    }

    @Then("the URL must be {string}")
    public void the_url_must_be(String expectedUrl) {

       boolean url_result = singup_actions.validate_signup_page_url();
       String messaage = "Expected URL: " + expectedUrl + ", but was not matched.";
       Assert.assertTrue( url_result , messaage);
       String post = (url_result) ? "Url Matches !" : "Url Dosnt Match !";
       System.out.println(post);

    }

    @After
    public void tear()
    {

        tear_down();

    }







}
