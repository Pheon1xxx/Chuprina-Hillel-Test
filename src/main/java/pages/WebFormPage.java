package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.PropertiesFactory.getProperty;

/**
 * Class cover {@link WebFormPage}
 * Created by Vladislav
 * 08-07-2023
 */
public class WebFormPage extends BasePage {
    @FindBy(xpath = "//img[@title]")
    private WebElement logoButton;
    @FindBy(xpath = "//*[@id=\"ui-id-8\"]")
    private WebElement sale;
    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    private WebElement addToCart;
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    private WebElement shoppingCart;
    @FindBy(xpath = "//a[@class='action action-delete']")
    private WebElement removeCart;
    @FindBy(xpath = "//header//a[text()='Create an Account']")
    private WebElement createAnAccount;

    /**
     * Constructor WebFormPage
     */
    public WebFormPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigates to web_for_url
     */
    public void openUrlPage() {
        driver.get(getProperty("web_form_url"));
    }

    public WebElement getLogoButton() {
        return logoButton;
    }

    public WebElement getSale() {
        return sale;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }

    public WebElement getShoppingCart() {
        return shoppingCart;
    }

    public WebElement getRemoveCart() {
        return removeCart;
    }

    public WebElement getCreateAnAccount() {
        return createAnAccount;
    }
}
