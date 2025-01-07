package tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;

public class SingInTests extends BaseTests {

    @Test(testName = "Verifying login with valid data", description = "Verifying login with valid data")
    @Description("Verifying login with valid data")
    public void checkLoginWithValidData() {
        singInSteps.login(user, password);
    }

    @Test(testName = "Verifying error massage when login with invalid password", description = "Verifying error massage when login with invalid password")
    @Description("Verifying error massage when login with invalid password")
    public void checkErrorMassageLoginWithInvalidData() {
        singInSteps.errorLoginMassage(user, wrongPassword);
    }
}
