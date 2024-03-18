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

@Epic("Login")
@Feature("Login")
public class Registration_Toeic_Exam_Main_Flow extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;
    LoginPageObject loginPage;
    DashBoardPageObject dashBoardPage;
    RegistrationToeicExamPageObject registrationToeicExamPage;
    public static String userName, password;
    private String fullName, idCard, place_idCard, address, phoneNumber, email, addressWork ;
    private String dateOfBirth, dateOfIdCard;
    private String province, district, ward;
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
        place_idCard = "HD";
        address = "61 Phùng Chí Kiên";
        phoneNumber = "0987654321";
        email = "Tubaotuoi@gmail.com";
        addressWork = "Trung Yên plaza";
        dateOfBirth = "30/05/1999";
        dateOfIdCard = "15/06/2022";
        province = "Hải Dương";
        district = "Thanh Hà";
        ward = "Hồng Lạc";
    }
    @Test(priority = 1)
    public void Registration_With_Identification_card() {
        homePage.chooseItemInRegistrationExamDropdown("Bài thi Tiếng Anh","TOEIC");
        homePage.waitingForLoadingIconInvisbile();
        registrationToeicExamPage = PageGeneratorManager.getRegistrationToeicExamPage(driver);
        registrationToeicExamPage.inputToDynamicTextboxByLabel("Họ và tên thí sinh",fullName);
        registrationToeicExamPage.inputToDynamicDateByLabel("Ngày sinh", dateOfBirth);
        registrationToeicExamPage.chooseItemInDefaultDropdownByLabel("Chứng minh thư nhân dân","Loại giấy tờ đăng ký dự thi");
        registrationToeicExamPage.inputToDynamicTextboxByLabel("Chứng minh thư nhân dân",idCard);
        registrationToeicExamPage.inputToDynamicDateByLabel("Ngày cấp",dateOfIdCard);
        registrationToeicExamPage.inputToDynamicTextboxByLabel("Nơi cấp",place_idCard);
        registrationToeicExamPage.chooseItemInDefaultDropdownByLabel("Tỉnh/Thành phố",province);
        registrationToeicExamPage.chooseItemInDefaultDropdownByLabel("Quận/Huyện",district);
        registrationToeicExamPage.chooseItemInDefaultDropdownByLabel("Xã/Phường",ward);
        registrationToeicExamPage.inputToDynamicTextboxByLabel("Số nhà, đường/phố",address);
        registrationToeicExamPage.inputToDynamicTextboxByLabel("Số điện thoại ",phoneNumber);
        registrationToeicExamPage.inputToDynamicTextboxByLabel("Email",email);
        registrationToeicExamPage.inputToDynamicTextboxByLabel("Địa chỉ làm việc",addressWork);
    }
    @Test(priority = 2)
    public void Registration_With_Citizen_Identification_card() {

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
       // quitBrowserDriver();
    }
}
