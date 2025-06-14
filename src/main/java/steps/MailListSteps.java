package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.MailListPage;

import java.util.concurrent.TimeUnit;

public class MailListSteps {

    private MailListPage mailListPage;

    public MailListSteps(WebDriver driver) {
        mailListPage = new MailListPage(driver);
    }

    @Step("Create 3 mail")
    public MailListSteps createNewMails() {
        for (int i=0; i<4; i++) {
            mailListPage.createNewMail("New Mail");
        }
        return this;
    }
    @Step("Delete all mail")
    public MailListSteps deleteAllMail(){
        mailListPage.deleteMails();
        return this;
    }

    @Step("Create and search mail")
    public MailListSteps checkSearchMail(String text){
        mailListPage.createNewMail(text);
        mailListPage.searchMail(text);
        mailListPage.checkElementEnable(text);
        return this;
    }

    @Step("Check tag in mail")
    public MailListSteps checkTagInMail(String tag, String expected){
        mailListPage.tagsField(tag);
        mailListPage.checkTag(tag, expected);
        return this;
    }

    @Step("Create mail and check it")
    public MailListSteps createNewMailAndCheck(String text){
        mailListPage.createNewMail(text);
        mailListPage.checkElementEnable(text);
        return this;
    }

    @Step("Delete specific mail and check")
    public MailListSteps checkDeleteSpecificMail(String text){
        mailListPage.deleteSpecificMail(text);
        mailListPage.checkElementNotEnable(text);
        return this;
    }
}
