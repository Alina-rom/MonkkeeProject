package tests;

import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    @Test(description = "Test login on site with empty user field")
    public void loginWithEmptyUsernameTest(){
        loginSteps
                .loginWithIncorrectData("",PASSWORD)
                .checkAppearanceErrorMassageField();
    }

    @Test(description = "Test login on site with empty password field")
    public void loginWithEmptyPasswordTest(){
        loginSteps
                .loginWithIncorrectData(USERNAME,"")
                .checkAppearanceErrorMassageField();
    }

    @Test(description = "Test login on site with incorrect username")
    public void loginWithIncorrectUsernameTest(){
        loginSteps.loginWithIncorrectData("fdfdfgdf",PASSWORD);
        loginSteps.checkAppearanceErrorMassage();
    }

    @Test(description = "Test login on site with incorrect password")
    public void loginWithIncorrectPasswordTest(){
        loginSteps
                .loginWithIncorrectData(USERNAME,"rgrgrtgbd")
                .checkAppearanceErrorMassage();
    }

    @Test(description = "Test login on site with correct data")
    public void loginSuccessTest(){
        loginSteps
                .loginAndWaitForPageOpened(USERNAME,PASSWORD)
                .checkMatchUrl();
    }
}
