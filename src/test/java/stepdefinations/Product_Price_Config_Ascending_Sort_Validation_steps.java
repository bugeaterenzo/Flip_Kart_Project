package stepdefinations;

import base.setup_and_teardown;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Mens_Topwear_Page.Product_Price_Config_Ascending_Sort_Validation;
import utils.Wait_Utils;

public class Product_Price_Config_Ascending_Sort_Validation_steps extends setup_and_teardown  {

    Product_Price_Config_Ascending_Sort_Validation price_config_ascending;


    @Before
    public void set()
    {
        setup();
        this.price_config_ascending = new Product_Price_Config_Ascending_Sort_Validation(driver);
    }



    @Given("the user navigates to Men's Top Wear page")
    public void the_user_navigates_to_mens_top_wear_page() {

        price_config_ascending.close_popup();
        price_config_ascending.navigate_to_mens_top_wear_page();
    }



    @When("the user clicks [ Price -- Low to High ] config option")
    public void the_user_clicks_price_low_to_high_config_option() {

        Wait_Utils.global_thread_pause(2);
        price_config_ascending.click_Price_Low_to_High();
        Wait_Utils.global_thread_pause(4);

    }


    @Then("the products should be listed in ascending format")
    public void the_products_should_be_listed_in_ascending_format() {

        boolean result = price_config_ascending.validate_ascending_price_list();
        Wait_Utils.global_thread_pause(500000L);
        Assert.assertTrue(result, "The list is not sorted in ascending order!");


    }


    @After
    public void tear()
    {
        Wait_Utils.global_thread_pause(500L);
        tear_down();

    }




}
