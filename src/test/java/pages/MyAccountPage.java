package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


@Log4j2
public class MyAccountPage {

    private final By SUCCESS_ALERT = By.xpath("//p[@class='alert alert-success']"),
            HOME_BUTTON = By.xpath("//a[@title='Home']");

    @Step("My account page is opened")
    public MyAccountPage isPageOpened() {
        log.info("My account page is opened");
        $(HOME_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    @Step ("Getting the alert")
    public String  getAlert(){
        log.info("Getting the alert");
        String alert=$(SUCCESS_ALERT).getText();
        return alert;
    }
}