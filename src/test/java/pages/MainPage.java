package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class MainPage {
    private static final String LOGIN_BUTTON = "[class=login]",
            SLIDER_ROW = "//div[@id='slider_row']";

    AuthenticationPage authenticationPage = new AuthenticationPage();

    @Step("Open main page")
    public MainPage openMainPage() {
        log.info("Open the main page");
        open("http://prestashop.qatestlab.com.ua/ru/");
        return this;
    }

    @Step("Main page is opened")
    public MainPage isPageOpened() {
        log.info("Main page is opened");
        $(By.xpath(String.format(SLIDER_ROW))).shouldBe(Condition.visible);
        return this;
    }

    @Step("Click login button")
    public AuthenticationPage clickLoginButton() {
        log.info("Click the login button");
        $(By.cssSelector(LOGIN_BUTTON)).click();
        return authenticationPage;
    }
}
