package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.MailPage;

public class MailPageSteps {

    private MailPage mailPage;

    public MailPageSteps(WebDriver driver) {
        mailPage = new MailPage(driver);
    }

    @Step("Check bold style in mail")
    public MailPageSteps checkBoldStyle(){
        mailPage.createNewMailAndStay();
        mailPage.boldStyle();
        mailPage.checkMatchData("font-weight","700");
        return this;
    }

    @Step("Check italic style in mail")
    public MailPageSteps checkItalicStyle(){
        mailPage.createNewMailAndStay();
        mailPage.italicStyle();
        mailPage.checkMatchData("font-style","italic");
        return this;
    }

    @Step("Check underline style in mail")
    public MailPageSteps checkUnderlineStyle(){
        mailPage.createNewMailAndStay();
        mailPage.underlineStyle();
        mailPage.checkMatchData("text-decoration-style","solid");
        return this;
    }

    @Step("Check change size letters in mail")
    public MailPageSteps checkChangeSize(String size){
        mailPage.createNewMailAndStay();
        mailPage.changeSize(size);
        mailPage.checkMatchData("font-size", String.format("%spx", size));
        return this;
    }

    @Step("Check change color letters in mail")
    public MailPageSteps checkChangeTextColor(String color, String expected){
        mailPage.createNewMailAndStay();
        mailPage.changeTextColor(color);
        mailPage.checkMatchData("color", expected);
        return this;
    }

    @Step("Check paste image in mail")
    public MailPageSteps checkImage(String imageUrl){
        mailPage.createNewMailAndStay();
        mailPage.pasteImage(imageUrl);
        mailPage.checkElementEnable(imageUrl);
        return this;
    }

    @Step("Create mail and add tag")
    public MailPageSteps createMailWithTag(String tag){
        mailPage.createNewMailAndStay();
        mailPage.addTagInMail(tag);
        return this;
    }
}
