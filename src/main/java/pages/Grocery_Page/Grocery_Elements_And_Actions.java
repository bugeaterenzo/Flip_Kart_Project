package pages.Grocery_Page;

import enums.WaitStrategy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait_Utils;

public class Grocery_Elements_And_Actions
{

    @FindBy(css = "span._30XB9F")
    WebElement close_btn;

    @FindBy(xpath = "//span[text()= 'Grocery']")
    WebElement grocery_btn;

    @FindBy(css = "div.b3YJls")
    WebElement verify_pincode_message;


    WebDriver driver;
    Actions action;


    public Grocery_Elements_And_Actions(WebDriver driver)
    {
        this.driver = driver;
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigate_to_grocery_page()
    {
        Wait_Utils.global_thread_pause();
        WebElement clickable_Close_Btn = Wait_Utils.wait_for_element(driver, close_btn, WaitStrategy.CLICKABLE);
        action.moveToElement(clickable_Close_Btn).click().perform();

        System.out.println("btn : " + grocery_btn);
        WebElement clickable_grocery_Btn = Wait_Utils.wait_for_element(driver, grocery_btn, WaitStrategy.CLICKABLE);
        action.moveToElement(clickable_grocery_Btn).click().perform();

    }

    public String verify_pincode_message()
    {
        WebElement message = Wait_Utils.wait_for_element(driver, verify_pincode_message, WaitStrategy.VISIBLE);
        return message.getText();
    }
}
