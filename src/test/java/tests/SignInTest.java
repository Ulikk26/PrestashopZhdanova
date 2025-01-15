package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignInTest extends BaseTest {

    @Epic("Login module of an online store" )
    @Feature("Login to the online store")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Julia Zhdanova")
    @Test(testName = "Checking the login with credentials", description = "Checking the login with credentials")
    @Description("Checking the login with credentials")
    public void checkLoginWithValidData() {
        signInSteps.enterCredention(email, password);
        String welcomeText = myAccountPage.getWelcomeText();
        assertEquals(welcomeText,
                "Welcome to your account. Here you can manage all of your personal information and orders.",
                "Expected text is not on the page");
    }

    @Epic("Login module of an online store" )
    @Feature("Login to the online store")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Julia Zhdanova")
    @Test(testName = "Checking error message when login with wrong password", description = "Checking error message when login with wrong password")
    @Description("Checking error message when login with wrong password")
    public void checkErrorMessageLoginWithWrongPassword() {
        signInSteps.enterCredention(email, wrongPassword);
        String errorText = authenticationPage.getErrorMessage().getText();
        assertEquals(errorText,
                "Authentication failed.",
                " Expected error message is not on the page ");
    }

    @Epic("Login module of an online store" )
    @Feature("Logout to the online store")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Julia Zhdanova")
    @Test(testName = "Checking the logout from the account", description = "Checking the logout from the account")
    @Description("Checking the logout from the account")
    public void checkLogoutFromAccount() {
        signInSteps.enterCredention(email, password);
        signInSteps.logoutFromAccount();
        assertTrue(authenticationPage.isSingInVisible());
    }
}
