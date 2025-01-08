package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver webDriver){
        this.driver= webDriver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath ="//h2[@class='heading-page']")
    private WebElement TitleSignIn;
    public String GetTitlePage(){
        return TitleSignIn.getText();
    }
    @FindBy(xpath ="(//label[@class='form-label required'])[1]")
    private WebElement TitleEmail;
    public String GetTitleEmail(){
        return TitleEmail.getText();
    }
    @FindBy(xpath ="(//label[@class='form-label required'])[2]")
    private WebElement TitlePassWord;
    public String GetTitlePassWord(){
        return TitlePassWord.getText();
    }
    @FindBy(xpath ="//div[@class='col text-sm']")
    private WebElement TextAccount;
    public String TextAccount (){
        return TextAccount.getText();
    }
    @FindBy(xpath ="(//div/a[@href])[3]")
    private WebElement LinkSignUp;
    public String LinkSignUp (){
        return LinkSignUp.getAttribute("href");
    }
    public void ClickSignUpLink(){
        LinkSignUp.click();
    }











}
