package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Log4j2
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
        log.info("Select language to change it {}", language);
        okButton.click();
    }

    public void changeColorStyle(String color){
        tabChangeColor.click();
        Select select = new Select(choiceBox);
        choiceBox.click();
        select.selectByVisibleText(color);
        log.info("Select color theme for page {}", color);
        okButton.click();
    }

    public void checkChange(){
        log.info("Check success change");
        Assert.assertTrue(successMessage.isDisplayed());
    }

    public SettingPage openPage(String url){
        log.info("Open Setting page Url {}", url);
        driver.get(url);
        return this;
    }

    public SettingPage waitForLoginPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(okButton));
        return this;
    }
}
