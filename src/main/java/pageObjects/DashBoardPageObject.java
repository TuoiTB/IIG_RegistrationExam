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
    @Step("Click to Advanced button")
    public void clickToAdvancedButton(){
        waitForElementClickable(driver, DashBoardPageUI.ADVANCE_BUTTON);
        clickToElement(driver, DashBoardPageUI.ADVANCE_BUTTON);
    }
    @Step("Click to Proceed link")
    public void clickToProceedLink(){
        waitForElementClickable(driver, DashBoardPageUI.PROCEED_LINK);
        clickToElement(driver, DashBoardPageUI.PROCEED_LINK);
    }
}
