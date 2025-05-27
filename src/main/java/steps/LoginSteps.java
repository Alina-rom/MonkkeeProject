package steps;

import constans.IConstans;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps(WebDriver driver){
        loginPage = new LoginPage(driver);
    }

    @Step("Login and wait for page loaded")
    public LoginSteps loginAndWaitForPageOpened(String username, String password){
        loginPage
                .openPage(IConstans.LOGIN_PAGE_URL)
                .waitForLoginPageOpened()
                .login(username, password);
        loginPage.waitForMailListPageOpened();
        return this;
    }

    @Step("Try login with incorrect data")
    public LoginSteps loginWithIncorrectData(String username, String password){
        loginPage
                .openPage(IConstans.LOGIN_PAGE_URL)
                .waitForLoginPageOpened()
                .login(username, password);
        return this;
    }

    @Step("Check appearance error massage with incorrect data when login")
    public LoginSteps checkAppearanceErrorMassage(){
        loginPage.checkError();
        return this;
    }

    @Step("Check appearance error massage empty field when login")
    public LoginSteps checkAppearanceErrorMassageField(){
        loginPage.checkErrorField();
        return this;
    }

    @Step("Check match current url with MailList url")
    public LoginSteps checkMatchUrl(){
        loginPage.checkMatch();
        return this;
    }
}
