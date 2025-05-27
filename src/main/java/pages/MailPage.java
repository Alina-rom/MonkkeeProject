package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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

    @FindBy(xpath = "//*[@title='Text Color']")
    WebElement textColorButton;

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public void createNewMailAndStay(){
        newMailButton.click();
    }

    public void boldStyle(){
        boldButton.click();
        inputField.sendKeys("New Mail");
    }

    public void italicStyle(){
        italicButton.click();
        inputField.sendKeys("New Mail");
    }

    public void underlineStyle(){
        underlineButton.click();
        inputField.sendKeys("New Mail");
    }

    public void changeSize(){
        sizeButton.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        inputField.sendKeys("New Mail");
    }

    public void changeTextColor(){
        textColorButton.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        inputField.sendKeys("New Mail");
    }

    public void pasteImage(String imageUrl){
        imageButton.click();
        imageInput.sendKeys(imageUrl);
        okButtonInImageField.click();
    }

    public void checkMatchData(String category, String expected){
        Assert.assertEquals(textInField.getCssValue(category),expected);
    }

    public void checkElementEnable(String imageUrl){
        Assert.assertTrue(driver.findElement(By.xpath(String.format("//*[contains(@src,'%s')]",imageUrl))).isEnabled());
    }
}
