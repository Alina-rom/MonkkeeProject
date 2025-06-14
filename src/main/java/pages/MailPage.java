package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@Log4j2
public class MailPage extends MailListPage{

    @FindBy(xpath = "//*[@class='entry__editable contenteditable cke_editable cke_editable_inline cke_contents_ltr cke_focus']")
    WebElement inputField;

    @FindBy(xpath = "//*[@title='Bold (Ctrl+B)']")
    WebElement boldButton;

    @FindBy(xpath = "//*[@title='Italic (Ctrl+I)']")
    WebElement italicButton;

    @FindBy(xpath = "//*[@title='Underline (Ctrl+U)']")
    WebElement underlineButton;

    @FindBy(xpath = "//*[@class='cke_button_icon cke_button__image_icon']")
    WebElement imageButton;

    @FindBy(xpath = "//input[@class='cke_dialog_ui_input_text']")
    WebElement imageInput;

    @FindBy(xpath = "//*[contains(text(),'New Mail')]")
    WebElement textInField;

    @FindBy(xpath = "//*[contains(@class, 'cke_dialog_ui_button_ok')]")
    WebElement okButtonInImageField;

    @FindBy(id = "create-entry")
    WebElement newMailButton;

    @FindBy(xpath = "//*[contains(@class, 'cke_combo_button') and contains(@title, 'Font Size')]")
    WebElement sizeButton;

    @FindBy(xpath = "//*[@title ='Expand toolbar']")
    WebElement moreButton;

    @FindBy(xpath = "//*[@title='Text Color']")
    WebElement textColorButton;

    @FindBy(css = ".cke_panel_frame")
    WebElement iframeElement;

    @FindBy(id = "new-tag")
    WebElement tagInput;

    @FindBy(id = "assign-new-tag")
    WebElement tagOkButton;

    @FindBy(id = "back-to-overview")
    WebElement backOnListPageButton;

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public void createNewMailAndStay(){
        log.info("Create new mail for work");
        newMailButton.click();
    }

    public void addTagInMail(String tag){
        inputField.sendKeys("New Mail");
        tagInput.sendKeys(tag);
        log.info("Add tag {} to mail", tag);
        tagOkButton.click();
        backOnListPageButton.click();
    }

    public void boldStyle(){
        log.info("Chose bold style writing");
        boldButton.click();
        inputField.sendKeys("New Mail");
    }

    public void italicStyle(){
        log.info("Chose italic style writing");
        italicButton.click();
        inputField.sendKeys("New Mail");
    }

    public void underlineStyle(){
        log.info("Chose underline style writing");
        underlineButton.click();
        inputField.sendKeys("New Mail");
    }

    public void changeSize(String size) {
        moreButton.click();
        sizeButton.click();
        driver.switchTo().frame(iframeElement);
        driver.findElement(By.xpath(String.format("//li[@class='cke_panel_listItem']//a[@title='%s']", size))).click();
        driver.switchTo().defaultContent();
        log.info("Change size letters in mail to {}",size);
        inputField.sendKeys("New Mail");
    }

    public void changeTextColor(String color){
        textColorButton.click();
        driver.switchTo().frame(iframeElement);
        driver.findElement(By.xpath(String.format("//body/div[1][@class='cke_panel_block cke_colorblock']//a[@data-value='%s']", color))).click();
        driver.switchTo().defaultContent();
        log.info("Change color letters in mail to {}", color);
        inputField.sendKeys("New Mail");
    }

    public void pasteImage(String imageUrl){
        imageButton.click();
        imageInput.sendKeys(imageUrl);
        log.info("Paste image {} in mail", imageUrl);
        okButtonInImageField.click();
    }

    public void checkMatchData(String category, String expected){
        log.info("Check match data in category {}", category);
        Assert.assertEquals(textInField.getCssValue(category), expected);
    }

    public void checkElementEnable(String imageUrl){
        log.info("Check image {} enable in mail",imageUrl);
        Assert.assertTrue(driver.findElement(By.xpath(String.format("//*[contains(@src,'%s')]",imageUrl))).isEnabled());
    }
}
