package stepdefinations;

import base.setup_and_teardown;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Login_Page.Login_Page_Elements;

public class Login_Page_Input_Validation_steps extends setup_and_teardown {

    Login_Page_Elements login_actions;

    @Before
    public void set()
    {
        setup();
        this.login_actions = new Login_Page_Elements(driver);
    }

    @When("the user enters an invalid input value as {string}")
    public void user_enters_invalid_email_or_phone(String inputValue)
    {
        login_actions.navigate_to_login_page();
        login_actions.invalid_input_insertion(inputValue);
    }


    @And("the user clicks the Request OTP button")
    public void user_clicks_Request_OTP_button() {
        login_actions.request_otp();
    }


    @Then("the error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedMessage)
    {
        String result_message = login_actions.validate_unsuccessful_message();
        Assert.assertEquals( result_message, expectedMessage,"Message dose not match!" );
        String post = (result_message.equals(expectedMessage)) ? "Success Message Matches !" : "Success Message Dosnt Match !";
        System.out.println(post);
    }

    @After
    public void tear()
    {

        tear_down();

    }

}
