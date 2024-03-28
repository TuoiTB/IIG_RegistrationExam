package pageObjects;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUI.RegistrationToeicExamPageUI;

public class RegistrationToeicExamPageObject extends BasePage {
    WebDriver driver;

    public RegistrationToeicExamPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Input to dynamic textbox by label in infomation persional form")
    public void inputToDynamicTextboxByLabel(String valueToSend, String dynamicLabel) {
        waitForElementVisible(driver, RegistrationToeicExamPageUI.INFOR_PERSIONAL_DYNAMIC_TEXTBOX_BY_LABEL, dynamicLabel);
        sendkeyToElement(driver, RegistrationToeicExamPageUI.INFOR_PERSIONAL_DYNAMIC_TEXTBOX_BY_LABEL, valueToSend, dynamicLabel );
    }
    @Step("Input to dynamic date by label in infomation persional form")
    public void inputToDynamicDateByLabel(String valueToSend, String dynamicLabel) {
        waitForElementVisible(driver, RegistrationToeicExamPageUI.INFOR_PERSIONAL_DYNAMIC_DATE_BY_LABEL, dynamicLabel );
        sendkeyToElement(driver, RegistrationToeicExamPageUI.INFOR_PERSIONAL_DYNAMIC_DATE_BY_LABEL, valueToSend, dynamicLabel);
        clickToElement(driver, RegistrationToeicExamPageUI.ACTIVE_DAY);
    }
    @Step("Choose Item In Default Dropdown By Id")
    public void chooseItemInDefaultDropdownById(String valueToChoose, String dynamicId) {
        selectDropdown(driver, RegistrationToeicExamPageUI.DYNAMIC_DEFAULT_DROPDOWN_BY_ID, valueToChoose, dynamicId);
    }
    @Step("Choose Item Random In Default Dropdown")
    public void chooseItemRandomInDefaultDropdownById() {
        waitForElementVisible(driver, RegistrationToeicExamPageUI.DYNAMIC_DEFAULT_DROPDOWN_BY_ID);
        selectRandomDropdown(driver, RegistrationToeicExamPageUI.DYNAMIC_DEFAULT_DROPDOWN_BY_ID);
    }
    @Step("Choose Item In Default Dropdown By Name")
    public void chooseItemInDefaultDropdownByName(String valueToChoose, String dynamicName) {
        selectDropdown(driver, RegistrationToeicExamPageUI.DYNAMIC_DEFAULT_DROPDOWN_BY_NAME, valueToChoose, dynamicName);
    }
    @Step("Choose Item In Checkbox")
    public void chooseItemInCheckboxByDynamicText(String dynamicText) {
        waitForElementClickable(driver, RegistrationToeicExamPageUI.DYNAMIC_CHECKBOX_BY_TEXT, dynamicText);
        checkToCheckboxOrRadio(driver, RegistrationToeicExamPageUI.DYNAMIC_CHECKBOX_BY_TEXT, dynamicText);
    }
    @Step("Choose Item In Radio button")
    public void chooseItemInRadioButtonByDynamicTId(String dynamicId) {
        waitForElementClickable(driver, RegistrationToeicExamPageUI.DYNAMIC_RADIO_BUTTON_BY_TEXT, dynamicId);
        checkToCheckboxOrRadio(driver, RegistrationToeicExamPageUI.DYNAMIC_RADIO_BUTTON_BY_TEXT, dynamicId);
    }
    @Step("Input to Score Goal")
    public void inputToScoreGoal(String valueToSend) {
        waitForElementVisible(driver, RegistrationToeicExamPageUI.SCORE_GOAL_TEXTBOX);
        sendkeyToElement(driver, RegistrationToeicExamPageUI.SCORE_GOAL_TEXTBOX, valueToSend);
    }
    @Step("Check to Agreement checkbox")
    public void checkToAgreeCheckbox() {
        waitForElementClickable(driver, RegistrationToeicExamPageUI.AGREE_CHECKBOX);
        checkToCheckboxOrRadio(driver, RegistrationToeicExamPageUI.AGREE_CHECKBOX);
    }
    @Step("Click to Submit profile button")
    public void clickToSubmitButton() {
        waitForElementClickable(driver, RegistrationToeicExamPageUI.SUBMIT_BUTTON);
        scrollToElementOnTop(driver, RegistrationToeicExamPageUI.SUBMIT_BUTTON);
        clickToElement(driver, RegistrationToeicExamPageUI.SUBMIT_BUTTON);
    }
    @Step("Input to Phone Number")
    public void inputToPhoneTextbox(String valueToSend) {
        waitForElementVisible(driver, RegistrationToeicExamPageUI.PHONE_TEXTBOX);
        sendkeyToElement(driver, RegistrationToeicExamPageUI.PHONE_TEXTBOX, valueToSend);
    }
    public boolean isSubmitSuccessfully(){
        return isElementDisplayed(driver, RegistrationToeicExamPageUI.SUBMIT_SUCCESSFULLY_MESSAGE);
    }
    public boolean isErrorFadingMessageDisplayed(){
        return isElementDisplayed(driver, RegistrationToeicExamPageUI.ERROR_FADING);
    }
    public void chooseStatusExam(String id) {
        waitForElementClickable(driver, RegistrationToeicExamPageUI.DYNAMIC_STATUS_EXAM_CHECKBOX_BY_ID, id);
        checkToCheckboxOrRadio(driver, RegistrationToeicExamPageUI.DYNAMIC_STATUS_EXAM_CHECKBOX_BY_ID, id);
    }
    public void clickToCloseButton(){
        waitForElementVisible(driver, RegistrationToeicExamPageUI.CLOSE_BUTTON);
        clickToElement(driver, RegistrationToeicExamPageUI.CLOSE_BUTTON);
    }
    public void uploadAvatarFile(String filePath) {
        scrollToElementOnTop(driver, RegistrationToeicExamPageUI.UPLOAD_AVATAR_FILE);
        uploadSingleFile(driver, RegistrationToeicExamPageUI.UPLOAD_AVATAR_FILE, filePath);
        clickToCropButton();
    }
    public void uploadCardFrontFile(String filePath) {
        scrollToElementOnTop(driver, RegistrationToeicExamPageUI.UPLOAD_CARD_FRONT_FILE);
        uploadSingleFile(driver, RegistrationToeicExamPageUI.UPLOAD_CARD_FRONT_FILE, filePath);
    }
    public void uploadCardBackFile(String filePath) {
        scrollToElementOnTop(driver, RegistrationToeicExamPageUI.UPLOAD_CARD_BACK_FILE);
        uploadSingleFile(driver, RegistrationToeicExamPageUI.UPLOAD_CARD_BACK_FILE, filePath);
    }
    public void clickToCropButton() {
        waitForElementClickable(driver, RegistrationToeicExamPageUI.CROP_BUTTON);
        clickToElement(driver, RegistrationToeicExamPageUI.CROP_BUTTON);
    }
}
