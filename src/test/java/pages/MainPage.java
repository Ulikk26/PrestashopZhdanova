package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class MainPage {

    private  final SelenideElement SLIDER_ROW = $(By.xpath("//div[@id='slider_row']"));

    @Step("Open main page")
    public MainPage openMainPage() {
        log.info("Open the main page");
        open("http://prestashop.qatestlab.com.ua/ru/");
        return this;
    }

    @Step("Main page is opened")
    public MainPage isPageOpened() {
        log.info("Main page is opened");
        $(SLIDER_ROW).shouldBe(Condition.visible);
        return this;
    }
}
