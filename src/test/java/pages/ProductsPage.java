package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


@Log4j2
public class ProductsPage {

    private final By CATALOG = By.xpath("//p[text()='Catalog']");
    private final String NAME_OF_PRODUCT = "//a[@title='%s']",
            ADD_TO_CART_BUTTON = "//a[contains (text(), '%s')]//ancestor::div[@class='right-block']" +
                    "//span[text()='Add to cart']";

    ProductInformationPage productInformationPage = new ProductInformationPage();

    @Step("Products page is opened")
    public ProductsPage isPageOpened() {
        log.info("Products page is opened");
        $(CATALOG).shouldBe(Condition.visible);
        return this;
    }

    @Step("Click by product")
    public ProductInformationPage clickByProduct(String product) {
        log.info("Click by product");
        $(By.xpath(String.format(NAME_OF_PRODUCT, product))).click();
        return productInformationPage;
    }

    @Step("Hover over by product {product}")
    public ProductsPage hoverOverByProduct(String product) {
        log.info("Hover over by product {}", product);
        $(By.xpath(String.format(NAME_OF_PRODUCT, product))).hover();
        return this;
    }

    @Step("Click the 'Add to cart' product {product}")
    public void clickAddToCart(String product) {
        log.info("Click the 'Aad to cart' product {}", product);
        $(By.xpath(String.format(ADD_TO_CART_BUTTON, product))).click();
    }
}
