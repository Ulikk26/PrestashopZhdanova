package tests.Base;

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
    protected HeaderPage headerPage;
    protected AuthenticationPage authenticationPage;
    protected MyAccountPage myAccountPage;
    protected ShoppingCartSummaryPage shoppingCartSummaryPage;
    protected ProductsPage productsPage;
    protected ProductAddedModal productAddedModal;
    protected PersonalInformationPage personalInformationPage;

    protected CreateAccountSteps createAccountSteps;
    protected SignInSteps signInSteps;
    protected ProductSteps productSteps;

    protected String baseUrl = System.getProperty("baseUrl", PropertyReader.getProperty("baseUrl"));
    protected String email = System.getProperty("email", PropertyReader.getProperty("email"));
    protected String password = System.getProperty("password", PropertyReader.getProperty("password"));
    protected String wrongPassword = System.getProperty("wrongPassword", PropertyReader.getProperty("wrongPassword"));

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