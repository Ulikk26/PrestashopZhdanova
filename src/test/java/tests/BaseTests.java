package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import steps.CreateAccountSteps;
import steps.SingInSteps;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Log4j2
public class BaseTests {

    CreateAccountSteps createAccountSteps;
    SingInSteps singInSteps;

    String baseUrl = System.getProperty("baseUrl", PropertyReader.getProperty("baseUrl"));
    String email = System.getProperty("email", PropertyReader.getProperty("email"));
    String password = System.getProperty("password", PropertyReader.getProperty("password"));
    String wrongPassword = System.getProperty("wrongPassword", PropertyReader.getProperty("wrongPassword"));

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("fireFox") String browser) {
        log.info("Open browser {}", browser);
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--headless");
            options.addArguments("--allow-insecure-localhost");
            options.addArguments("--disable-web-security");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--unsafely-treat-insecure-origin-as-secure=http://prestashop.qatestlab.com.ua");
            Configuration.browserCapabilities = options;
            Configuration.browser = "chrome";
            Configuration.headless = false;
            Configuration.timeout = 10000;
            Configuration.clickViaJs = true;
            Configuration.baseUrl = baseUrl;
        } else if (browser.equalsIgnoreCase("fireFox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--start-maximized");
       //     options.addArguments("--headless");
            Configuration.browserCapabilities = options;
            Configuration.browser = "firefox";
            Configuration.headless = false;
            Configuration.timeout = 10000;
            Configuration.clickViaJs = true;
            Configuration.baseUrl = baseUrl;
        }


        createAccountSteps = new CreateAccountSteps();
        singInSteps = new SingInSteps();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        closeWebDriver();
    }
}