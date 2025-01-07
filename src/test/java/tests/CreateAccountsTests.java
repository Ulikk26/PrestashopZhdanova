package tests;

import com.github.javafaker.Faker;
import jdk.jfr.Description;
import models.PersonalInformation;
import org.testng.annotations.Test;

public class CreateAccountsTests extends BaseTests {

    Faker faker = new Faker();

    PersonalInformation account = PersonalInformation.builder()
            .title("Г-жа")
            .firstName(faker.name().firstName())
            .lastName(faker.name().lastName())
            .password("12345")
            .build();

    @Test(testName = "Verifying account creation", description = "Verifying account creation")
    @Description("Verifying account creation")
    public void checkCreateAccount() {
        createAccountSteps.createNewAccount(faker.internet().emailAddress(), account);
    }
}