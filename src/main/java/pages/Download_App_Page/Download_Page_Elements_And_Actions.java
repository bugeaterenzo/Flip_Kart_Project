package pages.Download_App_Page;

import enums.WaitStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait_Utils;


public class Download_Page_Elements_And_Actions {

    @FindBy(css = "span._30XB9F")
    WebElement close_btn;

    @FindBy(css = "a._1TOQfO[title='Dropdown with more help links']")
    WebElement more_options_dropdown;

    @FindBy(css = "a[title = 'Download App']")
    WebElement download_app_button;

    WebDriver driver;
    Actions action;

    public Download_Page_Elements_And_Actions(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigate_to_download_page() {

        WebElement visible_Close_Btn = Wait_Utils.wait_for_element(driver, close_btn, WaitStrategy.VISIBLE);
        action.click(visible_Close_Btn).perform();

        WebElement dropdown = Wait_Utils.wait_for_element(driver, more_options_dropdown, WaitStrategy.VISIBLE);
        action.moveToElement(dropdown).perform(); // Hover over the dropdown menu

        WebElement clickableDownloadAppBtn = Wait_Utils.wait_for_element(driver, download_app_button, WaitStrategy.CLICKABLE);
        action.moveToElement(clickableDownloadAppBtn).click().perform(); // Click the Download App button
    }

    public boolean validate_download_page_url() {
        return Wait_Utils.wait_for_url(driver, "https://www.flipkart.com/mobile-apps?otracker=ch_vn_mobile_apps");
    }


}
