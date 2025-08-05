package tests;

import org.testng.annotations.Test;

public class MailTests extends BaseTests {

    @Test(description = "Test login on site, create mail and check bold style")
    public void checkBoldButtonTest() {
        loginSteps.loginAndWaitForPageOpened(USERNAME, PASSWORD);
        mailPageSteps.checkBoldStyle("New Mail", "700");
    }

    @Test(description = "Test login on site, create mail and check italic style")
    public void checkItalicButtonTest() {
        loginSteps.loginAndWaitForPageOpened(USERNAME, PASSWORD);
        mailPageSteps.checkItalicStyle("New Mail", "italic");
    }

    @Test(description = "Test login on site, create mail and check underline style")
    public void checkUnderlineButtonTest() {
        loginSteps.loginAndWaitForPageOpened(USERNAME, PASSWORD);
        mailPageSteps.checkUnderlineStyle("New Mail", "solid");
    }

    @Test(description = "Test login on site, create mail and check change size letters")
    public void checkChangeSizeTest() {
        loginSteps.loginAndWaitForPageOpened(USERNAME, PASSWORD);
        mailPageSteps.checkChangeSize("New Mail", "8");
    }

    @Test(description = "Test login on site, create mail and check change color letters")
    public void checkChangeTextColorTest() {
        loginSteps.loginAndWaitForPageOpened(USERNAME, PASSWORD);
        mailPageSteps.checkChangeTextColor("New Mail", "1ABC9C", "rgba(26, 188, 156, 1)");
    }

    @Test(description = "Test login on site, create mail and check paste image")
    public void checkImageButtonTest() {
        String imageURL = "https://media.istockphoto.com/id/1074191718/ru/%D0%B2%D0%B5%D0%BA%D1%82%D0%BE%D1%80%D0%BD%D0%B0%D1%8F/%D0%B7%D0%B0%D0%B1%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F-%D0%B8%D0%BB%D0%BB%D1%8E%D1%81%D1%82%D1%80%D0%B0%D1%86%D0%B8%D1%8F-%D1%88%D0%B8%D0%BC%D0%BF%D0%B0%D0%BD%D0%B7%D0%B5.jpg?s=612x612&w=0&k=20&c=rNLpMQB7DcvoysFZG3Z3fiW0yddA2-z7mTz3NSG8LL4=";
        loginSteps.loginAndWaitForPageOpened(USERNAME, PASSWORD);
        mailPageSteps.checkImage(imageURL);
    }
}
