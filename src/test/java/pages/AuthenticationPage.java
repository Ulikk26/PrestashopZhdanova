package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class AuthenticationPage {

    private static final By EMAIL_CREATED_FIELD =By.xpath("//input[@id='email_create']"),
            CREATE_ACCOUNT_BUTTON =By.xpath("//button[@id='SubmitCreate']"),
            FORM_TITLE =By.xpath( "//h3[@class='page-subheading']"),
            EMAIL_FIELD =By.xpath( "//input[@id='email']"),
            PASSWORD_FIELD =By.xpath( "//input[@id='passwd']"),
            SIGN_IN_BUTTON = By.xpath("//button[@id='SubmitLogin']"),
            ERROR_MESSAGE = By.xpath("//div[@class='alert alert-danger']//li");

    PersonalInformationPage personalInformationPage = new PersonalInformationPage();

    @Step("Get the form title")
    public String  getFormTitle(){
        log.info("Getting the form title");
        String title=$(FORM_TITLE).getText();
        return title;
    }

    @Step("Sing in button is visible")
    public boolean isSingInVisible() {
        log.info("Sing in button is visible");
        $(SIGN_IN_BUTTON).shouldBe(Condition.visible);
        return true;
    }

    @Step("Open Authentication page")
    public AuthenticationPage openAuthenticationPage() {
        log.info("Opening the authentication page");
        open("authentication");
        return this;
    }

    @Step("Authentication page is opened")
    public AuthenticationPage isPageOpened() {
        log.info("Authentication page is opened");
        $(CREATE_ACCOUNT_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    @Step("Enter a new email {email} for registration")
    public AuthenticationPage enterNewEmail(String email) {
        log.info("Entering a new email {} for registration", email);
        $(EMAIL_CREATED_FIELD).sendKeys(email);
        return this;
    }

    @Step("Enter the email {email} for login")
    public AuthenticationPage enterEmail(String email) {
        log.info("Entering the email {} for login", email);
        $(EMAIL_FIELD).sendKeys(email);
        return this;
    }

    @Step("Enter the password {password} for login")
    public AuthenticationPage enterPassword(String password) {
        log.info("Entering the password {} for login", password);
        $(PASSWORD_FIELD).sendKeys(password);
        return this;
    }

    @Step("Click the 'Create account' button")
    public PersonalInformationPage clickCreateAccountButton() {
        log.info("Clicking the 'Create account' button");
        $(CREATE_ACCOUNT_BUTTON).click();
        return personalInformationPage;
    }

    @Step("Click the 'Sign in' button")
    public AuthenticationPage clickSignInButton() {
        log.info("Clicking the 'Sign in' button");
        $(SIGN_IN_BUTTON).click();
        return this;
    }

    @Step("Ger error message")
    public WebElement getErrorMessage() {
        log.info("Get the error message");
        WebElement errormessage = $(ERROR_MESSAGE).shouldBe(Condition.visible);
        return errormessage;
    }
}