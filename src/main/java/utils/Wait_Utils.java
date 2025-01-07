package utils;

import config.Config_Manager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.zip.Deflater;

public class Wait_Utils
{

    public static Duration get_time_out()
    {
        String timeout = Config_Manager.get_property("timeout" , "10");
        if (timeout.equals("")) System.out.println("empty string...");
        else System.out.println(timeout);
        return Duration.ofSeconds(Integer.parseInt(timeout));
    }

    public static void global_thread_pause()
    {
        boolean is_global_wait_enabled = Boolean.parseBoolean(Config_Manager.get_property("EnableGlobalWait"));

        int     global_wait_timeout    = Integer.parseInt(Config_Manager.get_property("waitInSeconds" , "5"));

        System.out.println("is_global_wait_enabled : " + is_global_wait_enabled);
        System.out.println("global_wait_timeout_value : " + global_wait_timeout);

        if ( is_global_wait_enabled && global_wait_timeout > 0 )
        {

            try
            {
                Thread.sleep(global_wait_timeout * 1000);
            }
            catch ( InterruptedException e )
            {
                Thread.currentThread().interrupt();
                System.err.println("Global wait interrupted. " + e.getMessage());
            }
        }

    }


    public static void global_thread_pause(long duration)
    {
        boolean is_global_wait_enabled = Boolean.parseBoolean(Config_Manager.get_property("EnableGlobalWait"));

        if ( is_global_wait_enabled && duration > 0 )
        {
            try
            {
                Thread.sleep(duration);
            }
            catch ( InterruptedException e )
            {
                Thread.currentThread().interrupt();
                System.err.println("Global wait interrupted. " + e.getMessage());
            }
        }

    }


    public static void global_thread_pause(int duration)
    {
        boolean is_global_wait_enabled = Boolean.parseBoolean(Config_Manager.get_property("EnableGlobalWait"));

        if ( is_global_wait_enabled && duration > 0 )
        {
            try
            {
                Thread.sleep(duration * 1000);
            }
            catch ( InterruptedException e )
            {
                Thread.currentThread().interrupt();
                System.err.println("Global wait interrupted. " + e.getMessage());
            }
        }

    }


    public static WebElement wait_for_element(WebDriver driver, WebElement webelement, WaitStrategy waitStrategy)
    {
        WebDriverWait wait = new WebDriverWait( driver , get_time_out() );
        switch (waitStrategy)
        {
            case CLICKABLE:
                return wait.until(ExpectedConditions.elementToBeClickable(webelement));

            case VISIBLE:
                return wait.until(ExpectedConditions.visibilityOf(webelement));

            case NONE:

            default:
                return webelement;
        }
    }


    public static WebElement wait_for_element(WebDriver driver, By locator, WaitStrategy waitStrategy)
    {
        WebDriverWait wait = new WebDriverWait(driver, get_time_out());
        switch (waitStrategy) {
            case CLICKABLE:
                return wait.until(ExpectedConditions.elementToBeClickable(locator));

            case VISIBLE:
                return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            case PRESENCE:
                return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

            case NONE:
            default:
                return driver.findElement(locator); // Default case
        }
    }



    public static WebElement wait_until_condition(WebDriver driver, ExpectedCondition<WebElement> condition) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(condition);
    }





    public static WebElement wait_for_presence_of_element(WebDriver driver, By element ) {
        WebDriverWait wait = new WebDriverWait(driver, get_time_out());
        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }


    public static boolean wait_for_url(WebDriver driver, String expectedUrl) {
        WebDriverWait wait = new WebDriverWait(driver, get_time_out());
        return wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }


    public static boolean wait_for_url_to_contain(WebDriver driver,String partialUrl) {
        WebDriverWait wait = new WebDriverWait(driver, get_time_out());
        return wait.until(ExpectedConditions.urlContains(partialUrl));
    }


    public static boolean wait_for_title(WebDriver driver, String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(driver, get_time_out());
        return wait.until(ExpectedConditions.titleIs(expectedTitle));
    }


}
