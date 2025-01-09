package pages;

import com.codeborne.selenide.Condition;
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
    private final String CATEGORY_BUTTON = "//a[@title='%S']";

    AuthenticationPage authenticationPage = new AuthenticationPage();
    MyAccountPage myAccountPage =new MyAccountPage();
    ProductsPage productsPage = new ProductsPage();

    @Step("Open HeaderUserInfoPage page")
    public HeaderPage openHeaderPage() {
        log.info("Open the HeaderUserInfoPage");
        open("http://prestashop.qatestlab.com.ua/ru/");
        return this;
    }

    @Step ("Logout button is displayed")
    public void  logoutButtonIsDisplayed(){
        log.info("Logout button is displayed");
        $(LOGOUT_BUTTON).isDisplayed();
    }

    @Step("Header User Info is opened")
    public HeaderPage isPageOpened() {
        log.info("Main page is opened");
        $(HEADER_USER_INFO).shouldBe(Condition.visible);
        return this;
    }

    @Step("Click login button")
    public MyAccountPage clickLoginButton() {
        log.info("Click the login button");
        $(LOGIN_BUTTON).click();
        return myAccountPage;
    }

    @Step("Click logout button")
    public AuthenticationPage clickLogoutButton() {
        log.info("Click the logout button");
        $(LOGOUT_BUTTON).click();
        return authenticationPage;
    }

    @Step("Click category {} button")
    public ProductsPage clickCategory(String category) {
        log.info("Click category button: {}", category);
        $(By.xpath(String.format(CATEGORY_BUTTON, category))).click();
        return productsPage;
    }
}
