package tests;

import constants.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.LoginPage;
import pages.MailListPage;
import pages.MailPage;
import pages.SettingPage;
import steps.LoginSteps;
import steps.MailListSteps;
import steps.MailPageSteps;
import steps.SettingSteps;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTests implements IConstants {
    WebDriver driver;
    LoginPage loginPage;
    MailListPage mailListPage;
    MailPage mailPage;
    SettingPage settingPage;
    LoginSteps loginSteps;
    MailListSteps mailListSteps;
    MailPageSteps mailPageSteps;
    SettingSteps settingSteps;

    public static String USERNAME = System.getProperty("login", "");
    public static String PASSWORD = System.getProperty("password", "");

    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
        initPage();
    }

    public void initPage() {
        loginPage = new LoginPage(driver);
        mailListPage = new MailListPage(driver);
        mailPage = new MailPage(driver);
        settingPage = new SettingPage(driver);
        loginSteps = new LoginSteps(driver);
        mailListSteps = new MailListSteps(driver);
        mailPageSteps = new MailPageSteps(driver);
        settingSteps = new SettingSteps(driver);
    }

    @AfterMethod
    public void endTest() {
        driver.quit();
    }
}
