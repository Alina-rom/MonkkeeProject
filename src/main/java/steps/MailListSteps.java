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

    @Step("Create 3 empty mail")
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

    @Step("Create mail and check it")
    public MailListSteps createNewMailAndCheck(String text){
        mailListPage.createNewMail(text);
        mailListPage.checkElementEnable(text);
        return this;
    }

    public MailListSteps checkDeleteSpecificMail(String text){
        mailListPage.deleteSpecificMail(text);
        mailListPage.checkElementNotEnable(text);
        return this;
    }
}
