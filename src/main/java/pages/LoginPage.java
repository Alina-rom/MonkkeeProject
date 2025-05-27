package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//*[@ng-model='model.login']")
    WebElement usernameInput;

    @FindBy(xpath = "//*[@ng-model='model.password']")
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

    public MailListPage login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
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

    public LoginPage openPage(String url){
        driver.get(url);
        return this;
    }

    public void checkError(){
        Assert.assertTrue(errorMessageLoginFailed.isDisplayed());
    }

    public void checkErrorField(){
        Assert.assertTrue(errorMessageMandatoryField.isDisplayed());
    }

    public void checkMatch(){
        Assert.assertEquals(driver.getCurrentUrl(),MAIL_LIST_PAGE_URL);
    }
}
