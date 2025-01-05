package stepdefinations;

import base.setup_and_teardown;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Mens_Topwear_Page.Product_Price_Config_Ascending_Sort_Validation;
import pages.search_functionality.Search_Bar_Elements_And_Actions;
import utils.Wait_Utils;

public class Product_Search_steps extends setup_and_teardown  {



    Search_Bar_Elements_And_Actions search;

    Product_Price_Config_Ascending_Sort_Validation price_config;


    @Before
    public void set()
    {
        setup();
        this.search = new Search_Bar_Elements_And_Actions(driver);
        this.price_config = new Product_Price_Config_Ascending_Sort_Validation(driver);
    }

    @Given("I am on the Flipkart homepage")
    public void i_am_on_the_flipkart_homepage() {

        price_config.close_popup();
        search.click_on_search();

    }

    @When("I search for {string}")
    public void i_search_for(String searchQuery) {

        search.search(searchQuery);

    }

    @Then("I should see a message or the requested product for {string}")
    public void i_should_see(String searchQuery) {

        String result = search.validate_item_or_failure_message(searchQuery);
        System.out.println(result);

    }


    @After
    public void tear()
    {
        Wait_Utils.global_thread_pause(500L);
        tear_down();

    }


}
