package steps;

import io.qameta.allure.Step;
import models.PersonalInformation;
import org.testng.Assert;
import pages.*;


public class CreateAccountSteps {

    MainPage mainPage;
    HeaderUserInfoPage headerUserInfoPage;
    AuthenticationPage authenticationPage;
    PersonalInformationPage personalInformationPage;
    MyAccountPage myAccountPage;

    public CreateAccountSteps() {
        mainPage = new MainPage();
        authenticationPage = new AuthenticationPage();
        personalInformationPage = new PersonalInformationPage();
        myAccountPage = new MyAccountPage();
        headerUserInfoPage = new HeaderUserInfoPage();
    }

    @Step("Open 'CREATE AN ACCOUNT' page")
    public void openCreateAccountPage() {
        mainPage.openMainPage();
        mainPage.isPageOpened();
        headerUserInfoPage.clickLoginButton();
        String expectedName = authenticationPage.getFORM_TITLE().getText();
        Assert.assertEquals(expectedName, "CREATE AN ACCOUNT", "Expected name does not on the page");
    }

    @Step("Open 'YOUR PERSONAL INFORMATION' page")
    public void openPersonalInformationPage(String email) {
        openCreateAccountPage();
        authenticationPage.enterNewEmail(email);
        authenticationPage.clickCreateAccountButton();
        personalInformationPage.isPageOpened();
        String attributeText = personalInformationPage.getEMAIL().getAttribute("value");
        Assert.assertEquals(attributeText, email, "Expected email does not on the page");
    }

    @Step("Create new account")
    public void createNewAccount(String email, PersonalInformation personalInformation) {
        openPersonalInformationPage(email);
        personalInformationPage.createAccount(personalInformation);
        personalInformationPage.clickRegisterButton();
        myAccountPage.isPageOpened();
        String successMassageText = myAccountPage.getSUCCESS_ALERT().getText();
        Assert.assertEquals(successMassageText, "Your account has been created.", "Expected massage does not on the page");
    }
}