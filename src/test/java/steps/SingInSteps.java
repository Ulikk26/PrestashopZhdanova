package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AuthenticationPage;
import pages.HeaderUserInfoPage;
import pages.MyAccountPage;

public class SingInSteps {
    HeaderUserInfoPage headerUserInfoPage;
    AuthenticationPage authenticationPage;
    MyAccountPage myAccountPage;

    public SingInSteps() {
        headerUserInfoPage = new HeaderUserInfoPage();
        authenticationPage = new AuthenticationPage();
        myAccountPage = new MyAccountPage();
    }

    @Step("Success Login")
    public void login(String email, String password) {
        authenticationPage.openAuthenticationPage();
        authenticationPage.isPageOpened();
        authenticationPage.enterEmail(email);
        authenticationPage.enterPassword(password);
        authenticationPage.clickSingInButton();
        myAccountPage.isPageOpened();
    }

    @Step("Getting error massage when login")
    public void errorLoginMassage(String email, String password) {
        authenticationPage.openAuthenticationPage();
        authenticationPage.isPageOpened();
        authenticationPage.enterEmail(email);
        authenticationPage.enterPassword(password);
        authenticationPage.clickSingInButton();
        String errorText = authenticationPage.getErrorMassage().getText();
        Assert.assertEquals(errorText, "Authentication failed.", " Expected error massage does not on the page ");
    }

    @Step("Logout from account")
    public void logoutFromAccount(String email, String password){
        login(email,password);
        headerUserInfoPage.clickLogoutButton();
        Boolean loginButton=headerUserInfoPage.getLOGOUT_BUTTON().isDisplayed();
        Assert.assertTrue(loginButton,"Logout button does not displayed");
    }
}