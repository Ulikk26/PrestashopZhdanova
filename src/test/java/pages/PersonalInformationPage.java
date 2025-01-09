package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import models.PersonalInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.Input;
import wrappers.RadioButton;

import static com.codeborne.selenide.Selenide.$;


@Log4j2
public class PersonalInformationPage {

    private  final By REGISTER_BUTTON = By.xpath("//button[@id='submitAccount']"),
            EMAIL =By.xpath( "//input[@id='email']"),
            CHECKBOX_NEWSLETTERS = By.xpath("//input[@name='newsletter']"),
            CHECKBOX_OFFERS =By.xpath( "//input[@name='optin']");

    @Step ("Get email from email input")
    public String  getEmail(){
        String email=$(EMAIL).getAttribute("value");
        return email;
    }

    @Step("Create account page is opened")
    public PersonalInformationPage isPageOpened() {
        log.info("My Personal Information page is opened");
        $(REGISTER_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    @Builder
    @Step("Creating new account")
    public PersonalInformationPage createAccount(PersonalInformation personalInformation) {
        log.info("Create the new account");
        if (personalInformation.getTitle() != null) {
            new RadioButton("Title ").select(personalInformation.getTitle());
        }
        if (personalInformation.getFirstName() != null) {
            new Input("First name ").write(personalInformation.getFirstName());
        }
        if (personalInformation.getLastName() != null) {
            new Input("Last name ").write(personalInformation.getLastName());
        }
        if (personalInformation.getPassword() != null) {
            new Input("Password ").write(personalInformation.getPassword());
        }
        return this;
    }

    @Step("Click newsletter checkbox")
    public void clickAgreementNewslettersCheckbox() {
        log.info("Click the newsletters checkbox");
        $(CHECKBOX_NEWSLETTERS).click();
    }

    @Step("Click offers checkbox")
    public void clickOffersCheckbox() {
        log.info("Click the Offers checkbox");
        $(CHECKBOX_OFFERS).click();
    }

    @Step("Click Register button")
    public void clickRegisterButton() {
        log.info("Click the register button");
        $(REGISTER_BUTTON).click();
    }
}
