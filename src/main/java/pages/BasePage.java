package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Class cover {@link BasePage}
 * Base page project
 * Created by Vladislav
 * 08-07-2023
 */
public class BasePage {
    /**
     * Announcement WebDriver
     */
    public WebDriver driver;

    /**
     * Announcement BasePage with parameter WebDriver driver
     */
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
