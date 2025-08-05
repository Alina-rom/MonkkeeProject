package steps;

import constants.IConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.SettingPage;

public class SettingSteps {
    private SettingPage settingPage;

    public SettingSteps(WebDriver driver) {
        settingPage = new SettingPage(driver);
    }

    @Step("Check change language")
    public SettingSteps tryChangeLanguage(String language) {
        settingPage
                .openPage(IConstants.SETTINGS_PAGE_URL)
                .waitForSettingPageOpened()
                .changeLanguage(language);
        Assert.assertTrue(settingPage.checkMessageSuccessfulChangeShown());
        return this;
    }

    @Step("Check change color style")
    public SettingSteps tryChangeColorStyle(String color) {
        settingPage
                .openPage(IConstants.SETTINGS_PAGE_URL)
                .waitForSettingPageOpened()
                .changeColorStyle(color);
        Assert.assertTrue(settingPage.checkMessageSuccessfulChangeShown());
        return this;
    }
}
