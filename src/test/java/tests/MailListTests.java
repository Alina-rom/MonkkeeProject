package tests;

import org.testng.annotations.Test;

public class MailListTests extends BaseTests{

    @Test(description = "Test login on site and delete all mail")
    public void deleteAllMails(){
        loginSteps.loginAndWaitForPageOpened(USERNAME,PASSWORD);
        mailListSteps
                .createNewMails()
                .deleteAllMail();
    }

    @Test(description = "Test create and search mail")
    public void checkSearchTest(){
        loginSteps.loginAndWaitForPageOpened(USERNAME,PASSWORD);
        mailListSteps.checkSearchMail("MONKEY");
    }

    @Test(description = "Test create mail with tag and check it")
    public void createAndCheckTagInMail(){
        loginSteps.loginAndWaitForPageOpened(USERNAME,PASSWORD);
        mailPageSteps.createMailWithTag("diplom");
        mailListSteps.checkTagInMail("diplom", "diplom");
    }

    @Test(description = "Test login, create mail and delete it")
    public void bigTest(){
        loginSteps
                .loginAndWaitForPageOpened(USERNAME,PASSWORD)
                .checkMatchUrl();
        mailListSteps.createNewMailAndCheck("Monkey");
        mailListSteps.checkDeleteSpecificMail("Monkey");
    }
}
