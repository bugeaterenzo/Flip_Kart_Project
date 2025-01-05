package config;

import enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;




public class Driver_Factory
{

    // web driver instance
    public static WebDriver driver;

    static int count = 0;

    public static synchronized WebDriver getDriver()
    {
        if (driver == null)
        {
            count++;
            System.out.println( count + "   Initializing new WebDriver instance.");
            inintialize_driver();

        }
        else
        {
            //System.out.println("    Reusing existing WebDriver instance.");

        }
        return driver;
    }

    private static WebDriver inintialize_driver()
    {
        String value = Config_Manager.get_property("browser").toUpperCase();
        System.out.println("Assigned Browser Value : " + value);

        Browser browser = Browser.valueOf(Config_Manager.get_property("browser").toUpperCase());

        Boolean is_headless = Boolean.parseBoolean(Config_Manager.get_property("isHeadless"));
        System.out.println("Loaded configuration with headless mode: " + is_headless);

        switch(browser)
        {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();

                if (is_headless)
                {
                    chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920x1080");
                }
                driver = new ChromeDriver(chromeOptions);
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();

                if (is_headless) {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case EDGE:

                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();

                if (is_headless) {
                    edgeOptions.addArguments("--headless");
                }
                driver = new EdgeDriver(edgeOptions);
                break;

            case SAFARI:

                WebDriverManager.safaridriver().setup();

                driver = new SafariDriver();
                break;

            default:

                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.manage().window().maximize();

        return driver;
    }


    public static synchronized void quit_driver()
    {
        if (driver != null)
        {
            driver.quit();
            driver = null;
        }
    }

}
