package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.PersonalInformation;
import pages.AuthenticationPage;
import pages.HeaderPage;
import pages.MyAccountPage;
import pages.PersonalInformationPage;

import static org.testng.Assert.assertEquals;

@Log4j2
public class CreateAccountSteps {

    HeaderPage headerPage;
    AuthenticationPage authenticationPage;
    PersonalInformationPage personalInformationPage;
    MyAccountPage myAccountPage;

    public CreateAccountSteps() {
        authenticationPage = new AuthenticationPage();
        personalInformationPage = new PersonalInformationPage();
        myAccountPage = new MyAccountPage();
        headerPage = new HeaderPage();
    }

    @Step("Open 'Authentication' page")
    public void openAuthenticationPage() {
        log.info("Opening 'Create an account' page");
        headerPage.openHeaderPage()
                .isPageOpened()
                .clickLoginButton()
                .isPageOpened();
    }

    @Step("Open 'Your personal information' page")
    public void openPersonalInformationPage(String email) {
        log.info("Opening 'Your personal information' page");
        authenticationPage.enterNewEmail(email)
                .clickCreateAccountButton()
                .isPageOpened();
    }

    @Step("Open new 'My account page'")
    public void openNewMyAccountPage(PersonalInformation personalInformation) {
        log.info("Opening new 'My account page'");
        personalInformationPage.createAccount(personalInformation)
                .clickRegisterButton()
                .isPageOpened();
    }
}