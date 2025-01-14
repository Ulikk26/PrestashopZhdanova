package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import models.PersonalInformation;
import org.openqa.selenium.By;
import wrappers.Input;
import wrappers.RadioButton;

import static com.codeborne.selenide.Selenide.$;


@Log4j2
public class PersonalInformationPage {

    private static   final By REGISTER_BUTTON = By.xpath("//button[@id='submitAccount']"),
            EMAIL =By.xpath( "//input[@id='email']"),
            CHECKBOX_NEWSLETTERS = By.xpath("//input[@name='newsletter']"),
            CHECKBOX_OFFERS =By.xpath( "//input[@name='optin']");

    MyAccountPage myAccountPage = new MyAccountPage();

    @Step ("Get email from email input")
    public String  getEmail(){
        log.info("Getting the email from email input");
        String email=$(EMAIL).getAttribute("value");
        return email;
    }

    @Step("My Personal Information page is opened")
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
    public PersonalInformationPage clickAgreementNewslettersCheckbox() {
        log.info("Click the newsletters checkbox");
        $(CHECKBOX_NEWSLETTERS).click();
        return this;
    }

    @Step("Click offers checkbox")
    public PersonalInformationPage clickOffersCheckbox() {
        log.info("Click the Offers checkbox");
        $(CHECKBOX_OFFERS).click();
        return this;
    }

    @Step("Click Register button")
    public MyAccountPage clickRegisterButton() {
        log.info("Click the register button");
        $(REGISTER_BUTTON).click();
        return myAccountPage;
    }
}