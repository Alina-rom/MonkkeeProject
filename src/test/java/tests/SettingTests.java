package tests;

import org.testng.annotations.Test;

public class SettingTests extends BaseTests{

    @Test(description = "Test login on site and check change language")
    public void changeLanguageTest(){
        loginSteps.loginAndWaitForPageOpened(USERNAME,PASSWORD);
        settingSteps
                .changeLanguageAndCheckIt("Deutsch")
                .changeLanguageAndCheckIt("English");
    }

    @Test(description = "Test login on site and check change color style", retryAnalyzer = Retry.class)
    public void changeColorStyleTest(){
        loginSteps.loginAndWaitForPageOpened(USERNAME,PASSWORD);
        settingSteps.changeColorStyleAndCheckIt("Dark");
    }
}
