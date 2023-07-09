package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.PropertiesFactory.getProperty;

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
     * constructor WebDriver
     */
    public WebFormPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open Start Url
     */
    public void openUrlPage() {
        driver.get(getProperty("web_form_url"));
    }

    /**
     * Find element LOGO in the page
     */
    public WebElement getLogoButton() {
        return logoButton;
    }

    /***
     *Find element cataloger Sale
     */
    public WebElement getSale() {
        return sale;
    }

    /***
     *Adding a product to the cart
     */
    public WebElement getAddToCart() {
        return addToCart;
    }

    /***
     *Search shoppingCart
     */
    public WebElement getShoppingCart() {
        return shoppingCart;
    }

    /***
     *Removing all items from the cart
     */
    public WebElement getRemoveCart() {
        return removeCart;
    }


    /***
     *Find element Create an Account
     */
    public WebElement getCreateAnAccount() {
        return createAnAccount;
    }
}
