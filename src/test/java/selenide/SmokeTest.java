package selenide;

import com.codeborne.selenide.Condition;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;

public class smokeTest {
    String screenshot;
    @Test
    public void step01LogoTest() {
        open("https://magento.softwaretestingboard.com");
        $(".header.content img").click();
        $(".header.content img").should(visible);
    }
    @Test
    public void step02Validation() {
        open("https://magento.softwaretestingboard.com");
        $(".wrapper li.authorization-link").click();
        $("#email").setValue("testingtesttestng@gmail.com")
                .shouldBe(Condition.value("testingtesttestng@gmail.com"));
        $("#pass").setValue("testNGtest1996")
                .shouldBe(Condition.value("testNGtest1996"));
        screenshot = screenshot("logIn");
    }
    @Test
    public void step03Authorization() {
        open("https://magento.softwaretestingboard.com");
        $(".wrapper li.authorization-link").click();
        $("#email").setValue("testingtesttestng@gmail.com")
                .shouldBe(Condition.value("testingtesttestng@gmail.com"));
        $("#pass").setValue("testNGtest1996")
                .shouldBe(Condition.value("testNGtest1996"));
        $("#send2 > span").click();
        open("https://magento.softwaretestingboard.com/customer/account/");
        $(" div.panel.wrapper button").click();
        $(".active li.authorization-link").click();
        screenshot = screenshot("logOut");
        $(".header.content img").click();
        $(".header.content img").should(visible);

    }
    @Test
    public void step04Buying() {
        open("https://magento.softwaretestingboard.com");
        $("#ui-id-8").click();
        $("#ui-id-8").should(visible);
        $("div >ul:nth-child(2) li:nth-child(1) a").click();
        $("li:nth-child(1) img").click();
        $("#option-label-size-143-item-166").click();
        $("#option-label-size-143-item-166").should(visible);
        $("#option-label-color-93-item-52").click();
        $("#option-label-color-93-item-52").should(visible);
        $("#product-addtocart-button").click();
        $("#product-addtocart-button").should(visible);
        screenshot = screenshot("buying");
    }
    @Test
    public void step05ShoppingCart() {
        open("https://magento.softwaretestingboard.com");
        $("#ui-id-8").click();
        $("#ui-id-8").should(visible);
        $("div >ul:nth-child(2) li:nth-child(1) a").click();
        $("li:nth-child(1) img").click();
        $("#option-label-size-143-item-166").click();
        $("#option-label-size-143-item-166").should(visible);
        $("#option-label-color-93-item-52").click();
        $("#option-label-color-93-item-52").should(visible);
        $("#product-addtocart-button").click();
        $("#product-addtocart-button").should(visible);
        $("div:nth-child(2) > div > div > div > a").click();
        screenshot = screenshot("shoppingCart");
        $(".header.content img").click();
        $(".header.content img").should(visible);
    }
    @Test
    public void step06ChangeOrder() {
        open("https://magento.softwaretestingboard.com");
        $("#ui-id-8").click();
        $("#ui-id-8").should(visible);
        $("div >ul:nth-child(2) li:nth-child(1) a").click();
        $("li:nth-child(1) img").click();
        $("#option-label-size-143-item-166").click();
        $("#option-label-size-143-item-166").should(visible);
        $("#option-label-color-93-item-52").click();
        $("#option-label-color-93-item-52").should(visible);
        $("#product-addtocart-button").click();
        $("#product-addtocart-button").should(visible);
        $(".messages div:nth-child(2)").click();
        $("div:nth-child(2) > div > div > div > a").click();
        $("a.action.action-edit").click();
        $("#option-label-color-93-item-53").click();
        $("#option-label-size-143-item-168").click();
        $("#product-updatecart-button").click();
        screenshot = screenshot("change");
    }
    @Test
    public void step07RemoveShoppingCart() {
        $("#ui-id-8").click();
        $("#ui-id-8").should(visible);
        $("div >ul:nth-child(2) li:nth-child(1) a").click();
        $("li:nth-child(1) img").click();
        $("#option-label-size-143-item-166").click();
        $("#option-label-size-143-item-166").should(visible);
        $("#option-label-color-93-item-52").click();
        $("#option-label-color-93-item-52").should(visible);
        $("#product-addtocart-button").click();
        $("#product-addtocart-button").should(visible);
        $(".messages div:nth-child(2)").click();

        $("div:nth-child(2) > div > div > div > a").click();

        $(" a.action.action-delete").click();
        screenshot = screenshot("delete");
    }
    @Test
    public void step08Subscribe() {
    open("https://magento.softwaretestingboard.com");
    $(" #newsletter").click();
    $("#newsletter").setValue("test111@gmail.com")
                .shouldBe(Condition.value("test111@gmail.com"));
        $("#newsletter-validate-detail > div.actions > button > span").click();
        screenshot = screenshot("send");
    }
}
