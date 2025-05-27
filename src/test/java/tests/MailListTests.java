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

//    @Test(description = "Test login, create mail, search it and delete")
//    public void bigTest(){
//        loginSteps
//                .loginAndWaitForPageOpened(USERNAME,PASSWORD)
//                .checkMatchUrl();
//        mailListSteps.createNewMailAndCheck("Monkey");
//        mailListSteps.checkDeleteSpecificMail("Monkey");
//    }
}
