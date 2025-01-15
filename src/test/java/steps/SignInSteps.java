package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
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

    @Step("Enter  email {0} and password {1}")
    public void enterCredention(String email, String password) {
        log.info("Entering email '{}' and password '{}'", email, password);
        authenticationPage.openAuthenticationPage()
                .isPageOpened()
                .enterEmail(email)
                .enterPassword(password)
                .clickSignInButton();
    }

    @Step("Logout from account")
    public void logoutFromAccount() {
        log.info("Logout from account");
        myAccountPage.isPageOpened();
        headerPage.isPageOpened()
                .clickLogoutButton()
                .isPageOpened();
    }
}
