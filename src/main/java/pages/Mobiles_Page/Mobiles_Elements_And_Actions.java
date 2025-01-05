package pages.Mobiles_Page;

import enums.WaitStrategy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait_Utils;

public class Mobiles_Elements_And_Actions {



    @FindBy(css = "span._30XB9F")
    WebElement close_btn;

    @FindBy(css = "img[alt= 'Mobiles']")
    static WebElement mobiles_btn;

    @FindBy(xpath = "//h2[contains(text(), 'mobile')]")
    WebElement mobiles_page_title;

    @FindBy(xpath = "//img[@class='xTaogf _3iTqAS' and @src='https://rukminim2.flixcart.com/fk-p-flap/50/50/image/d511a14cf3fc8403.jpg?q=50']")
    WebElement imageElement;


    WebDriver driver;
    Actions action;


    public Mobiles_Elements_And_Actions(WebDriver driver)
    {
        this.driver = driver;
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigate_to_mobiles_page()
    {

        WebElement clickable_Close_Btn = Wait_Utils.wait_for_element(driver, close_btn, WaitStrategy.CLICKABLE);
        action.moveToElement(clickable_Close_Btn).click().perform();

        System.out.println("btn : " + mobiles_btn);
        WebElement clickable_mobiles_Btn = Wait_Utils.wait_for_element(driver, mobiles_btn, WaitStrategy.CLICKABLE);
        action.moveToElement(clickable_mobiles_Btn).click().perform();

    }

    public String verify_mobiles_title_message()
    {
        WebElement title_message = Wait_Utils.wait_for_element(driver, mobiles_page_title, WaitStrategy.PRESENCE);
        // Use JavaScriptExecutor to scroll to the element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", imageElement);
        Wait_Utils.global_thread_pause();
        return title_message.getText();
    }

}
