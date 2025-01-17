package Utils;

import Page.BankCreateAccount;
import Page.BankPageAdmin;
import Page.BankRegister;
import Page.LoginPage;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class BaseTest {
    protected static WebDriver driver;
    protected LoginPage loginPage;
    protected BankPageAdmin bankPageAdmin;
    protected BankRegister bankRegister;
    protected BankCreateAccount bankCreateAccount;
    public static WebDriver getDriver(){
        return driver;
    }
    @BeforeMethod
    public void preCondition(){
        String baseUrl = GetKeyProperties.getBaseUrl("bankPage.baseUrlRegister");
        driver = new DriverFactory("chrome").createInstance();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        bankPageAdmin = new BankPageAdmin(driver);
        bankRegister = new BankRegister(driver);
        bankCreateAccount = new BankCreateAccount(driver);
    }
    @AfterMethod
    public void postCondition(){
        driver.quit();
    }
}
