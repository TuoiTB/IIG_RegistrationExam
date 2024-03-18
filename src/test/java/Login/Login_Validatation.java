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
public class Login_Validatation extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;
    LoginPageObject loginPage;
    DashBoardPageObject dashBoardPage;

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

    }
    @Test(priority = 1)
    public void Login_With_Empty_Data() {
        loginPage.clickToContinueButton();

    }
    @Test(priority = 2)
    public void Login_With_Invalid_Email() {
        loginPage.inputToUserName("Tuoi.tb");
        loginPage.clickToContinueButton();
        verifyTrue(loginPage.isLoginErrorMessageDisplayed());
    }
    @Test(priority = 3)
    public void Login_With_Email_Not_Register() {
        loginPage.inputToUserName("123@gmail.com");
        loginPage.clickToContinueButton();
       // loginPage.sleepInSecond(2);
        verifyTrue(loginPage.isLoginErrorMessageDisplayed());
    }
    @Test(priority = 4)
    public void Login_With_Valid_Email_And_Blank_Password() {
        loginPage.inputToUserName("dvtest20@yopmail.com");
        loginPage.clickToContinueButton();
       // loginPage.sleepInSecond(2);
        verifyTrue(loginPage.isLoginErrorMessageDisplayed());
    }
    @Test(priority = 5)
    public void Login_With_Valid_Email_And_Invalid_Password() {
        loginPage.inputToUserName("dvtest20@yopmail.com");
        loginPage.inputToPassword("1234");
        loginPage.clickToContinueButton();
       // loginPage.sleepInSecond(2);
        verifyTrue(loginPage.isLoginErrorMessageDisplayed());
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
       // quitBrowserDriver();
    }
}
