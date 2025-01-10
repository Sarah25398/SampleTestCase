package Utils;

import Page.LoginPage;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;



public class BaseTest {
    protected static WebDriver driver;
    protected LoginPage loginPage;
    public static WebDriver getDriver(){
        return driver;
    }
    @BeforeMethod
    public void preCondition(){
        String baseUrl = GetKeyProperties.getBaseUrl();
        driver = new DriverFactory().createInstance();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
    }
    @AfterMethod
    public void postCondition(){
        driver.quit();
    }
}
