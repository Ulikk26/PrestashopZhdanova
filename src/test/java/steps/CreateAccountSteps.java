package steps;

import io.qameta.allure.Step;
import models.PersonalInformation;
import org.testng.Assert;
import pages.*;


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
        headerPage.openHeaderPage();
        headerPage.isPageOpened();
        headerPage.clickLoginButton();
        String expectedName = authenticationPage.getFormTitle();
        Assert.assertEquals(expectedName, "CREATE AN ACCOUNT", "Expected name does not on the page");
    }

    @Step("Open 'YOUR PERSONAL INFORMATION' page")
    public void openPersonalInformationPage(String email) {
        openCreateAccountPage();
        authenticationPage.enterNewEmail(email);
        authenticationPage.clickCreateAccountButton();
        personalInformationPage.isPageOpened();
        String attributeText = personalInformationPage.getEmail();
        Assert.assertEquals(attributeText, email, "Expected email does not on the page");
    }

    @Step("Create new account")
    public void createNewAccount(String email, PersonalInformation personalInformation) {
        openPersonalInformationPage(email);
        personalInformationPage.createAccount(personalInformation);
        personalInformationPage.clickRegisterButton();
        myAccountPage.isPageOpened();
        String successMassageText = myAccountPage.getAlert();
        Assert.assertEquals(successMassageText, "Your account has been created.", "Expected massage does not on the page");
    }
}