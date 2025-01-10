package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.*;
import steps.CreateAccountSteps;
import steps.ProductSteps;
import steps.SignInSteps;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Log4j2
public class BaseTest {
    HeaderPage headerPage;
    AuthenticationPage authenticationPage;
    MyAccountPage myAccountPage;
    ShoppingCartSummaryPage shoppingCartSummaryPage;
    ProductsPage productsPage;
    ProductAddedModal productAddedModal;

    CreateAccountSteps createAccountSteps;
    SignInSteps signInSteps;
    ProductSteps productSteps;


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
            options.addArguments("--headless");
            options.addArguments("--allow-insecure-localhost");
            options.addArguments("--disable-web-security");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--unsafely-treat-insecure-origin-as-secure=http://prestashop.qatestlab.com.ua");
            Configuration.browserCapabilities = options;
            Configuration.browserSize = "1920x1080";
            Configuration.browser = "chrome";
//            Configuration.headless = true;
            Configuration.timeout = 10000;
            Configuration.clickViaJs = true;
            Configuration.baseUrl = baseUrl;
            Configuration.reportsFolder = "target/allure-results";
        } else if (browser.equalsIgnoreCase("fireFox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-headless");
            Configuration.browserCapabilities = options;
            Configuration.browserSize = "1920x1080";
            Configuration.browser = "firefox";
//            Configuration.headless = true;
            Configuration.timeout = 10000;
            Configuration.clickViaJs = true;
            Configuration.baseUrl = baseUrl;
            Configuration.reportsFolder = "target/allure-results";
        }

        headerPage = new HeaderPage();
        authenticationPage = new AuthenticationPage();
        myAccountPage = new MyAccountPage();
        shoppingCartSummaryPage = new ShoppingCartSummaryPage();
        productAddedModal = new ProductAddedModal();
        productsPage = new ProductsPage();

        createAccountSteps = new CreateAccountSteps();
        signInSteps = new SignInSteps();
        productSteps =new ProductSteps();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        log.info("Close browser");
        closeWebDriver();
    }
}