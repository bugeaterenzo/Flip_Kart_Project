package pages.Add_To_Cart;

import enums.WaitStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait_Utils;

import java.util.List;

public class Add_To_Cart_Functionality_Validation {


//    @FindBy(css = "li.col.col-2-12 > button:nth-child(1)")
//    WebElement add_to_cart_icon;
//
    @FindBy(xpath = "//li/button[contains(text(), 'Add to cart')]")
    WebElement add_to_cart_btn;

    @FindBy (xpath = "//button[normalize-space()='Add to cart']")
    public WebElement cartAdding;

    @FindBy(xpath = "//li/button[text()='GO TO CART']")
    WebElement go_to_cart_btn;

    @FindBy(css = "img[title='Flipkart']")
    static WebElement home_page_icon;

    @FindBy(css = "div.KzDlHZ")
    static List<WebElement> found_products;

    @FindBy(css = "a[title = 'Cart']")
    static WebElement Cart_btn;

    @FindBy(css = "span._2U7eDE")
    static WebElement product_count_icon;



    WebDriver driver;
    Actions action;


    public Add_To_Cart_Functionality_Validation(WebDriver driver)
    {
        this.driver = driver;
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }



    public void add_product()
    {
        WebElement clickable_first_product = Wait_Utils.wait_for_element(driver, found_products.get(0), WaitStrategy.CLICKABLE );
        action.moveToElement(clickable_first_product).click().perform();

        Wait_Utils.global_thread_pause(6);

        WebElement clickable_go_to_cart_btn = Wait_Utils.wait_for_element(driver, cartAdding, WaitStrategy.VISIBLE );
        action.moveToElement(clickable_go_to_cart_btn).click().perform();

        Wait_Utils.global_thread_pause(50000000L);

        Wait_Utils.global_thread_pause(6);

        // X: 423, Y: 554

        // X: 466, Y: 677
//        action.moveByOffset(466, 677).click().perform();
//        System.out.println("xOffset = 466, yOffset = 677 add to cart clicked!");
//
//        Wait_Utils.global_thread_pause(50000000L);
//        Wait_Utils.global_thread_pause(6);

        // X: 620, Y: 549

        // X: 433, Y: 104
//        action.moveByOffset(433, 104).click().perform();
//        System.out.println("xOffset = 433, yOffset = 104 buy now clicked!");
//
//        Wait_Utils.global_thread_pause(50000000L);

//       try
//       {
//
//
//           WebElement present_add_to_cart_btn = Wait_Utils.wait_for_element(driver, add_to_cart_btn, WaitStrategy.PRESENCE );
//           WebElement clickable_add_to_cart_btn = Wait_Utils.wait_for_element(driver, add_to_cart_btn, WaitStrategy.CLICKABLE );
//           action.moveToElement(clickable_add_to_cart_btn).click().perform();
//
//
//
//       } catch (Exception e)
//       {
//           throw new RuntimeException(e);
//       }
//
//        try
//        {
//
//            WebElement present_add_to_cart_icon = Wait_Utils.wait_for_element(driver, add_to_cart_icon, WaitStrategy.PRESENCE );
//            WebElement clickable_add_to_cart_icon = Wait_Utils.wait_for_element(driver, add_to_cart_icon, WaitStrategy.CLICKABLE );
//            action.moveToElement(clickable_add_to_cart_icon).click().perform();
//
//
//
//        } catch (Exception e)
//        {
//            throw new RuntimeException(e);
//        }


        // X: 392, Y: 44
        WebElement clickable_home_page_icon = Wait_Utils.wait_for_element(driver, home_page_icon, WaitStrategy.CLICKABLE );
        action.moveToElement(clickable_home_page_icon).click().perform();

    }


    public String product_add_validation()
    {
        WebElement visible_product_count_icon = Wait_Utils.wait_for_element(driver, product_count_icon, WaitStrategy.VISIBLE );
        String count_of_product_added = visible_product_count_icon.getText();
        int product_count = Integer.parseInt(count_of_product_added);

        return (product_count > 0 ) ?  ( product_count + "PRODUCT ADDED !") : "NO PRODUCT ADDED !";
    }


}
