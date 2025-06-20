package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

@Log4j2
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
//    @FindBy(xpath = "//*[contains(@class, 'd-xl-flex mb-xl-3 ng-scope')]//div[@class=' entries__body']")
//    WebElement lineInMail;
    @FindBy(id = "appendedInputButton")
    WebElement lineSearch;
    @FindBy(xpath = "//*[@title='Search']")
    WebElement searchButton;
//    @FindBy(xpath = "/*[@class='tag entries__tag ng-binding ng-scope']")
//    WebElement tagLineInMail;

    public MailListPage(WebDriver driver) {
        super(driver);
    }

    public void createNewMail(String text) {
        newMailButton.click();
        inputField.sendKeys(text);
        log.info("Create new mail with text {}", text);
        backOnListPageButton.click();
    }

    public void searchMail(String text){
        lineSearch.sendKeys(text);
        log.info("Search mail with text {}", text);
        searchButton.click();
    }

    public void tagsField(String tag){
        log.info("Chose tag {} to see all mails with it", tag);
        driver.findElement(By.xpath(String.format("//*[@class='tag ng-binding' and contains(text(), '%s')]", tag))).click();
    }

    public void checkTag(String tag, String expected){
        log.info("Check mail with tag {} appear on site", tag);
        Assert.assertTrue(driver.findElement(By.xpath(String.format("//*[@class='tag entries__tag ng-binding ng-scope' and contains(text(), '%s')]",tag))).isDisplayed());
        log.info("Check match tag {} in mail with our tag {}", tag, expected);
        Assert.assertEquals(driver.findElement(By.xpath(String.format("//*[@class='tag entries__tag ng-binding ng-scope' and contains(text(), '%s')]",tag))).getText(), expected);
    }

    public void deleteMails(){
        log.info("Delete all mails");
        deleteCheckbox.click();
        deleteButton.click();
        driver.switchTo().alert().accept();
    }

    public void deleteSpecificMail(String text){
        driver.findElement(By.xpath(String.format("//*[contains(text(), '%s')]/ancestor::div[contains(@class, 'd-xl-flex mb-xl-3 ng-scope')]//input",text))).click();
        log.info("Delete mail with text {}", text);
        deleteButton.click();
        driver.switchTo().alert().accept();
    }

    public void checkElementEnable(String text){
        log.info("Check mail with text {} enable on page", text);
        Assert.assertTrue(driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]",text))).isEnabled());
    }

    public void checkElementNotEnable(String text){
        List<String> elementsTexts = null;
        int attempts = 0;
        while (attempts < 2) {
            try {
                elementsTexts = driver.findElements(By.xpath(
                                "//*[contains(@class, 'd-xl-flex mb-xl-3 ng-scope')]//div[@class=' entries__body']"))
                        .stream()
                        .map(WebElement::getText)
                        .toList();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
        log.info("Check mail with text {} delete on site", text);
        Assert.assertFalse(elementsTexts != null && elementsTexts.contains(text),
                "Элемент с текстом '" + text + "' не был удален и отображается на странице");
    }
}
