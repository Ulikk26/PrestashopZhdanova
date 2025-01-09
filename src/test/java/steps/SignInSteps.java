package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import pages.AuthenticationPage;
import pages.HeaderPage;
import pages.MyAccountPage;

@Log4j2
public class SignInSteps {
    HeaderPage headerPage;
    AuthenticationPage authenticationPage;
    MyAccountPage myAccountPage;

    public SignInSteps() {
        headerPage = new HeaderPage();
        authenticationPage = new AuthenticationPage();
        myAccountPage = new MyAccountPage();
    }

    @Step("Success Login with email {0} and password {1}")
    public void login(String email, String password) {
        log.info("Success Login with email '{}' and password '{}'", email,password);
        authenticationPage.openAuthenticationPage();
        authenticationPage.isPageOpened();
        authenticationPage.enterEmail(email);
        authenticationPage.enterPassword(password);
        authenticationPage.clickSignInButton();
        myAccountPage.isPageOpened();
    }

    @Step("Getting error message when password is wrong")
    public void errorLoginMessage(String email, String password) {
        log.info("Getting error message when password is wrong");
        authenticationPage.openAuthenticationPage();
        authenticationPage.isPageOpened();
        authenticationPage.enterEmail(email);
        authenticationPage.enterPassword(password);
        authenticationPage.clickSignInButton();
        String errorText = authenticationPage.getErrorMessage().getText();
        Assert.assertEquals(errorText, "Authentication failed.", " Expected error message is not on the page ");
    }

    @Step("Logout from account")
    public void logoutFromAccount(String email, String password){
        log.info("Logout from account");
        login(email,password);
        headerPage.isPageOpened();
        headerPage.clickLogoutButton();
        headerPage.logoutButtonIsDisplayed();
    }
}
