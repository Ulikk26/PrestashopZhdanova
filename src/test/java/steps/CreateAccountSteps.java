package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.PersonalInformation;
import org.testng.Assert;
import pages.AuthenticationPage;
import pages.HeaderPage;
import pages.MyAccountPage;
import pages.PersonalInformationPage;

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

    @Step("Open 'CREATE AN ACCOUNT' page")
    public void openCreateAccountPage() {
        log.info("Opening 'CREATE AN ACCOUNT' page");
        headerPage.openHeaderPage();
        headerPage.isPageOpened();
        headerPage.clickLoginButton();
        String expectedName = authenticationPage.getFormTitle();
        Assert.assertEquals(expectedName, "CREATE AN ACCOUNT", "The expected name was not found on the page");
    }

    @Step("Open 'YOUR PERSONAL INFORMATION' page")
    public void openPersonalInformationPage(String email) {
        log.info("Opening 'YOUR PERSONAL INFORMATION' page");
        openCreateAccountPage();
        authenticationPage.enterNewEmail(email);
        authenticationPage.clickCreateAccountButton();
        personalInformationPage.isPageOpened();
        String attributeText = personalInformationPage.getEmail();
        Assert.assertEquals(attributeText, email, "Expected email is not on the page");
    }

    @Step("Create new account")
    public void createNewAccount(String email, PersonalInformation personalInformation) {
        log.info("Creating the new account");
        openPersonalInformationPage(email);
        personalInformationPage.createAccount(personalInformation);
        personalInformationPage.clickRegisterButton();
        myAccountPage.isPageOpened();
        String successmessageText = myAccountPage.getAlert();
        Assert.assertEquals(successmessageText, "Your account has been created.", "Expected message is not on the page");
    }
}