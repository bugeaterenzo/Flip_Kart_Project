package pages.Image_Slider;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.FlipKart_Home_Page.FlipKart_Home_Page_Elements;
import utils.Wait_Utils;

import java.util.LinkedList;
import java.util.List;

public class Image_Slider_Elements_And_Actions {


    @FindBy(css = "span._30XB9F")
    WebElement close_btn;

    @FindBy(css = "div._8S67Ib")
    WebElement slider_image_div;

    @FindBy(css = "div[id='product-']")
    static WebElement flightbookings_btn;



    int[] variable_slider_img_ids = {0,1,2,3};

    List<String> expected_image_string_ids;


    WebDriver driver;
    Actions action;
    FlipKart_Home_Page_Elements home;


    public Image_Slider_Elements_And_Actions(WebDriver driver)
    {
        this.driver = driver;
        this.action = new Actions(driver);
        this.home = new FlipKart_Home_Page_Elements(driver);
        this.expected_image_string_ids = new LinkedList<>();
        PageFactory.initElements(driver, this);
    }

    public void generate()
    {

        for ( int id : variable_slider_img_ids )
        {
            String id_locater = "product-"+ id;
            System.out.println("generated id : " + id_locater);
            expected_image_string_ids.add(id_locater);
        }
    }

    public void close_popup()
    {
        WebElement clickable_Close_Btn = Wait_Utils.wait_for_element(driver, close_btn, WaitStrategy.CLICKABLE);
        action.moveToElement(clickable_Close_Btn).click().perform();
        generate();
    }


    public void click_next_slide_btn()
    {
        Wait_Utils.global_thread_pause(4);
        WebElement next = Wait_Utils.wait_for_element(driver, home.next_btn, WaitStrategy.CLICKABLE);
        action.moveToElement(next).click().perform();
    }

    public void click_previous_slide_btn()
    {
        Wait_Utils.global_thread_pause(4);
        WebElement previous = Wait_Utils.wait_for_element(driver, home.previous_btn, WaitStrategy.CLICKABLE);
        action.moveToElement(previous).click().perform();
        Wait_Utils.global_thread_pause(8);
    }





    public void validate_slide_show()
    {

        for (String expected_img_id : expected_image_string_ids)
        {
            WebElement Element = Wait_Utils.wait_until_condition(driver, check -> {
                WebElement element;
                try
                {
                    element = check.findElement(By.id(expected_img_id));
                    return element.isDisplayed() && element.getAttribute("data-clone").equals("false") ? element : null;
                }
                catch (Exception e)
                {
                    return null;
                }
            });

            // && element.getAttribute("data-clone").equals("true")

            if (Element != null) {
                WebElement slide =Wait_Utils.wait_for_element(driver, slider_image_div, WaitStrategy.VISIBLE);

                System.out.println("Current slider state:");
                System.out.println("Visible ID: " + slide.getAttribute("id"));
                System.out.println("Data-clone: " + slide.getAttribute("data-clone"));

                System.out.println("Element with ID: " + expected_img_id + " is visible and is looping in the slider!");
                return;
            }
        }

        System.out.println("No matching element found that is visible and looping in the slider.");
    }








}
