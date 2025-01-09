package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


@Log4j2
public class ProductsPage {

    private final By CATALOG = By.xpath("//p(text()='Catalog')");
    private final String NAME_OF_PRODUCT = "//a[@title='%s']";

    @Step("Products page is opened")
    public ProductsPage isPageOpened() {
        log.info("Main page is opened");
        $(CATALOG).shouldBe(Condition.visible);
        return this;
    }

    @Step("Click by product")
    public void clickByProduct(String product) {
        log.info("Click by product");
        $(By.xpath(String.format(NAME_OF_PRODUCT, product))).click();
    }
}
