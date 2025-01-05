package pages.FlipKart_Home_Page;
import dev.failsafe.internal.util.Assert;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Wait_Utils;


public class FlipKart_HomePage_Actions {

    WebDriver driver;

    public FlipKart_HomePage_Actions(WebDriver driver)
    {
        this.driver = driver;
    }

    public boolean validate_flipkart_logo()
    {

        WebElement logo = Wait_Utils.wait_for_element(driver, By.cssSelector("img[title='Flipkart']"), WaitStrategy.PRESENCE);
        return logo.isDisplayed();

    }


    public boolean validate_flipkart_title(String expected)
    {
        return Wait_Utils.wait_for_title(driver, expected);
    }

    public boolean validate_flipkart_url(String expected_url)
    {
        return Wait_Utils.wait_for_url(driver, expected_url);
    }




}
