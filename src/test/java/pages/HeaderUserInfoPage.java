package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Data
@Log4j2
public class HeaderUserInfoPage {

    private final SelenideElement LOGIN_BUTTON = $("[class=login]"),
            LOGOUT_BUTTON = $("[class=logout]"),
            HEADER_USER_INFO = $("[class=header_user_info]");

    AuthenticationPage authenticationPage = new AuthenticationPage();
    MyAccountPage myAccountPage =new MyAccountPage();

    @Step("Header User Info is opened")
    public HeaderUserInfoPage isPageOpened() {
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
}
