package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


@Log4j2
public class ShoppingCartSummaryPage {

    private static final By NAME_OF_PAGE = By.xpath("//h1[@id='cart_title']"),
            LIST_OF_PRODUCTS = By.xpath("//tr[contains (@class, 'cart_item')]");
    private static final String NAME_OF_PRODUCT = "//tbody//p[@class='product-name']/a[contains(text(), '%s')]",
            PRICE_OF_PRODUCT = "//a[contains(text(), 'Blouse')]// ancestor:: tbody//span[contains(@id, 'product_price')]/span";

    @Step("Shopping Cart page is opened")
    public ShoppingCartSummaryPage isPageOpened() {
        log.info("Shopping Cart is opened");
        $(NAME_OF_PAGE).shouldBe(Condition.visible);
        return this;
    }

    @Step("Get the product '{product}' is displayed into cart")
    public String getNameOfProductIntoCart(String product) {
        log.info("Getting  the product {} is displayed into cart", product);
        return $(By.xpath(String.format(NAME_OF_PRODUCT, product))).getText();
    }

    @Step("Get the product price in the cart")
    public String  getPriceOfProductIntoCart(String product) {
        log.info("Getting the product price in the cart");
        return $(By.xpath(String.format(PRICE_OF_PRODUCT,product))).getText();
    }

    @Step("Get count of added products into cart")
    public int checkCountOfProducts() {
        log.info("Getting count products into cart");
        ElementsCollection products = $$(LIST_OF_PRODUCTS);
        return products.size();
    }


}