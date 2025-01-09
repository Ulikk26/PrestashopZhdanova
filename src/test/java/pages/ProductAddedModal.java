package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


@Log4j2
public class ProductAddedModal {

    private final By MESSAGE = By.xpath("//i[@class='icon-ok']//ancestor:: h2"),
            PROCEED_TO_CHECKOUT = By.xpath("//a[@title='Proceed to checkout']");

    @Step("ProductAddedModal is opened")
    public ProductAddedModal isPageOpened() {
        log.info("ProductAddedModal page is opened");
        $(MESSAGE).shouldBe(Condition.visible);
        return this;
    }

    @Step("Click by proceed to checkout")
    public void clickByProceedToCheckout() {
        log.info("Click by Proceed to checkout");
        $(PROCEED_TO_CHECKOUT).click();
    }

    @Step("Getting success message")
    public String getmessage() {
        log.info("Getting the success message that product is added to cart");
        String message = $(MESSAGE).getText();
        return message;
    }
}