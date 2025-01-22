package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import models.PersonalInformation;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class CreateAccountTest extends BaseTest {

    Faker faker = new Faker();

    PersonalInformation account = PersonalInformation.builder()
            .title("Г-жа")
            .firstName(faker.name().firstName())
            .lastName(faker.name().lastName())
            .password("12345")
            .build();

    @Epic("Create account module of an online store" )
    @Feature("Create account")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Julia Zhdanova")
    @Test(testName = "Checking the account creation", description = "Checking the account creation")
    @Description("Checking the account creation")
    public void checkCreateAccount() {
        createAccountSteps.openAuthenticationPage();
        createAccountSteps.openPersonalInformationPage(faker.internet().emailAddress());
        createAccountSteps.openNewMyAccountPage(account);
        String successMessageText = myAccountPage.getAlert();
        assertEquals(successMessageText,
                "Your account has been created.",
                "Expected message is not on the page");
    }
}