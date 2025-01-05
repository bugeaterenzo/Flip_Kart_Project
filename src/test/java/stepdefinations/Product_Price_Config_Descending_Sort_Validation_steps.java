package stepdefinations;

import base.setup_and_teardown;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Mens_Topwear_Page.Product_Price_Config_Ascending_Sort_Validation;
import pages.Mens_Topwear_Page.Product_Price_Config_Descending_Sort_Validation;
import utils.Wait_Utils;


public class Product_Price_Config_Descending_Sort_Validation_steps extends setup_and_teardown {


    Product_Price_Config_Descending_Sort_Validation price_config_descending;
    Product_Price_Config_Ascending_Sort_Validation price_config_ascending;


    @Before
    public void set()
    {
        setup();
        this.price_config_descending = new Product_Price_Config_Descending_Sort_Validation(driver);
        this.price_config_ascending = new Product_Price_Config_Ascending_Sort_Validation(driver);
    }


    @When("the user clicks [ Price -- High to Low ] config option")
    public void the_user_clicks_price_high_to_low_config_option() {

        Wait_Utils.global_thread_pause(2);
        price_config_descending.click_Price_High_to_Low();
        Wait_Utils.global_thread_pause(4);

    }


    @Then("the products should be listed in descending format")
    public void the_products_should_be_listed_in_descending_format() {

          boolean result = price_config_descending.validate_descending_price_list();
          Wait_Utils.global_thread_pause(500000L);
          Assert.assertTrue(result, "The list is not sorted in descending order!");


    }




    @After
    public void tear()
    {
        Wait_Utils.global_thread_pause(500L);
        tear_down();

    }

}
