package tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;

public class SignInTests extends BaseTests {

    @Test(testName = "Verifying login with valid data", description = "Verifying login with valid data")
    @Description("Verifying login with valid data")
    public void checkLoginWithValidData() {
        signInSteps.login(email, password);
    }

    @Test(testName = "Verifying error message when login with wrong password", description = "Verifying error message when login with wrong password")
    @Description("Verifying error message when login with wrong password")
    public void checkErrorMessageLoginWithInvalidData() {
        signInSteps.errorLoginMessage(email, wrongPassword);
    }

    @Test(testName = "Verifying logout from account", description = "Verifying logout from account")
    @Description("Verifying logout from account")
    public void checkLogoutFromAccount() {
        signInSteps.logoutFromAccount(email,password);
    }
}
