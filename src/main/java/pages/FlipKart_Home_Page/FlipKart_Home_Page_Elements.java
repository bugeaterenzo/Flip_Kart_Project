package pages.FlipKart_Home_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipKart_Home_Page_Elements
{

    WebDriver driver;

    public FlipKart_Home_Page_Elements(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "img[title='Flipkart']")
    static By flipkart_logo;

    @FindBy(css = "a[title='Login']")
    public static WebElement login_btn;

    @FindBy(css = "a[title = 'Sign Up']")
    static WebElement signin_btn;

    @FindBy(css = "a[title = 'My Profile']")
    static WebElement myprofile_btn;

    @FindBy(css = "a[title = 'Flipkart Plus Zone']")
    static WebElement flipkartpluszone_btn;

    @FindBy(css = "a[title = 'Orders']")
    static WebElement orders_btn;

    @FindBy(css = "a[title = 'wishlist']")
    static WebElement wishlist_btn;

    @FindBy(css = "a[title = 'Rewards']")
    static WebElement rewards_btn;

    @FindBy(css = "a[title = 'Gift Cards']")
    static WebElement giftcards_btn;

    @FindBy(css = "a[title = 'Cart']")
    static WebElement Cart_btn;

    @FindBy(css = "a[title = 'Dropdown with more help links']")
    static WebElement dropdown_btn;

    @FindBy(css = "a[title = '24x7 Customer Care']")
    static WebElement customercare_btn;

    @FindBy(css = "a[title = 'Download App']")
    static WebElement downloadapp_btn;

    @FindBy(css = "input[title = 'Search for Products, Brands and More']")
    static WebElement search_field;

    @FindBy(css = "button[title = 'Search for Products, Brands and More']")
    static WebElement search_btn;

    @FindBy(css = "button[title = 'Next Slide']")
    public  WebElement next_btn;

    @FindBy(css = "button[title = 'Previous Slide']")
    public  WebElement previous_btn;

    @FindBy(css = "img[alt= 'Grocery']")
    static WebElement grocery_btn;

    @FindBy(css = "img[alt= 'Mobiles']")
    static WebElement mobiles_btn;

    @FindBy(css = "img[alt= 'Fashion']")
    static WebElement fashion_btn;

    @FindBy(css = "img[alt= 'Electronics']")
    static WebElement electronics_btn;

    @FindBy(css = "img[alt= 'Home & Furniture']")
    static WebElement homefurniture_btn;

    @FindBy(css = "img[alt= 'Appliances']")
    static WebElement appliances_btn;

    @FindBy(css = "img[alt= 'Flight Bookings']")
    static WebElement flightbookings_btn;

    @FindBy(css = "img[alt= 'Beauty, Toys & More']")
    static WebElement beautytoysandmore_btn;

    @FindBy(css = "img[alt= 'Two Wheelers']")
    static WebElement twowheelers_btn;

    @FindBy(css = "div._16rZTH a")
    static WebElement fashion_list;

    @FindBy(css = "div._16rZTH a")
    static WebElement electronics_list;



}
