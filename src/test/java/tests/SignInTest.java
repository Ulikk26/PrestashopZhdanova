package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignInTest extends BaseTest {

    @Test(testName = "Checking login with valid data", description = "Checking login with valid data")
    @Description("Checking login with valid data")
    public void checkLoginWithValidData() {
        signInSteps.enterCredention(email, password);
        String welcomeText = myAccountPage.getWelcomeText();
        assertEquals(welcomeText,
                "Welcome to your account. Here you can manage all of your personal information and orders.",
                "Expected text is not on the page");
    }

    @Test(testName = "Checking error message when login with wrong password", description = "Checking error message when login with wrong password")
    @Description("Checking error message when login with wrong password")
    public void checkErrorMessageLoginWithWrongPassword() {
        signInSteps.enterCredention(email, wrongPassword);
        String errorText = authenticationPage.getErrorMessage().getText();
        assertEquals(errorText,
                "Authentication failed.",
                " Expected error message is not on the page ");
    }

    @Test(testName = "Checking logout from account", description = "Checking logout from account")
    @Description("Checking logout from account")
    public void checkLogoutFromAccount() {
        signInSteps.enterCredention(email, password);
        signInSteps.logoutFromAccount();
        assertTrue(authenticationPage.isSingInVisible());
    }
}
