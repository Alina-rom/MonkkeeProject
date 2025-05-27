package steps;

import constans.IConstans;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.SettingPage;

public class SettingSteps {
    private SettingPage settingPage;

    public SettingSteps(WebDriver driver){
        settingPage = new SettingPage(driver);
    }

    @Step("Check change language")
    public SettingSteps tryChangeLanguage(String language){
        settingPage
                .openPage(IConstans.SETTINGS_PAGE_URL)
                .waitForLoginPageOpened()
                .changeLanguage(language);
        settingPage.checkChange();
        return this;
    }

    @Step("Check change color style")
    public SettingSteps tryChangeColorStyle(String color){
        settingPage
                .openPage(IConstans.SETTINGS_PAGE_URL)
                .waitForLoginPageOpened()
                .changeColorStyle(color);
        settingPage.checkChange();
        return this;
    }
}
