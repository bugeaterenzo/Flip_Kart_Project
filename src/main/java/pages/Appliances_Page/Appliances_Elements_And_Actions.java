package pages.Appliances_Page;

import enums.WaitStrategy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait_Utils;

public class Appliances_Elements_And_Actions {

    @FindBy(css = "span._30XB9F")
    WebElement close_btn;

    @FindBy(css = "img[alt= 'Appliances']")
    static WebElement appliances_btn;

    @FindBy(css = "div._48O0EI")
    WebElement appliances_page_title;


    WebDriver driver;
    Actions action;


    public Appliances_Elements_And_Actions(WebDriver driver)
    {
        this.driver = driver;
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigate_to_appliances_page()
    {

        WebElement clickable_Close_Btn = Wait_Utils.wait_for_element(driver, close_btn, WaitStrategy.CLICKABLE);
        action.moveToElement(clickable_Close_Btn).click().perform();

        System.out.println("btn : " + appliances_btn);
        WebElement clickable_appliances_Btn = Wait_Utils.wait_for_element(driver, appliances_btn, WaitStrategy.CLICKABLE);
        action.moveToElement(clickable_appliances_Btn).click().perform();

    }

    public boolean verify_appliances_url(String partial_url)
    {
        return Wait_Utils.wait_for_url_to_contain( driver, partial_url);

    }
}
