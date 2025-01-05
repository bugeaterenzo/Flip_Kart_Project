package test;

import base.setup_and_teardown;
import enums.WaitStrategy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import stepdefinations.FlipKart_HomePage_Validation_steps;
import utils.Wait_Utils;

public class demo_test extends setup_and_teardown
{

    protected static final Logger logger = LogManager.getLogger(demo_test.class);

    @Test
    public void demo_flip_kart_test() throws InterruptedException
    {
        logger.info("demo test started......!");
        WebElement title =  Wait_Utils.wait_for_element(driver, By.cssSelector("img[title='Flipkart']") , WaitStrategy.VISIBLE);
        System.out.println("title : " + title.getAttribute("title"));
    }
}
