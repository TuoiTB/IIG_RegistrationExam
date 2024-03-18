package pageObjects;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUI.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to Continue button")
    public void clickToContinueButton() {
        waitForElementClickable(driver, LoginPageUI.CONTINUE_BUTTON);
        clickToElement(driver, LoginPageUI.CONTINUE_BUTTON);
    }
    @Step("Input to Email")
    public void inputToUserName(String valueToSend) {
        waitForElementVisible(driver,LoginPageUI.USER_NAME_TEXTBOX);
        sendkeyToElement(driver,LoginPageUI.USER_NAME_TEXTBOX, valueToSend);
    }
    @Step("Input to Password")
    public void inputToPassword(String valueToSend) {
        waitForListElementVisible(driver, LoginPageUI.PASS_TEXTBOX);
        sendkeyToElement(driver,LoginPageUI.PASS_TEXTBOX, valueToSend);
    }
    @Step("Verify login error message")
    public boolean isLoginErrorMessageDisplayed() {
        waitForElementVisible(driver, LoginPageUI.ERROR_MESSAGE);
        return isElementDisplayed(driver, LoginPageUI.ERROR_MESSAGE);
    }
}
