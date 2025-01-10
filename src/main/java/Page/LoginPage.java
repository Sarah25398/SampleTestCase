package Page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver webDriver){
        this.driver= webDriver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath ="//h2[@class='heading-page']")
    private WebElement TitleSignIn;
    public String GetTitlePage(){
        return TitleSignIn.getText();
    }
    @FindBy(xpath ="(//label[@class='form-label required'])")
    private List <WebElement> Titles;
    public List <String> GetTitle(){
        List <String> TextData = new ArrayList<>();
        for (WebElement Title: Titles){
            TextData.add(Title.getText());
            System.out.println(Title.getText());
        }
        return TextData;
    }
    @FindBy(xpath ="//input[@id='password']")
    private WebElement InputPassWord;

    public String TestInputPassWord(String DataInput){
        InputPassWord.sendKeys(DataInput);
        String TextData = InputPassWord.getShadowRoot().findElement(By.tagName("div")).findElement(By.tagName("div")).getText();
        return TextData;
    }
    @FindBy(xpath ="//div[@class='col text-sm']")
    private WebElement TextAccount;
    public String TextAccount (){
        return TextAccount.getText();
    }
    @FindBy(xpath ="(//div/a[@href])")
    private List<WebElement> LinkHovers;
    public List<String> LinkSignUp (){
        List<String> LinkTexts = new ArrayList<>();
        for(WebElement LinkHover: LinkHovers){
            LinkTexts.add(LinkHover.getAttribute("href"));
        }
       return LinkTexts;
    }
    public void VerifyClickLink(String LinkItem){
        for(WebElement LinkHover: LinkHovers){
            if((LinkHover.getAttribute("href")).equals(LinkItem)){
                LinkHover.click();
                Assert.assertTrue((driver.getCurrentUrl()).equals(LinkItem));
                System.out.println((driver.getCurrentUrl()));
                driver.navigate().back();
                break;
            }
        }
    }
    @FindBy(xpath ="//input[@id='username']")
    private WebElement InputEmail ;
    @FindBy(xpath ="//input[@id='password']")
    private WebElement InputPassWordData ;
    @FindBy(xpath ="//button[@id='btnlogin']")
    private WebElement ButtonLogin ;
    public void  InputEmailAndPassWord (String Email,String PassWord){
        InputEmail.clear();
        InputEmail.sendKeys(Email);
        InputPassWordData.clear();
        InputPassWordData.sendKeys(PassWord);
        ButtonLogin.click();
    }
    public void ClearInputField(){
        InputEmail.clear();
        InputPassWordData.clear();
    }


    @FindBy(xpath ="//label[@id='usernameRequired']")
    private WebElement EmailRequired ;
    @FindBy(xpath ="//label[@id='passwordRequired']")
    private WebElement PassWordRequired ;
    @FindBy(xpath ="(//label[@class='text-danger'])[4]")
    private WebElement IncorrectEmailAndPassWord ;
    public  String EmailRequiredText(){
        return EmailRequired.getText();
    }
    public  String PassWordRequiredText(){
        return PassWordRequired.getText();
    }
    public  String IncorrectText(){
        return IncorrectEmailAndPassWord.getText();
    }
    public boolean EmailRequired(){
        return EmailRequired.isDisplayed();
    }
    public boolean PassWordRequired(){
        return PassWordRequired.isDisplayed();
    }
    public boolean IncorrectEmailAndPassWord(){
        return IncorrectEmailAndPassWord.isDisplayed();
    }



















}
