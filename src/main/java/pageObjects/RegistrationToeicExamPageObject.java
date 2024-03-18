package pageObjects;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUI.HomePageUI;
import pageUI.LoginPageUI;
import pageUI.RegistrationToeicExamPageUI;

public class RegistrationToeicExamPageObject extends BasePage {
    WebDriver driver;

    public RegistrationToeicExamPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Input to dynamic textbox by label in infomation persional form")
    public void inputToDynamicTextboxByLabel(String dynamicLabel, String valueToSend) {
        waitForElementVisible(driver, RegistrationToeicExamPageUI.INFOR_PERSIONAL_DYNAMIC_TEXTBOX_BY_LABEL, dynamicLabel);
        sendkeyToElement(driver, RegistrationToeicExamPageUI.INFOR_PERSIONAL_DYNAMIC_TEXTBOX_BY_LABEL, dynamicLabel, valueToSend);
    }
    @Step("Input to dynamic date by label in infomation persional form")
    public void inputToDynamicDateByLabel(String dynamicLabel, String valueToSend) {
        waitForElementVisible(driver, RegistrationToeicExamPageUI.INFOR_PERSIONAL_DYNAMIC_DATE_BY_LABEL, dynamicLabel );
        sendkeyToElement(driver, RegistrationToeicExamPageUI.INFOR_PERSIONAL_DYNAMIC_DATE_BY_LABEL, dynamicLabel,  valueToSend );
    }
    @Step("Choose Item In Default Dropdown By Label in infomation persional form")
    public void chooseItemInDefaultDropdownByLabel(String dynamicLabel, String valueToChoose) {
        selectDropdown(driver, RegistrationToeicExamPageUI.DYNAMIC_DEFAULT_DROPDOWN_BY_LABEL, valueToChoose, dynamicLabel);
    }
}
