package test.interview;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class examination extends BaseTest {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
    }
    @Test
    public void TC_01_openlink(){
        driver.get("https://ratings.fide.com/topfed.phtml?ina=1&country=AUS");
    }

    @Test
    public void TC_02_selectItem(){
        driver.get("https://ratings.fide.com/topfed.phtml?ina=1&country=AUS");
        List<WebElement> SpeedDropDownList = driver.findElements(By.xpath("//b[text()='Australia']/parent::font//following::tbody//tr/td[2]"));
        for (WebElement tempItem : SpeedDropDownList){
            String itermText = tempItem.getText();
            System.out.println(itermText);

        }
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
