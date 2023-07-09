import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.WebFormLoginData;
import pages.WebFormPage;
import utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class cover {@link Selenium}
 * Test class
 * Created by Vladislav
 * 08-07-2023
 */

public class Selenium {
    WebFormLoginData login = new WebFormLoginData();
    WebDriver driver = WebDriverFactory.browsers.CHROME.create();

    WebFormPage webFormPage;

    @BeforeTest
    /**
     *Open start URL
     */
    public void setUp() {
        webFormPage = new WebFormPage(driver);
        webFormPage.openUrlPage();
    }
    @AfterTest
    /**
     * Off WebDriver
     */
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    /**
     * Testing authorization
     */
    public void logIn() {
        webFormPage = new WebFormPage(driver);
        webFormPage.getLogoButton().click();
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
        driver.findElement(By.id("email")).sendKeys(login.getLogin());
        driver.findElement(By.id("pass")).sendKeys(login.getPassword());
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.xpath("//header//button[@class='action switch']")).click();
        driver.findElement(By.xpath("//header//a[contains(text(),'Sign Out ')]")).click();
        String checkInText = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).getText();
        assertThat(checkInText).isEqualTo("Sign In");
    }

    @Test(priority = 2)
    /**
     * Testing filters
     */
    public void checkingFilters() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5000,
                TimeUnit.MILLISECONDS);
        webFormPage = new WebFormPage(driver);
        webFormPage.getLogoButton().click();
        webFormPage.getSale().click();
        driver.findElement(By.xpath("//a[text()='Hoodies and Sweatshirts']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Size')]")).click();
        driver.findElement(By.xpath("//div[text()='S' and @tabindex='-1']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Color')]")).click();
        driver.findElement(By.xpath("//div[@option-id='60' and @tabindex='-1']")).click();
        String searchText = driver.findElement(By.xpath("//a[contains(text(),'Helena Hooded Fleece')]")).getText();
        assertThat(searchText).isEqualTo("Helena Hooded Fleece");
    }

    @Test(priority = 3)
    /**
     *  Testing add item in shopping cart
     */
    public void addItem() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5000,
                TimeUnit.MILLISECONDS);
        webFormPage = new WebFormPage(driver);
        webFormPage.getLogoButton().click();
        webFormPage.getSale().click();
        driver.findElement(By.xpath("//a[text()='Hoodies and Sweatshirts']")).click();
        driver.findElement(By.xpath("//img[@alt='Circe Hooded Ice Fleece']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-size-143-item-166']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-color-93-item-52']")).click();
        webFormPage.getAddToCart().click();
        String shoppingCart = webFormPage.getShoppingCart().getText();
        assertThat(shoppingCart).isNotEmpty();
    }

    @Test(priority = 4)
    /**
     * Testing remove item in shopping cart
     */
    public void removeItem() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5000,
                TimeUnit.MILLISECONDS);
        webFormPage = new WebFormPage(driver);
        webFormPage.getLogoButton().click();
        webFormPage.getSale().click();
        driver.findElement(By.xpath("//a[text()='Hoodies and Sweatshirts']")).click();
        driver.findElement(By.xpath("//img[@alt='Circe Hooded Ice Fleece']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-size-143-item-166']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-color-93-item-52']")).click();
        webFormPage.getAddToCart().click();
        webFormPage.getShoppingCart().click();
        driver.findElement(By.xpath("//a[@title='Edit item parameters']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-size-143-item-168']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-color-93-item-53']")).click();
        driver.findElement(By.xpath("//input[@id='qty']")).sendKeys("2");
        driver.findElement(By.xpath("//button[@id='product-updatecart-button']")).click();
        webFormPage.getRemoveCart().click();
        String emptyCart = driver.findElement(By.xpath("//div[@class='cart-empty']")).getText();
        assertThat(emptyCart).isEqualTo("You have no items in your shopping cart.\n" + "Click here to continue shopping.");
    }

    @Test(priority = 5)
    /**
     * Testing fields in create an account
     */
    public void fieldValidationCreateAnAccount() {
        webFormPage = new WebFormPage(driver);
        webFormPage.getLogoButton().click();
        webFormPage.getCreateAnAccount().click();
        driver.findElement(By.id("firstname")).sendKeys("Test");
        String firstName = driver.findElement(By.id("firstname")).getText();
        driver.findElement(By.id("lastname")).sendKeys("Testing");
        String lastName = driver.findElement(By.id("lastname")).getText();
        driver.findElement(By.id("email_address")).sendKeys(login.getLogin());
        String emailAddress = driver.findElement(By.id("email_address")).getText();
        driver.findElement(By.id("password")).sendKeys(login.getPassword());
        String password = driver.findElement(By.id("password")).getText();
        driver.findElement(By.id("password-confirmation")).sendKeys(login.getPassword());
        String passwordConfirmation = driver.findElement(By.id("password-confirmation")).getText();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(emailAddress).isNotNull();
        assertThat(password).isNotNull();
        assertThat(passwordConfirmation).isNotNull();
    }
}
