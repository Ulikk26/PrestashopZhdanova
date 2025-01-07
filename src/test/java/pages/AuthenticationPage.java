package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
@Data
public class AuthenticationPage {

    private static final String EMAIL_CREATED_FIELD = "//input[@id='email_create']",
            CREATE_ACCOUNT_BUTTON = "//button[@id='SubmitCreate']",
            FORM_TITLE = "//h3[@class='page-subheading']",
            EMAIL_FIELD = "//input[@id='email']",
            PASSWORD_FIELD = "//input[@id='passwd']",
            SING_IN_BUTTON = "//button[@id='SubmitLogin']",
            ERROR_MASSAGE = "//div[@class='alert alert-danger']//li";

    @Step("Open Authentication page")
    public AuthenticationPage openAuthenticationPage() {
        log.info("Open the authentication page");
        open("authentication");
        return this;
    }

    @Step("Authentication page is opened")
    public AuthenticationPage isPageOpened() {
        log.info("Authentication page is opened");
        $(By.xpath(String.format(CREATE_ACCOUNT_BUTTON))).shouldBe(Condition.visible);
        return this;
    }

    @Step("Enter new email for registration")
    public AuthenticationPage enterNewEmail(String email) {
        log.info("Enter new email for registration");
        $(By.xpath(String.format(EMAIL_CREATED_FIELD))).sendKeys(email);
        return this;
    }

    @Step("Enter email {email} for login")
    public AuthenticationPage enterEmail(String email) {
        log.info("Entering the email for login");
        $(By.xpath(String.format(EMAIL_FIELD))).sendKeys(email);
        return this;
    }

    @Step("Enter password {password} for login")
    public AuthenticationPage enterPassword(String password) {
        log.info("Enter the password for login");
        $(By.xpath(String.format(PASSWORD_FIELD))).sendKeys(password);
        return this;
    }

    @Step("Click create account button")
    public void clickCreateAccountButton() {
        log.info("Click the create account button");
        $(By.xpath(String.format(CREATE_ACCOUNT_BUTTON))).click();
    }

    @Step("Click Sing in button")
    public void clickSingInButton() {
        log.info("Click the create account button");
        $(By.xpath(String.format(SING_IN_BUTTON))).click();
    }

    @Step("Get the form title")
    public WebElement getFormTitle() {
        log.info("Get the name of form");
        WebElement formTitle = $(By.xpath(String.format(FORM_TITLE))).shouldBe(Condition.visible);
        return formTitle;
    }

    @Step("Ger error massage")
    public WebElement getErrorMassage() {
        log.info("Get the error massage");
        WebElement errorMassage = $(By.xpath(String.format(ERROR_MASSAGE))).shouldBe(Condition.visible);
        return errorMassage;
    }
}