package stepdefinations;

import base.setup_and_teardown;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Image_Slider.Image_Slider_Elements_And_Actions;

public class Image_Slider_Validation_steps extends setup_and_teardown {



    Image_Slider_Elements_And_Actions image_slider_actions;


    @Before
    public void set()
    {
        setup();
        this.image_slider_actions = new Image_Slider_Elements_And_Actions(driver);
    }

    @When("the user clicks next slide")
    public void the_User_Clicks_Next_Slide() {

        image_slider_actions.close_popup();
        image_slider_actions.click_next_slide_btn();
        System.out.println("Next img loaded...");
    }

    @And("when the user clicks previous slide")
    public void when_the_User_Clicks_Previous_Slide() {

        image_slider_actions.click_previous_slide_btn();
        System.out.println("Previous img reloaded...");
    }

    @Then("the slider should show the next element")
    public void the_Slider_Should_Show_The_Next_Element() {

        image_slider_actions.validate_slide_show();
    }

    @Then("the slider should show the previous element")
    public void the_Slider_Should_Show_The_previous_Element() {

        image_slider_actions.validate_slide_show();
    }



    @After
    public void tear()
    {
        tear_down();
    }


}
