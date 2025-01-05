package pages.Sell_With_Us_Page;

import enums.WaitStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait_Utils;

public class Sell_Page_Elements_And_Actions {

    @FindBy(css = "span._30XB9F")
    WebElement close_btn;

    @FindBy(css = "a[title = 'Become a Seller']")
    static WebElement Become_a_Seller_btn;

    @FindBy(xpath = "//span[text()='Sell Online with Flipkart']")
    static WebElement Become_a_Seller_Page_title;

    WebDriver driver;
    Actions action;

    public Sell_Page_Elements_And_Actions(WebDriver driver)
    {
        this.driver = driver;
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }


    public void navigate_to_sell_page()
    {
        WebElement visible_Close_Btn = Wait_Utils.wait_for_element(driver, close_btn, WaitStrategy.VISIBLE);
        action.click(visible_Close_Btn).perform();
        WebElement clickable_Sell_Btn = Wait_Utils.wait_for_element(driver, Become_a_Seller_btn, WaitStrategy.CLICKABLE);
        System.out.println("btn : " + clickable_Sell_Btn);
        action.moveToElement(clickable_Sell_Btn).click().perform();

    }

    public boolean validate_sell_page_url()
    {
        return Wait_Utils.wait_for_url(driver, "https://seller.flipkart.com/sell-online?utm_source=fkwebsite&utm_medium=websitedirect");
    }


    public boolean validate_sell_page_title()
    {
        WebElement title = Wait_Utils.wait_for_element(driver, Become_a_Seller_Page_title, WaitStrategy.PRESENCE );
        String title_value = title.getText();
        return (title.isDisplayed() && title_value.equals("Sell Online with Flipkart")) ? true : false;

    }


}
