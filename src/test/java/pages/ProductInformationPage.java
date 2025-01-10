package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


@Log4j2
public class ProductInformationPage {

    private final By DATA_SHEET = By.xpath("//label[text()='Sort by']"),
            ADD_TO_CART_BUTTON = By.xpath("//button[@name='Submit']");

    @Step("Product Information Page is opened")
    public ProductInformationPage isPageOpened() {
        log.info("Product Information is opened");
        $(DATA_SHEET).shouldBe(Condition.visible);
        return this;
    }

    @Step("Click the 'Add to cart' button")
    public void clickByAddToCart() {
        log.info("Clicking the 'Add to cart' button");
        $(ADD_TO_CART_BUTTON).click();
    }
}
