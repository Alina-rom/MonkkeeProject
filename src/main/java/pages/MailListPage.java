package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class MailListPage extends BasePage{

    @FindBy(id = "create-entry")
    WebElement newMailButton;
    @FindBy(id = "back-to-overview")
    WebElement backOnListPageButton;
    @FindBy(xpath = "//*[@ng-model='model.allChecked']")
    WebElement deleteCheckbox;
    @FindBy(id = "delete-entries")
    WebElement deleteButton;
    @FindBy(xpath = "//*[@class='entry__editable contenteditable cke_editable cke_editable_inline cke_contents_ltr cke_focus']")
    WebElement inputField;

    public MailListPage(WebDriver driver) {
        super(driver);
    }

    public void createNewMail(String text) {
        newMailButton.click();
        inputField.sendKeys(text);
        backOnListPageButton.click();
    }

    public void deleteMails(){
        deleteCheckbox.click();
        deleteButton.click();
        driver.switchTo().alert().accept();
    }

    public void deleteSpecificMail(String text){
        driver.findElement(By.xpath(String.format("//*[contains(text(), '%s')]/ancestor::div[contains(@class, 'd-xl-flex mb-xl-3 ng-scope')]//input",text))).click();
        deleteButton.click();
        driver.switchTo().alert().accept();
    }

    public void checkElementEnable(String text){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]",text))).isEnabled());
    }

    public void checkElementNotEnable(String text){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertFalse(driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]",text))).isDisplayed());
    }
}
