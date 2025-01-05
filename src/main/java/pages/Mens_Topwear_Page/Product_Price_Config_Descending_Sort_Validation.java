package pages.Mens_Topwear_Page;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.FlipKart_Home_Page.FlipKart_Home_Page_Elements;
import utils.Wait_Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Product_Price_Config_Descending_Sort_Validation {

    @FindBy(css = "span._30XB9F")
    WebElement close_btn;

    @FindBy(xpath = "//h1[text()='Topwear']")
    WebElement Top_wear_title;

    @FindBy(xpath = "//div[text()='Price -- High to Low']")
    WebElement Price_High_to_Low;

    @FindBy(css = "img[alt= 'Fashion']")
    static WebElement fashion_btn;

    @FindBy(xpath = "//a[contains(text(), 'Top Wear')]")
    static WebElement mens_top_wear_btn;



    List<WebElement> Prices;
    List<Integer> prices;



    WebDriver driver;
    Actions action;
    FlipKart_Home_Page_Elements home;


    public Product_Price_Config_Descending_Sort_Validation(WebDriver driver)
    {
        this.driver = driver;
        this.action = new Actions(driver);
        this.home = new FlipKart_Home_Page_Elements(driver);
        this.prices = new LinkedList<>();
        this.Prices = new LinkedList<>();
        PageFactory.initElements(driver, this);
    }



    public void click_Price_High_to_Low()
    {
        WebElement clickable_Price_High_to_Low = Wait_Utils.wait_for_element(driver, Price_High_to_Low, WaitStrategy.CLICKABLE);
        Wait_Utils.global_thread_pause(4);
        action.moveToElement(clickable_Price_High_to_Low).click().perform();
        Wait_Utils.global_thread_pause(10);
    }

    public boolean validate_descending_price_list()
    {

        // Clear existing lists
        Prices.clear();
        prices.clear();

        Wait_Utils.wait_for_element(driver, Top_wear_title, WaitStrategy.VISIBLE);


//        List<WebElement> divs = driver.findElements(
//                By.cssSelector("div.cPHDOP.col-12-12:not(:has(div._1G0WLw))" +
//                        ":not([style='padding: 0px 0px 10px;'])" +
//                        ":not([style='margin: 10px 0px 0px;'])" +
//                        ":not(:has(div._0BvurA))"));

        // Get all rows with the class `cPHDOP and col-12-12`

        List<WebElement> divs = driver.findElements(By.cssSelector("div.cPHDOP.col-12-12"));

        // Filter out rows that contain unwanted divs
        List<WebElement> validDivs = new ArrayList<>();

        for (WebElement Div : divs)
        {

            WebElement div = Wait_Utils.wait_for_element(driver, Div, WaitStrategy.VISIBLE);

            // Exclude divs that contain class `_0BvurA`
            if (div.getAttribute("class").contains("_0BvurA"))
            {
                continue;
            }

            // Exclude divs that have specific inline style `padding: 0px 0px 10px;`
            String styleAttribute = div.getAttribute("style");
            if (styleAttribute != null && styleAttribute.contains("padding: 0px 0px 10px;"))
            {
                continue;
            }


            // Exclude divs that contain class `_1G0WLw`
            if (!div.findElements(By.cssSelector("div._1G0WLw")).isEmpty())
            {
                continue;
            }

            // Exclude divs that have style `margin: 10px 0px 0px;`
            String StyleAttribute = div.getAttribute("style");

            if (StyleAttribute != null && StyleAttribute.contains("margin: 10px 0px 0px;"))
            {
                continue;
            }

            validDivs.add(div);
        }

        int valid_divs = validDivs.size();


        for (int i = 2; i <= (valid_divs); i++)
        {
            for (int x = 1; x <= 4; x++)
            {
                String dynamic_css = "div.cPHDOP.col-12-12:nth-of-type(" + i + ") div._75nlfW > div:nth-of-type("
                        + x + ") > div > div > a:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1)";

                Prices.addAll(driver.findElements(By.cssSelector(dynamic_css)));
            }
        }

        for (WebElement price_tag : Prices)
        {
            try
            {
                String string_price = price_tag.getText()
                        .replace("₹", "")
                        .replace(",", "")
                        .trim();

                prices.add(Integer.parseInt(string_price));
            }
            catch (NumberFormatException e)
            {
                System.out.println("Price: Not Available");
                prices.add(0);
            }
        }


        boolean result = false;

        for (int i = 0; i < prices.size() - 1; i++)
        {
            if (  prices.get(i) == 0 || prices.get(i + 1) == 0 )
            {
                System.out.println("Zero Value Found at index: " + i);
                System.out.println("Can Not Compare Unfetched or Empty Values!");
            }
            else if ( prices.get(i) > prices.get(i + 1) || prices.get(i) == prices.get(i + 1) )
            {
                result = true;
            }

        }

        int index;
        int row_id = 1;
        int value_index = 0;
        int end_index = 3;

        for (int i = 0; i < (valid_divs); i++)
        {
            System.out.println();
            System.out.print(String.format("%-4s", row_id));
            System.out.print(String.format("%-3s", "-"));
            for (index = 1; index <= 4; index++)
            {
                if(value_index < prices.size())
                {
                    int row_element = prices.get(value_index);
                    System.out.print(String.format("%-8s", "₹" + row_element));
                    value_index++;
                }
            }
            row_id++;
        }


        if (result)
        {
            System.out.println("\nPrice list is sorted in descending order.");
        }

        return result;
    }



// div.cPHDOP.col-12-12 div[style="width: 25%;"]

// div.cPHDOP.col-12-12:nth-of-type(11) div._75nlfW > div:nth-of-type(2) > div > div > a:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1)
// > span

//  div.cPHDOP:nth-of-type(11) div._75nlfW > div:nth-of-type(1) > div > div > a:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1)

// div.cPHDOP:nth-of-type(variable) div._75nlfW > div:nth-of-type(variable) > div > div > a:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1)

}
