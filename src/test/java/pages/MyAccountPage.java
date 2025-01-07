package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class MyAccountPage {

    private static final String SUCCESS_ALERT = "//p[@class='alert alert-success']",
            HOME_BUTTON = "//a[@title='Home']";

    @Step("Login page is opened")
    public MyAccountPage isPageOpened() {
        log.info("My account page is opened");
        $(By.xpath(String.format(HOME_BUTTON))).shouldBe(Condition.visible);
        return this;
    }

    @Step("Get the success massage")
    public WebElement geSuccessMassage() {
        log.info("Get the massage about success registration");
        WebElement successMassage = $(By.xpath(String.format(SUCCESS_ALERT))).shouldBe(Condition.visible);
        return successMassage;
    }
}
