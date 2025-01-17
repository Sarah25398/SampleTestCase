package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankCreateAccount {

    public WebDriver driver;
    public BankCreateAccount(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath ="//td/input[@type='submit']")
    private WebElement RegisterForm;
    public WebElement RegisterForm(){
        return RegisterForm;
    }
    @FindBy(xpath ="//input[@name='username']")
    private WebElement UserName;
    @FindBy(xpath ="//input[@name='password']")
    private WebElement PassWord ;
    @FindBy(xpath ="//input[@value='Log In']")
    private WebElement LoginButton ;
    public void Login(){
        UserName.sendKeys("TestAccount1");
        PassWord.sendKeys("TestAccount12");
        LoginButton.click();
    }
    @FindBy(xpath ="//input[@value='Open New Account']")
    private WebElement OpenNewAccount ;
    public void OpenNewAccount(){
        OpenNewAccount.click();
    }
    @FindBy(xpath ="//a[@href='openaccount.htm']")
    private WebElement ClickOpenAccount ;
    public void ClickOpenAccount(){
        ClickOpenAccount.click();
    }

    @FindBy(xpath ="//a[@id='newAccountId']")
    private WebElement NewAccountId ;
    public String NewAccountId(){
        String NewAccountIdAttribute = NewAccountId.getAttribute("href");
        String IDURL = NewAccountIdAttribute.split("id=")[1];
        System.out.println(IDURL);
        return IDURL;
    }
    public String NewAccountText(){
        return NewAccountId.getText();
    }





}
