package pages.Cart_Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart_Page_Elements {

    @FindBy(xpath = "//div[contains(text(), 'Missing Cart items?')]")
    WebElement cart_page_title;

}
