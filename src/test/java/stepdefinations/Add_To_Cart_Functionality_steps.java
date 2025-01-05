package stepdefinations;

import base.setup_and_teardown;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Add_To_Cart.Add_To_Cart_Functionality_Validation;
import pages.Mens_Topwear_Page.Product_Price_Config_Ascending_Sort_Validation;
import pages.search_functionality.Search_Bar_Elements_And_Actions;
import utils.Wait_Utils;

public class Add_To_Cart_Functionality_steps extends setup_and_teardown {


    Search_Bar_Elements_And_Actions search;

    Product_Price_Config_Ascending_Sort_Validation price_config;
    Add_To_Cart_Functionality_Validation product_add_actions;


    @Before
    public void set()
    {
        setup();
        this.search = new Search_Bar_Elements_And_Actions(driver);
        this.price_config = new Product_Price_Config_Ascending_Sort_Validation(driver);
        this.product_add_actions = new Add_To_Cart_Functionality_Validation(driver);
    }


    @When("when I click on the product and click add to cart")
    public void click_Product_And_Add_To_Cart() {

        product_add_actions.add_product();

    }

    @Then("the product should be add to the cart")
    public void the_product_should_be_added_to_the_cart() {

        price_config.close_popup();
        String result = product_add_actions.product_add_validation();
        System.out.println(result);

    }



    @After
    public void tear()
    {
        Wait_Utils.global_thread_pause(500L);
        tear_down();

    }

}
