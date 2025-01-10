package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


@Log4j2
public class MyAccountPage {

    private final By SUCCESS_REGISTRATION_ALERT = By.xpath("//p[@class='alert alert-success']"),
            WELCOME_ACCOUNT = By.xpath("//p[@class='info-account']"),
            HOME_BUTTON = By.xpath("//a[@title='Home']");

    @Step("My account page is opened")
    public MyAccountPage isPageOpened() {
        log.info("My account page is opened");
        $(HOME_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    @Step("Get the success registration alert")
    public String  getAlert(){
        log.info("Getting the success registration alert");
        String alert = $(SUCCESS_REGISTRATION_ALERT).getText();
        return alert;
    }

    @Step("Get the Welcome text")
    public String getWelcomeText() {
        log.info("Getting the Welcome text");
        String welcomeText = $(WELCOME_ACCOUNT).getText();
        return welcomeText;
    }
}