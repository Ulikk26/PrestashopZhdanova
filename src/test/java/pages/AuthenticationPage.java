package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class AuthenticationPage {

    private final By EMAIL_CREATED_FIELD =By.xpath("//input[@id='email_create']"),
            CREATE_ACCOUNT_BUTTON =By.xpath("//button[@id='SubmitCreate']"),
            FORM_TITLE =By.xpath( "//h3[@class='page-subheading']"),
            EMAIL_FIELD =By.xpath( "//input[@id='email']"),
            PASSWORD_FIELD =By.xpath( "//input[@id='passwd']"),
            SING_IN_BUTTON = By.xpath("//button[@id='SubmitLogin']"),
            ERROR_MASSAGE = By.xpath("//div[@class='alert alert-danger']//li");

    @Step ("Get form title")
    public String  getFormTitle(){
        String title=$(FORM_TITLE).getText();
        return title;
    }

    @Step("Open Authentication page")
    public AuthenticationPage openAuthenticationPage() {
        log.info("Open the authentication page");
        open("authentication");
        return this;
    }

    @Step("Authentication page is opened")
    public AuthenticationPage isPageOpened() {
        log.info("Authentication page is opened");
        $(CREATE_ACCOUNT_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    @Step("Enter new email for registration")
    public AuthenticationPage enterNewEmail(String email) {
        log.info("Enter new email for registration");
        $(EMAIL_CREATED_FIELD).sendKeys(email);
        return this;
    }

    @Step("Enter email {email} for login")
    public AuthenticationPage enterEmail(String email) {
        log.info("Entering the email for login");
        $(EMAIL_FIELD).sendKeys(email);
        return this;
    }

    @Step("Enter password {password} for login")
    public AuthenticationPage enterPassword(String password) {
        log.info("Enter the password for login");
        $(PASSWORD_FIELD).sendKeys(password);
        return this;
    }

    @Step("Click create account button")
    public void clickCreateAccountButton() {
        log.info("Click the create account button");
        $(CREATE_ACCOUNT_BUTTON).click();
    }

    @Step("Click Sing in button")
    public void clickSingInButton() {
        log.info("Click the create account button");
        $(SING_IN_BUTTON).click();
    }

    @Step("Ger error massage")
    public WebElement getErrorMassage() {
        log.info("Get the error massage");
        WebElement errorMassage = $(ERROR_MASSAGE).shouldBe(Condition.visible);
        return errorMassage;
    }
}