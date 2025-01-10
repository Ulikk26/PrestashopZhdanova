package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import models.PersonalInformation;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CreateAccountTest extends BaseTest {

    Faker faker = new Faker();

    PersonalInformation account = PersonalInformation.builder()
            .title("Г-жа")
            .firstName(faker.name().firstName())
            .lastName(faker.name().lastName())
            .password("12345")
            .build();

    @Test(testName = "Checking account creation", description = "Checking account creation")
    @Description("Checking account creation")
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