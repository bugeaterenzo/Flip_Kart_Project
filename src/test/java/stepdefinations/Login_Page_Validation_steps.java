package stepdefinations;

import base.setup_and_teardown;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.testng.Assert;
import pages.Login_Page.Login_Page_Elements;
import utils.Wait_Utils;


public class Login_Page_Validation_steps extends setup_and_teardown {

    Login_Page_Elements login_actions;

    @Before
    public void set()
    {
        setup();
        this.login_actions = new Login_Page_Elements(driver);
    }

    @When("the user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {

       login_actions.navigate_to_login_page();

    }

    @Then("the login page should be displayed")
    public void the_login_page_should_be_displayed() {

        boolean result = login_actions.validate_login_page_title();
        Assert.assertTrue(result , "This is not login page...!");
        System.out.println("Title displayed : " + result);

        Wait_Utils.global_thread_pause();

    }


    @And("the URL should be {string}")
    public void the_url_should_be(String expectedUrl) {

        boolean url_result = login_actions.validate_login_page_url();
        String messaage = "Expected URL: " + expectedUrl + ", but was not matched.";
        Assert.assertTrue( url_result , messaage);
        String post = (url_result) ? "Login Page Url Matches !" : "Url Dosnt Match !";
        System.out.println(post);

    }




    @After
    public void tear()
    {

       tear_down();

    }


}
