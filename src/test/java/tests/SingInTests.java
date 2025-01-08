package tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;

public class SingInTests extends BaseTests {

    @Test(testName = "Verifying login with valid data", description = "Verifying login with valid data")
    @Description("Verifying login with valid data")
    public void checkLoginWithValidData() {
        singInSteps.login(email, password);
    }

    @Test(testName = "Verifying error massage when login with wrong password", description = "Verifying error massage when login with wrong password")
    @Description("Verifying error massage when login with wrong password")
    public void checkErrorMassageLoginWithInvalidData() {
        singInSteps.errorLoginMassage(email, wrongPassword);
    }

    @Test(testName = "Verifying logout from account", description = "Verifying logout from account")
    @Description("Verifying logout from account")
    public void checkLogoutFromAccount() {
        singInSteps.logoutFromAccount(email,password);
    }
}
