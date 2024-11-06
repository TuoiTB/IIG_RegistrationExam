package Registration_Toeic_Exam;

import commons.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.File;

@Epic("Login")
@Feature("Login")
public class Registration_Toeic_Exam_Main_Flow extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;
    LoginPageObject loginPage;
    DashBoardPageObject dashBoardPage;
    RegistrationToeicExamPageObject registrationToeicExamPage;
    public static String userName, password;
    private String fullName, idCard, issuancePlaceOfIdCard, address, phoneNumber, email, addressWork ;
    private String dateOfBirth, issuanceDateOfId;
    private String province, district, ward;
    public String avatarFilePath, cardFrontPath, cardBackPath;
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        dashBoardPage = PageGeneratorManager.getDashBoardPage(driver);
        dashBoardPage.clickToAdvancedButton();
        dashBoardPage.clickToProceedLink();
        dashBoardPage.clickToLoginButton();
        dashBoardPage.clickToLoginImage();
        loginPage = PageGeneratorManager.getLoginPage(driver);
        userName = "dvtest20@yopmail.com";
        password = "Tt@123456";
        loginPage.inputToUserName(userName);
        loginPage.inputToPassword(password);
        loginPage.clickToContinueButton();
        homePage = PageGeneratorManager.getHomePage(driver);
        verifyTrue(homePage.isAccountDisplayed(userName));
        fullName = "Từ Bảo Tươi test";
        idCard = "123456789";
        issuancePlaceOfIdCard = "HD";
        address = "61 Phùng Chí Kiên";
        phoneNumber = "0987654321";
        email = "automationTest@gmail.com";
        addressWork = "Trung Yên plaza";
        dateOfBirth = "30/05/1999";
        issuanceDateOfId = "15/06/2022";
        province = "Hải Dương";
        district = "Thanh Hà";
        ward = "Hồng Lạc";
        avatarFilePath = System.getProperty("user.dir") + File.separator + "uploadFiles" + File.separator + "DKT.jpg";
        cardFrontPath = System.getProperty("user.dir") + File.separator + "uploadFiles" + File.separator + "sea.jpg";
        cardBackPath = System.getProperty("user.dir") + File.separator + "uploadFiles" + File.separator + "small.jpg";
    }
    @Test(priority = 1)
    public void Registration_With_Identification_card() {
        log.info("Step 01: Choose Toeic exam");
        homePage.chooseItemInRegistrationExamDropdown("Bài thi Tiếng Anh","TOEIC");
        registrationToeicExamPage = PageGeneratorManager.getRegistrationToeicExamPage(driver);
        log.info("Step 02: Input to full name");
        registrationToeicExamPage.inputToDynamicTextboxByLabel(fullName, "Họ và tên thí sinh");
        log.info("Step 22: Upload avatar");
        registrationToeicExamPage.uploadAvatarFile(avatarFilePath);
        log.info("Step 23: Upload card front");
        registrationToeicExamPage.uploadCardFrontFile(cardFrontPath);
        log.info("Step 24: Upload card back");
        //System.out.println("I want to stop here. To check above");
        registrationToeicExamPage.uploadCardBackFile(cardBackPath);
        log.info("Step 03: Input to date of birth");
        registrationToeicExamPage.inputToDynamicDateByLabel(dateOfBirth, "Ngày sinh");
        log.info("Step 04: Choose identification card");
        registrationToeicExamPage.chooseItemInDefaultDropdownByName("Chứng minh thư nhân dân","TypeIdCard");
        log.info("Step 05: Input identification card");
        registrationToeicExamPage.inputToDynamicTextboxByLabel(idCard,"Chứng minh thư nhân dân");
        log.info("Step 06: Input date of identification");
        registrationToeicExamPage.inputToDynamicDateByLabel(issuanceDateOfId,"Ngày cấp");
        log.info("Step 07: Input place of identification");
        registrationToeicExamPage.inputToDynamicTextboxByLabel(issuancePlaceOfIdCard,"Nơi cấp");
        log.info("Step 08: Choose city contact");
        registrationToeicExamPage.chooseItemInDefaultDropdownById(province,"CityContact");
        log.info("Step 09: Choose district contact");
        registrationToeicExamPage.chooseItemInDefaultDropdownById(district,"DistrictContact");
        log.info("Step 10: Choose ward contact");
        registrationToeicExamPage.chooseItemInDefaultDropdownById(ward,"WardContact");
        log.info("Step 11: Input to address");
        registrationToeicExamPage.inputToDynamicTextboxByLabel(address,"Số nhà, đường/phố");
        log.info("Step 12: Input to phone number");
        registrationToeicExamPage.inputToPhoneTextbox(phoneNumber);
        log.info("Step 13: Input to email");
        registrationToeicExamPage.inputToDynamicTextboxByLabel(email, "Email");
        log.info("Step 14: Input to address work");
        registrationToeicExamPage.inputToDynamicTextboxByLabel(addressWork,"Địa chỉ làm việc");

        log.info("Step 15: Input to address work");
        registrationToeicExamPage.chooseItemInCheckboxByDynamicText("Đánh giá trình độ");
        log.info("Step 16: Input to Score Goal");
        registrationToeicExamPage.inputToScoreGoal("900");
        log.info("Step 17: Choose status exam");
        registrationToeicExamPage.chooseStatusExam("neverTest");
        log.info("Step 18: Choose area test");
        registrationToeicExamPage.chooseItemInDefaultDropdownById("Hà Nội","AreaTest");
        log.info("Step 19: Choose place of registration");
        registrationToeicExamPage.chooseItemInDefaultDropdownById("Văn phòng Trung Yên - HN","PlaceOfRegistration");
        log.info("Step 20: Choose submit time");
        registrationToeicExamPage.chooseItemInDefaultDropdownById("13/06/2024 09:00 - 10:00","SubmitsionTime");
        log.info("Step 21: Check to agreement checkbox");
        registrationToeicExamPage.checkToAgreeCheckbox();

        log.info("Step 25: Click submit button");
        registrationToeicExamPage.clickToSubmitButton();
        log.info("Step 26: Verify submit successfully");
        //verifyTrue(registrationToeicExamPage.isSubmitSuccessfully());
        registrationToeicExamPage.clickToCloseButton();
    }
   // @Test(priority = 2)
    public void Verify_Logic_Registration_TOEIC_After_Two_Day() {
    /*    log.info("Step 01: Choose Toeic exam");
        homePage.chooseItemInRegistrationExamDropdown("Bài thi Tiếng Anh","TOEIC");
        registrationToeicExamPage = PageGeneratorManager.getRegistrationToeicExamPage(driver);*/
        log.info("Step 02: Input to full name");
        registrationToeicExamPage.inputToDynamicTextboxByLabel(fullName, "Họ và tên thí sinh");
        log.info("Step 22: Upload avatar");
        registrationToeicExamPage.uploadAvatarFile(avatarFilePath);
        log.info("Step 23: Upload card front");
        registrationToeicExamPage.uploadCardFrontFile(cardFrontPath);
        log.info("Step 24: Upload card back");
        registrationToeicExamPage.uploadCardBackFile(cardBackPath);
        log.info("Step 03: Input to date of birth");
        registrationToeicExamPage.inputToDynamicDateByLabel(dateOfBirth, "Ngày sinh");
        log.info("Step 04: Choose identification card");
        registrationToeicExamPage.chooseItemInDefaultDropdownByName("Chứng minh thư nhân dân","TypeIdCard");
        log.info("Step 05: Input identification card");
        registrationToeicExamPage.inputToDynamicTextboxByLabel(idCard,"Chứng minh thư nhân dân");
        log.info("Step 06: Input date of identification");
        registrationToeicExamPage.inputToDynamicDateByLabel(issuanceDateOfId,"Ngày cấp");
        log.info("Step 07: Input place of identification");
        registrationToeicExamPage.inputToDynamicTextboxByLabel(issuancePlaceOfIdCard,"Nơi cấp");
        log.info("Step 08: Choose city contact");
        registrationToeicExamPage.chooseItemInDefaultDropdownById(province,"CityContact");
        log.info("Step 09: Choose district contact");
        registrationToeicExamPage.chooseItemInDefaultDropdownById(district,"DistrictContact");
        log.info("Step 10: Choose ward contact");
        registrationToeicExamPage.chooseItemInDefaultDropdownById(ward,"WardContact");
        log.info("Step 11: Input to address");
        registrationToeicExamPage.inputToDynamicTextboxByLabel(address,"Số nhà, đường/phố");
        log.info("Step 12: Input to phone number");
        registrationToeicExamPage.inputToPhoneTextbox(phoneNumber);
        log.info("Step 13: Input to email");
        registrationToeicExamPage.inputToDynamicTextboxByLabel(email, "Email");
        log.info("Step 14: Input to address work");
        registrationToeicExamPage.inputToDynamicTextboxByLabel(addressWork,"Địa chỉ làm việc");

        log.info("Step 15: Input to address work");
        registrationToeicExamPage.chooseItemInCheckboxByDynamicText("Đánh giá trình độ");
        log.info("Step 16: Input to Score Goal");
        registrationToeicExamPage.inputToScoreGoal("900");
        log.info("Step 17: Choose status exam");
        registrationToeicExamPage.chooseStatusExam("neverTest");
        log.info("Step 18: Choose area test");
        registrationToeicExamPage.chooseItemInDefaultDropdownById("Hà Nội","AreaTest");
        log.info("Step 19: Choose place of registration");
        registrationToeicExamPage.chooseItemInDefaultDropdownById("Văn phòng Trung Yên - HN","PlaceOfRegistration");
        log.info("Step 20: Choose submit time");
        registrationToeicExamPage.chooseItemInDefaultDropdownById("13/06/2024 09:00 - 10:00","SubmitsionTime");
        log.info("Step 21: Check to agreement checkbox");
        registrationToeicExamPage.checkToAgreeCheckbox();

        log.info("Step 25: Click submit button");
        registrationToeicExamPage.clickToSubmitButton();
        log.info("Step 26: Verify submit error message");
        verifyTrue(registrationToeicExamPage.isErrorFadingMessageDisplayed());
    }
    @Test(priority = 3)
    public void Registration_With_Citizen_Identification_card() {

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
       // quitBrowserDriver();
    }
}
