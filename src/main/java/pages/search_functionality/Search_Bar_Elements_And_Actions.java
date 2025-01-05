package pages.search_functionality;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait_Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Search_Bar_Elements_And_Actions {

    @FindBy(xpath = "//div[text()='Sorry, no results found!']")
    WebElement no_result_message;

    @FindBy(css = "input[title = 'Search for Products, Brands and More']")
    static WebElement search_field;

    @FindBy(css = "button[title = 'Search for Products, Brands and More']")
    static WebElement search_btn;

    @FindBy(xpath = "//a[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'car')]")
    private List<WebElement> carLinks;


    WebDriver driver;
    Actions action;


    public Search_Bar_Elements_And_Actions(WebDriver driver)
    {
        this.driver = driver;
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void click_on_search()
    {
        WebElement clickable_search_field = Wait_Utils.wait_for_element(driver, search_field, WaitStrategy.CLICKABLE );
        action.moveToElement(clickable_search_field).click().perform();
    }

    public void search(String key)
    {
        WebElement clickable_search_field = Wait_Utils.wait_for_element(driver, search_field, WaitStrategy.CLICKABLE );

        for (Character character : key.toCharArray())
        {
            String value = String.valueOf(character);
            Wait_Utils.global_thread_pause(100L);
            action.moveToElement(clickable_search_field).sendKeys(value).perform();
        }

        WebElement clickable_search_btn = Wait_Utils.wait_for_element(driver, search_btn, WaitStrategy.CLICKABLE );
        action.moveToElement(clickable_search_btn).click().perform();

    }



    private int count_Famous_Smartphones(WebDriver driver) {
        // List of top smartphone brands in the Indian market
        List<String> topSmartphoneNames = Arrays.asList(
                "Poco", "Samsung", "Redmi", "iPhone", "Realme", "Vivo",
                "Oppo", "OnePlus", "Motorola", "Micromax", "Infinix",
                "Lava", "Nokia", "Asus", "Lenovo", "Sony", "Google",
                "Nothing", "Tecno", "Honor"
        );

        // Retrieve the smartphone elements using the given selector
        List<WebElement> smartphoneElements = driver.findElements(
                By.cssSelector("div.cPHDOP.col-12-12 div._75nlfW div.KzDlHZ")
        );

        // Counter for famous smartphone matches
        int count = 0;

        // Check each element for a famous smartphone name
        for (WebElement element : smartphoneElements) {
            String smartphoneName = element.getText().toLowerCase(); // Convert to lowercase for comparison
            for (String brand : topSmartphoneNames) {
                if (smartphoneName.contains(brand.toLowerCase())) {
                    System.out.println("Famous smartphone found: " + smartphoneName);
                    count++; // Increment the counter if a match is found
                    break; // Stop checking other brands for this element
                }
            }
        }

        System.out.println("Total famous smartphones found: " + count);
        return count; // Return the count
    }



    public String validate_item_or_failure_message(String search_item)
    {
        List<WebElement> list = new LinkedList<>();
        int total_items_found = 0;
        String search_message = "";

        switch (search_item)
        {
            case "car":
                List<WebElement> carLinks = driver.findElements(By.xpath("//a[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'car')]"));
                if (search_item.equals("car")) list = carLinks;
                break;
            case "Smartphone":
                if (search_item.equals("Smartphone")) total_items_found = count_Famous_Smartphones(driver);
                break;
            default:
                System.out.println("Pass a Product to check search validity!");
        }
        search_message = ( list.size() > 0  || total_items_found > 0 ) ? " Related Products Found !" : " Related Products Not Found !";

        return search_message;

    }




}
