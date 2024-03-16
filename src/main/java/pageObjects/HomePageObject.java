package pageObjects;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUI.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAccountDisplayed(String userName) {
        return isElementDisplayed(driver, HomePageUI.ACCOUNT_LOGIN, userName);
    }
}
