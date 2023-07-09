package cucumber;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.WebFormPage;
import utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;


public class StepDefinitions {
    WebDriver driver = WebDriverFactory.browsers.CHROME.create();
    WebFormPage webFormPage = new WebFormPage(driver);
    @After
    public void tearDown() {
        driver.quit();
    }


    @Given("user open home page")
    public void userOpenHomePage() {
        webFormPage.openUrlPage();
    }
    @When("user click catalog Women")
    public void userClickCatalogWomen() {
        driver.manage().timeouts().implicitlyWait(5000,
                TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]")).click();
    }
    @And("user click button logo")
    public void userClickButtonLogo() {
        driver.findElement(By.xpath("//img[@title]")).click();
    }
    @Then("site reload")
    public void siteReload() {
        String url = driver.getCurrentUrl();
        assertThat(url).isEqualTo("https://magento.softwaretestingboard.com/");
        driver.quit();
    }


    @Given("user open Sign In page")
    public void userOpenSignInPage() {
        webFormPage.openUrlPage();
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
    }
    @When("user insert {} and {}")
    public void userInsertLoginAndPassword(String login, String password) {
        driver.findElement(By.id("email")).sendKeys(login);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("send2")).click();
    }
    @Then("open account page")
    public void openAccountPage() {
        driver.findElement(By.xpath("//header//button[@class='action switch']")).click();
        driver.findElement(By.xpath("//header//a[text()='My Account']")).click();
        String account = driver.findElement(By.xpath("//strong[text()='Account Information']")).getText();
        assertThat(account).isEqualTo("Account Information");
    }


    @Given("user open Sale page")
    public void userOpenSalePage() {
        driver.manage().timeouts().implicitlyWait(5000,
                TimeUnit.MILLISECONDS);
        webFormPage.openUrlPage();
        webFormPage.getSale().click();
    }
    @When("user click catalog Hoodies and Sweatshirts")
    public void userClickCatalogHoodiesAndSweatshirts() {
        driver.findElement(By.xpath("//a[text()='Hoodies and Sweatshirts']")).click();
    }
    @And("user click item")
    public void userClickItem() {
        driver.findElement(By.xpath("//img[@alt='Circe Hooded Ice Fleece']")).click();
    }
    @And("user chooses size and color")
    public void userChoosesSizeAndColor() {
        driver.findElement(By.xpath("//div[@id='option-label-size-143-item-166']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-color-93-item-52']")).click();
    }
    @And("user add item in shopping cart")
    public void userAddItemInShoppingCart() {
        webFormPage.getAddToCart().click();
    }
    @Then("the line to go to the shopping cart appears")
    public void theLineToGoToTheShoppingCartAppears() {
        String shoppingCart = webFormPage.getShoppingCart().getText();
        assertThat(shoppingCart).isNotEmpty();
    }


    @Given("user open catalog Sale")
    public void userOpenCatalogSale() {
        driver.manage().timeouts().implicitlyWait(5000,
                TimeUnit.MILLISECONDS);
        webFormPage.openUrlPage();
        webFormPage.getSale().click();
    }
    @When("user click catalog Jackets")
    public void userClickCatalogJackets() {
        driver.findElement(By.xpath("//a[text()='Jackets']")).click();
    }
    @And("user click item Olivia")
    public void userClickItemOlivia() {
        driver.findElement(By.xpath("//a[contains(text(),'Olivia 1/4 Zip Light Jacket')]")).click();
    }
    @And("user chooses size&color")
    public void userChoosesSizeColor() {
        driver.findElement(By.xpath("//div[@id='option-label-size-143-item-166']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-color-93-item-49']")).click();
    }
    @And("user add item")
    public void userAddItem() {
        webFormPage.getAddToCart().click();
    }
    @And("user open shopping cart")
    public void userOpenShoppingCart() {
        webFormPage.getShoppingCart().click();
    }
    @And("user click remove shopping cart")
    public void userClickRemoveShoppingCart() {
        webFormPage.getRemoveCart().click();
    }
    @Then("shopping cart clean")
    public void shoppingCartClean() {
        String emptyCart = driver.findElement(By.xpath("//div[@class='cart-empty']")).getText();
        assertThat(emptyCart).isEqualTo("You have no items in your shopping cart.\n" + "Click here to continue shopping.");
    }


    @Given("user open page CreateAnAccount")
    public void userOpenPageCreateAnAccount() {
        webFormPage.openUrlPage();
        webFormPage.getCreateAnAccount().click();
    }
    @When("user insert first name {}")
    public void userInsertFirstName(String FirstName) {
        driver.findElement(By.id("firstname")).sendKeys(FirstName);
    }
    @And("user insert  last name {}")
    public void userInsertLastName(String LastName) {
        driver.findElement(By.id("lastname")).sendKeys(LastName);
    }
    @And("user insert email {}")
    public void userInsertEmailAddress(String EmailAddress) {
        driver.findElement(By.id("email_address")).sendKeys(EmailAddress);
    }
    @And("user insert pass {}")
    public void userInsertPassword(String Password) {
        driver.findElement(By.id("password")).sendKeys(Password);
    }
    @And("user insert passConfirm {}")
    public void userInsertPasswordConfirm(String PasswordConfirm) {
        driver.findElement(By.id("password-confirmation")).sendKeys(PasswordConfirm);
    }
    @Then("fields must contain values")
    public void fieldsMustContainValues() {
        String firstName = driver.findElement(By.id("firstname")).getText();
        String lastName = driver.findElement(By.id("lastname")).getText();
        String emailAddress = driver.findElement(By.id("email_address")).getText();
        String password = driver.findElement(By.id("password")).getText();
        String passwordConfirmation = driver.findElement(By.id("password-confirmation")).getText();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(emailAddress).isNotNull();
        assertThat(password).isNotNull();
        assertThat(passwordConfirmation).isNotNull();
    }


    @Given("user open SignIn page")
    public void userOpenSignPage() {
        webFormPage.openUrlPage();
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
    }
    @When("user inserts {} and {}")
    public void userInsertsLoginAndPass(String Login, String Pass) {
        driver.findElement(By.id("email")).sendKeys(Login);
        driver.findElement(By.id("pass")).sendKeys(Pass);
        driver.findElement(By.id("send2")).click();
    }

    @And("user click catalog Sale")
    public void userClickCatalogSale() {
        driver.manage().timeouts().implicitlyWait(5000,
                TimeUnit.MILLISECONDS);
        webFormPage.openUrlPage();
        webFormPage.getSale().click();
    }
    @And("user click catalog Tees")
    public void userClickCatalogTees() {
        driver.findElement(By.xpath("//a[text()='Tees']")).click();
    }
    @And("user click Desiree Fitness Tee")
    public void userClickDesireeFitnessTee() {
        driver.findElement(By.xpath("//a[contains(text(),'Desiree Fitness Tee ')]")).click();
    }
    @And("user click ADD TO WISH LIST")
    public void userClickADDTOWISHLIST() {
        driver.findElement(By.xpath("//span[contains(text(),'Add to Wish List')]")).click();
    }
    @Then("open page My Wish List")
    public void openPageMyWishList() {
        String wishList = driver.findElement(By.xpath("//span[contains(text(),'My Wish List')]")).getText();
        assertThat(wishList).isEqualTo("My Wish List");
    }
}

