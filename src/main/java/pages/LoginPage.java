package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

@Log4j2
public class LoginPage extends BasePage {

    @FindBy(id = "login")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//*[contains(text(),'Login failed')]")
    WebElement errorMessageLoginFailed;

    @FindBy(xpath = "//*[contains(text(), 'Mandatory field')]")
    WebElement errorMessageMandatoryField;

    @FindBy(id = "create-entry")
    WebElement newMailButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MailListPage login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        log.info("Login on site");
        return new MailListPage(driver);
    }

    public LoginPage waitForLoginPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }

    public MailListPage waitForMailListPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(newMailButton));
        return new MailListPage(driver);
    }

    public LoginPage openPage(String url) {
        log.info("Open Login page Url {}", url);
        driver.get(url);
        return this;
    }

    public void checkErrorMessageLoginFailed() {
        log.info("Check writing wrong data");
        Assert.assertTrue(errorMessageLoginFailed.isDisplayed());
    }

    public void checkErrorMessageMandatoryField() {
        log.info("Check don't fill field");
        Assert.assertTrue(errorMessageMandatoryField.isDisplayed());
    }

    public void checkMatchPageUrl() {
        Assert.assertEquals(driver.getCurrentUrl(), MAIL_LIST_PAGE_URL);
        log.info("Current Url match Mail List Page Url");
    }
}
