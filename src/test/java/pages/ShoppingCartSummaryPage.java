package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


@Log4j2
public class ShoppingCartSummaryPage {

    private final By NAME_OF_PAGE = By.xpath("//h1[@id='cart_title']"),
            PRICE_OF_PRODUCT = By.xpath("//span[contains(@id, 'product_price')]/span"),
            LIST_OF_PRODUCT = By.xpath("//tr[contains (@class, 'cart_item')]");
    private final String NAME_OF_PRODUCT = "//tbody//p[@class='product-name']/a[contains(text(), '%s')]";

    @Step("Shopping Cart page is opened")
    public ShoppingCartSummaryPage isPageOpened() {
        log.info("Shopping Cart is opened");
        $(NAME_OF_PAGE).shouldBe(Condition.visible);
        return this;
    }

    @Step("Checking the  product {name} is displayed into cart")
    public boolean checkNameOfProductIntoCart(String name) {
        log.info("Checking the product is displayed into cart");
        return $(By.xpath(String.format(NAME_OF_PRODUCT, name))).isDisplayed();
    }
}