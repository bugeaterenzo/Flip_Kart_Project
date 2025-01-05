package pages.Flight_Bookings_Page;

import enums.WaitStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait_Utils;

public class Flight_Bookings_Elements_Actions {

    @FindBy(css = "div.mo5n3D")
    WebElement bookings_page_form;

    @FindBy(css = "img[alt= 'Flight Bookings']")
    static WebElement flightbookings_btn;

    @FindBy(css = "span._30XB9F")
    WebElement close_btn;


    WebDriver driver;
    Actions action;

    public Flight_Bookings_Elements_Actions(WebDriver driver)
    {
        this.driver = driver;
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }


    public void navigate_to_flight_page()
    {

        WebElement clickable_Close_Btn = Wait_Utils.wait_for_element(driver, close_btn, WaitStrategy.CLICKABLE);
        action.moveToElement(clickable_Close_Btn).click().perform();

        System.out.println("btn : " + flightbookings_btn);
        WebElement clickable_flight_Btn = Wait_Utils.wait_for_element(driver, flightbookings_btn, WaitStrategy.CLICKABLE);
        action.moveToElement(clickable_flight_Btn).click().perform();

    }

    public boolean verify_flight_url_and_form(String partial_url)
    {
        WebElement visible_form = Wait_Utils.wait_for_element(driver, bookings_page_form, WaitStrategy.VISIBLE );
        boolean url = Wait_Utils.wait_for_url_to_contain( driver, partial_url);

        return (visible_form.isDisplayed() && url) ? true : false;

    }


}
