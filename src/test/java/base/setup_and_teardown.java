package base;

import config.Config_Manager;
import config.Driver_Factory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class setup_and_teardown
{
    public WebDriver driver;

    protected static final Logger logger = LogManager.getLogger(setup_and_teardown.class);


    @BeforeMethod
    public void setup()
    {
            driver = Driver_Factory.getDriver();

            driver.get(Config_Manager.get_property("baseUrl"));

            logger.info("Started test with URL {}", Config_Manager.get_property("baseUrl"));
    }




    @AfterMethod
    public static void tear_down()
    {
        Driver_Factory.quit_driver();
    }




}
