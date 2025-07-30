package tests;

import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    @Test(description = "Test login on site with empty user field")
    public void loginWithEmptyUsernameTest(){
        loginSteps
                .loginWithIncorrectData("",PASSWORD)
                .checkAppearanceErrorMessageMandatoryField();
    }

    @Test(description = "Test login on site with empty password field")
    public void loginWithEmptyPasswordTest(){
        loginSteps
                .loginWithIncorrectData(USERNAME,"")
                .checkAppearanceErrorMessageMandatoryField();
    }

    @Test(description = "Test login on site with incorrect username")
    public void loginWithIncorrectUsernameTest(){
        loginSteps.loginWithIncorrectData("fdfdfgdf",PASSWORD);
        loginSteps.checkAppearanceErrorMessageLoginFailed();
    }

    @Test(description = "Test login on site with incorrect password")
    public void loginWithIncorrectPasswordTest(){
        loginSteps
                .loginWithIncorrectData(USERNAME,"rgrgrtgbd")
                .checkAppearanceErrorMessageLoginFailed();
    }

    @Test(description = "Test login on site with correct data")
    public void loginSuccessTest(){
        loginSteps
                .loginAndWaitForPageOpened(USERNAME,PASSWORD)
                .checkMatchMailListUrl();
    }
}
