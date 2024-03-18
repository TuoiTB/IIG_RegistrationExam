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

    @Step("Verify Login successfully")
    public boolean isAccountDisplayed(String userName) {
        return isElementDisplayed(driver, HomePageUI.ACCOUNT_LOGIN, userName);
    }
    @Step("Open registration exam form")
    public void chooseItemInRegistrationExamDropdown(String expectedText, String expectedText2) {
        selectItemInMultipleCustomDropdown(driver, HomePageUI.REGISTRATION_LINK, HomePageUI.DROPDOWN_SUBMENU, HomePageUI.DROPDOWN_ITEMS, expectedText, expectedText2);
    }
    @Step("Waiting for loading icon invisible")
    public void waitingForLoadingIconInvisbile(){
        waitForElementInvisible(driver, HomePageUI.LOADING_ICON);
    }
}
