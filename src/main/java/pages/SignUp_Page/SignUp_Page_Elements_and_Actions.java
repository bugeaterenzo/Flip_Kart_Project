package pages.SignUp_Page;

import enums.WaitStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait_Utils;

public class SignUp_Page_Elements_and_Actions {


    @FindBy(css = "span._30XB9F")
    WebElement close_btn;

    @FindBy(css = "a[title='Login']")
    WebElement login_btn;

    @FindBy(xpath = "//span[text()='Sign Up']")
    WebElement signup_btn;

    @FindBy(xpath = "//span[contains(text(), 'Sign up')]")
    WebElement signup_page_title;

    WebDriver driver;
    Actions action;

    public SignUp_Page_Elements_and_Actions(WebDriver driver)
    {
        this.driver = driver;
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }


    public void navigate_to_signup_page()
    {
        WebElement visible_Close_Btn = Wait_Utils.wait_for_element(driver, close_btn, WaitStrategy.VISIBLE);
        action.click(visible_Close_Btn).perform();
        WebElement visible_Login_Btn = Wait_Utils.wait_for_element(driver, login_btn, WaitStrategy.VISIBLE);
        action.moveToElement(visible_Login_Btn).perform();
        System.out.println("btn : " + signup_btn);
        Wait_Utils.wait_for_element(driver, signup_btn, WaitStrategy.CLICKABLE);
        signup_btn.click();

    }

    public boolean validate_signup_page_url()
    {
        return Wait_Utils.wait_for_url(driver, "https://www.flipkart.com/account/login?signup=true&ret=/");
    }


    public boolean validate_signup_page_title()
    {
        WebElement title = Wait_Utils.wait_for_element(driver, signup_page_title, WaitStrategy.PRESENCE );
        return title.isDisplayed();
    }

}
