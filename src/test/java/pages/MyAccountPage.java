package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

@Data
@Log4j2
public class MyAccountPage {

    private  final SelenideElement SUCCESS_ALERT = $(By.xpath("//p[@class='alert alert-success']")),
            HOME_BUTTON = $(By.xpath("//a[@title='Home']"));

    @Step("Login page is opened")
    public MyAccountPage isPageOpened() {
        log.info("My account page is opened");
        $(HOME_BUTTON).shouldBe(Condition.visible);
        return this;
    }
}
