package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.MailPage;

public class MailPageSteps {

    private MailPage mailPage;

    public MailPageSteps(WebDriver driver) {
        mailPage = new MailPage(driver);
    }

    @Step("Check bold style in mail")
    public MailPageSteps checkBoldStyle(String text, String expected) {
        mailPage.createNewMailAndStay();
        mailPage.boldStyle(text);
        Assert.assertEquals(mailPage.checkMatchData("font-weight", text), expected);
        return this;
    }

    @Step("Check italic style in mail")
    public MailPageSteps checkItalicStyle(String text, String expected) {
        mailPage.createNewMailAndStay();
        mailPage.italicStyle(text);
        Assert.assertEquals(mailPage.checkMatchData("font-style", text), expected);
        return this;
    }

    @Step("Check underline style in mail")
    public MailPageSteps checkUnderlineStyle(String text, String expected) {
        mailPage.createNewMailAndStay();
        mailPage.underlineStyle(text);
        Assert.assertEquals(mailPage.checkMatchData("text-decoration-style", text), expected);
        return this;
    }

    @Step("Check change size letters in mail")
    public MailPageSteps checkChangeSize(String text, String size) {
        mailPage.createNewMailAndStay();
        mailPage.changeSize(text, size);
        Assert.assertEquals(mailPage.checkMatchData("font-size", text), String.format("%spx", size));
        return this;
    }

    @Step("Check change color letters in mail")
    public MailPageSteps checkChangeTextColor(String text, String color, String expected) {
        mailPage.createNewMailAndStay();
        mailPage.changeTextColor(text, color);
        Assert.assertEquals(mailPage.checkMatchData("color", text), expected);
        return this;
    }

    @Step("Check paste image in mail")
    public MailPageSteps checkImage(String imageUrl) {
        mailPage.createNewMailAndStay();
        mailPage.pasteImage(imageUrl);
        Assert.assertTrue(mailPage.checkImageEnable(imageUrl));
        return this;
    }

    @Step("Create mail and add tag")
    public MailPageSteps createMailWithTag(String tag, String text) {
        mailPage.createNewMailAndStay();
        mailPage.addTagInMail(tag, text);
        return this;
    }
}
