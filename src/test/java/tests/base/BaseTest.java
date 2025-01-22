package tests.base;

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
import utils.ScreenshotUtil;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Log4j2
public class BaseTest {
    protected static HeaderPage headerPage;
    protected static AuthenticationPage authenticationPage;
    protected static MyAccountPage myAccountPage;
    protected static ShoppingCartSummaryPage shoppingCartSummaryPage;
    protected static ProductsPage productsPage;
    protected static ProductAddedModal productAddedModal;
    protected static PersonalInformationPage personalInformationPage;
    protected static CreateAccountSteps createAccountSteps;
    protected static SignInSteps signInSteps;
    protected static ProductSteps productSteps;

    protected static String baseUrl = System.getProperty("baseUrl", PropertyReader.getProperty("baseUrl"));
    protected static String email = System.getProperty("email", PropertyReader.getProperty("email"));
    protected static String password = System.getProperty("password", PropertyReader.getProperty("password"));
    protected static String wrongPassword = System.getProperty("wrongPassword", PropertyReader.getProperty("wrongPassword"));

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("fireFox") String browser) {
        log.info("Open browser {}", browser);
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            Configuration.browserCapabilities = options;
            Configuration.browserSize = "1920x1080";
            Configuration.browser = "chrome";
            Configuration.headless = true;
            Configuration.timeout = 10000;
            Configuration.clickViaJs = true;
            Configuration.reportsFolder = "target/allure-results";
            Configuration.baseUrl =baseUrl;
        } else if (browser.equalsIgnoreCase("fireFox")) {
            FirefoxOptions options = new FirefoxOptions();
            Configuration.browserCapabilities = options;
            Configuration.browserSize = "1920x1080";
            Configuration.browser = "firefox";
            Configuration.headless = true;
            Configuration.timeout = 10000;
            Configuration.clickViaJs = true;
            Configuration.reportsFolder = "target/allure-results";
            Configuration.baseUrl =baseUrl;
        }

        headerPage = new HeaderPage();
        authenticationPage = new AuthenticationPage();
        myAccountPage = new MyAccountPage();
        shoppingCartSummaryPage = new ShoppingCartSummaryPage();
        productAddedModal = new ProductAddedModal();
        productsPage = new ProductsPage();
        personalInformationPage =new PersonalInformationPage();
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
            ScreenshotUtil.attachScreenshot("Screenshot before closing the browser");
            closeWebDriver();
        }
}