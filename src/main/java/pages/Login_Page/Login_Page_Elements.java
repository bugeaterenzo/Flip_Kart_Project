package pages.Login_Page;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.FlipKart_Home_Page.FlipKart_Home_Page_Elements;
import utils.Wait_Utils;

public class Login_Page_Elements {

    WebDriver driver;
    Actions action;

// _30XB9F
    //_30XB9F

    @FindBy(css = "span._30XB9F")
    WebElement close_btn;

    @FindBy(xpath = "//span[contains(text(), 'Login')]")
    WebElement login_page_title;

    @FindBy(css = "a[title='Login']")
    WebElement login_btn;

    @FindBy(css = "input.r4vIwl ")
    WebElement email_or_phone_inputfield;

    @FindBy(xpath = "//button[contains(text(), 'Request OTP')]")
    WebElement request_otp_btn;

    @FindBy(xpath = "//span[contains(text(), 'Please enter valid Email ID/Mobile number')]")
    WebElement success_message;


    public Login_Page_Elements(WebDriver driver)
    {
        this.driver = driver;
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }


    public void navigate_to_login_page()
    {
        Wait_Utils.global_thread_pause();
        WebElement present_Close_Btn = Wait_Utils.wait_for_element(driver, close_btn, WaitStrategy.PRESENCE);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", present_Close_Btn);
//        if (present_Close_Btn.isDisplayed()) {
//            try {
//                Wait_Utils.wait_for_element(driver, close_btn, WaitStrategy.CLICKABLE);
//                action.click(present_Close_Btn).perform();
//                System.out.println("Closed the pop-up successfully.");
//            } catch (Exception e) {
//                System.out.println("Failed to close the pop-up: " + e.getMessage());
//            }
//        }
//
//        while(present_Close_Btn.isEnabled())
//        {
//            //action.click(present_Close_Btn).perform();
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", present_Close_Btn);
//            if (!present_Close_Btn.isDisplayed()) break;
//        }

        System.out.println("btn : " + login_btn);
        Wait_Utils.wait_for_element(driver, login_btn, WaitStrategy.CLICKABLE);
        login_btn.click();

    }

    public boolean validate_login_page_url()
    {
        return Wait_Utils.wait_for_url(driver, "https://www.flipkart.com/account/login?ret=/");
    }


    public boolean validate_login_page_title()
    {
        WebElement title = Wait_Utils.wait_for_element(driver, login_page_title, WaitStrategy.PRESENCE );
        return title.isDisplayed();
    }


    public void invalid_input_insertion(String input_value)
    {

        WebElement clickable_email_or_phone_inputfield =
                Wait_Utils.wait_for_element(driver, email_or_phone_inputfield, WaitStrategy.CLICKABLE);

        action.moveToElement(clickable_email_or_phone_inputfield).click().perform();

        for (Character character : input_value.toCharArray())
        {
            Wait_Utils.global_thread_pause(100);
            email_or_phone_inputfield.sendKeys(String.valueOf(character));
        }

    }

    public void request_otp()
    {
        WebElement clickable_request_otp_btn =
                Wait_Utils.wait_for_element(driver, request_otp_btn, WaitStrategy.CLICKABLE);
        action.moveToElement(clickable_request_otp_btn).click().perform();

    }


    public String validate_unsuccessful_message()
    {
        WebElement visible_success_message =
                Wait_Utils.wait_for_element(driver, success_message, WaitStrategy.VISIBLE);

        return visible_success_message.getText();


    }






}
