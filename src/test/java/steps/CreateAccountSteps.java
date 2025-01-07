package steps;

import io.qameta.allure.Step;
import models.PersonalInformation;
import org.testng.Assert;
import pages.AuthenticationPage;
import pages.MainPage;
import pages.MyAccountPage;
import pages.PersonalInformationPage;


public class CreateAccountSteps {

    MainPage mainPage;
    AuthenticationPage authenticationPage;
    PersonalInformationPage personalInformationPage;
    MyAccountPage myAccountPage;

    public CreateAccountSteps() {
        mainPage = new MainPage();
        authenticationPage = new AuthenticationPage();
        personalInformationPage = new PersonalInformationPage();
        myAccountPage = new MyAccountPage();
    }

    @Step("Open 'CREATE AN ACCOUNT' page")
    public void openCreateAccountPage() {
        mainPage.openMainPage();
        mainPage.isPageOpened();
        mainPage.clickLoginButton();
        String expectedName = authenticationPage.getFormTitle().getText();
        Assert.assertEquals(expectedName, "CREATE AN ACCOUNT", "Expected name does not on the page");
    }

    @Step("Open 'YOUR PERSONAL INFORMATION' page")
    public void openPersonalInformationPage(String email) {
        openCreateAccountPage();
        authenticationPage.enterNewEmail(email);
        authenticationPage.clickCreateAccountButton();
        personalInformationPage.isPageOpened();
        String attributeText = personalInformationPage.getEmail().getAttribute("value");
        Assert.assertEquals(attributeText, email, "Expected email does not on the page");
    }

    @Step("Create new account")
    public void createNewAccount(String email, PersonalInformation personalInformation) {
        openPersonalInformationPage(email);
        personalInformationPage.createAccount(personalInformation);
        personalInformationPage.clickRegisterButton();
        myAccountPage.isPageOpened();
        String successMassageText = myAccountPage.geSuccessMassage().getText();
        Assert.assertEquals(successMassageText, "Your account has been created.", "Expected massage does not on the page");
    }
}