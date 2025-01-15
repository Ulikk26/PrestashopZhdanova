package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


@Log4j2
public class HeaderPage {

    private final By LOGIN_BUTTON = By.cssSelector("[class=login]"),
            LOGOUT_BUTTON = By.cssSelector("[class=logout]"),
            HEADER_USER_INFO = By.cssSelector("[class=header_user_info]");
    private final String CATEGORY_BUTTON = "//a[@title='%s']";

    AuthenticationPage authenticationPage = new AuthenticationPage();
    ProductsPage productsPage = new ProductsPage();

    @Step("Open the Header page")
    public HeaderPage openHeaderPage() {
        log.info("Open the Header page");
        open(Configuration.baseUrl);
        return this;
    }

    @Step("Header page is opened")
    public HeaderPage isPageOpened() {
        log.info("Header page is opened");
        $(HEADER_USER_INFO).shouldBe(Condition.visible);
        return this;
    }

    @Step("Click the 'Login' button")
    public AuthenticationPage clickLoginButton() {
        log.info("Click the 'Login' button");
        $(LOGIN_BUTTON).click();
        return authenticationPage;
    }

    @Step("Click the 'Logout' button")
    public AuthenticationPage clickLogoutButton() {
        log.info("Click the 'Logout' button");
        $(LOGOUT_BUTTON).click();
        return authenticationPage;
    }

    @Step("Click category {category} button")
    public ProductsPage clickCategory(String category) {
        log.info("Click category button: {}", category);
        $(By.xpath(String.format(CATEGORY_BUTTON, category))).click();
        return productsPage;
    }
}
