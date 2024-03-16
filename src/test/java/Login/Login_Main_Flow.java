package Login;

import commons.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.DashBoardPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;

@Epic("Login")
@Feature("Login")
public class Login_Main_Flow extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;
    LoginPageObject loginPage;
    DashBoardPageObject dashBoardPage;
    public static String userName, password;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        dashBoardPage = PageGeneratorManager.getDashBoardPage(driver);
        dashBoardPage.clickToLoginButton();
        dashBoardPage.clickToLoginImage();
        loginPage = PageGeneratorManager.getLoginPage(driver);
        userName = "dvtest20@yopmail.com";
        password = "Tt@123456";
    }
    @Test(priority = 1)
    public void Login_With_All_Valid_Data() {
        loginPage.inputToUserName(userName);
        loginPage.inputToPassword(password);
        loginPage.clickToContinueButton();
        homePage = PageGeneratorManager.getHomePage(driver);
        verifyTrue(homePage.isAccountDisplayed(userName));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        quitBrowserDriver();
    }
}
