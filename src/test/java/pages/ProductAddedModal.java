package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


@Log4j2
public class ProductAddedModal {

    private final By MESSAGE = By.xpath("//i[@class='icon-ok']//ancestor:: h2"),
            CLOSE_BUTTON = By.xpath("//span[@class='cross']"),
            PROCEED_TO_CHECKOUT = By.xpath("//a[@title='Proceed to checkout']");

    ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage();
    ProductsPage productsPage = new ProductsPage();

    @Step("ProductAddedModal is opened")
    public ProductAddedModal isPageOpened() {
        log.info("ProductAddedModal page is opened");
        $(MESSAGE).shouldBe(Condition.visible);
        return this;
    }

    @Step("Click the 'Proceed to checkout' button")
    public ShoppingCartSummaryPage clickByProceedToCheckout() {
        log.info("Clicking the 'Proceed to checkout' button");
        $(PROCEED_TO_CHECKOUT).click();
        return shoppingCartSummaryPage;
    }

    @Step("Get the success message that product is added to cart")
    public String getMessage() {
        log.info("Getting the success message that product is added to cart");
        String message = $(MESSAGE).getText();
        return message;
    }

    @Step("Click the close button")
    public ProductsPage clickCloseButton() {
        $(CLOSE_BUTTON).click();
        return productsPage;
    }
}