package pageObjects;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUI.DashBoardPageUI;
import pageUI.HomePageUI;

public class DashBoardPageObject extends BasePage {
    WebDriver driver;

    public DashBoardPageObject(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click to Login button")
    public void clickToLoginButton(){
        waitForElementClickable(driver, DashBoardPageUI.LOGIN_LINK);
        clickToElement(driver, DashBoardPageUI.LOGIN_LINK);
    }
    @Step("Click to Login image")
    public void clickToLoginImage(){
        waitForElementClickable(driver, DashBoardPageUI.LOGIN_IMG);
        clickToElement(driver, DashBoardPageUI.LOGIN_IMG);
    }
}
