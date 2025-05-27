package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SettingPage extends BasePage{

    @FindBy(xpath = "//*[@name='selectLocale']")
    WebElement choiceBox;
    @FindBy(xpath = "//*[@class='alert alert-success']")
    WebElement successMessage;
    @FindBy(xpath = "//*[@type='submit']")
    WebElement okButton;
    @FindBy(xpath = "//*[contains(@class, 'nav-link') and contains(@href, '#/settings/color_scheme')]")
    WebElement tabChangeColor;


    public SettingPage(WebDriver driver) {
        super(driver);
    }

    public void changeLanguage(String language){
        Select select = new Select(choiceBox);
        choiceBox.click();
        select.selectByVisibleText(language);
//        languageBox.click();
//        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.ARROW_DOWN).perform();
//        actions.sendKeys(Keys.ENTER).perform();
        okButton.click();
    }

    public void changeColorStyle(String color){
        tabChangeColor.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Select select = new Select(choiceBox);
        choiceBox.click();
        select.selectByVisibleText(color);
        okButton.click();
    }

    public void checkChange(){
        Assert.assertTrue(successMessage.isDisplayed());
    }

    public SettingPage openPage(String url){
        driver.get(url);
        return this;
    }

    public SettingPage waitForLoginPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(okButton));
        return this;
    }
}
