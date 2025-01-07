package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import models.PersonalInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.Input;
import wrappers.RadioButton;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class PersonalInformationPage {

    private static final String REGISTER_BUTTON = "//button[@id='submitAccount']",
            EMAIL = "//input[@id='email']",
            CHECKBOX_NEWSLETTERS = "//input[@name='newsletter']",
            CHECKBOX_OFFERS = "//input[@name='optin']";

    @Step("Create account page is opened")
    public PersonalInformationPage isPageOpened() {
        log.info("My Personal Information page is opened");
        $(By.xpath(String.format(REGISTER_BUTTON))).shouldBe(Condition.visible);
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
        $(By.xpath(String.format(CHECKBOX_NEWSLETTERS))).click();
    }

    @Step("Click offers checkbox")
    public void clickOffersCheckbox() {
        log.info("Click the Offers checkbox");
        $(By.xpath(String.format(CHECKBOX_OFFERS))).click();
    }

    @Step("Click Register button ")
    public void clickRegisterButton() {
        log.info("Click the register button");
        $(By.xpath(String.format(REGISTER_BUTTON))).click();
    }

    @Step("Get the email")
    public WebElement getEmail() {
        log.info("Get the email");
        WebElement email = $(By.xpath(String.format(EMAIL))).shouldBe(Condition.visible);
        return email;
    }
}
