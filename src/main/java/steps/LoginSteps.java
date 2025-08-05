package steps;

import constants.IConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;

public class LoginSteps implements IConstants {

    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Login and wait for page loaded")
    public LoginSteps loginAndWaitForPageOpened(String username, String password) {
        loginPage
                .openPage(IConstants.LOGIN_PAGE_URL)
                .waitForLoginPageOpened()
                .login(username, password);
        loginPage.waitForMailListPageOpened();
        return this;
    }

    @Step("Try login with incorrect data")
    public LoginSteps loginWithIncorrectData(String username, String password) {
        loginPage
                .openPage(IConstants.LOGIN_PAGE_URL)
                .waitForLoginPageOpened()
                .login(username, password);
        return this;
    }

    @Step("Check appearance error massage with incorrect data when login")
    public LoginSteps checkAppearanceErrorMessageLoginFailed() {
        Assert.assertTrue(loginPage.isErrorMessageLoginFailedDisplayed());
        return this;
    }

    @Step("Check appearance error massage empty field when login")
    public LoginSteps checkAppearanceErrorMessageMandatoryField() {
        Assert.assertTrue(loginPage.isErrorMessageMandatoryFieldDisplayed());
        return this;
    }

    @Step("Check match current url with MailList url")
    public LoginSteps checkMatchMailListUrl() {
        Assert.assertEquals(loginPage.getCurrentPageUrl(), MAIL_LIST_PAGE_URL);
        return this;
    }
}
