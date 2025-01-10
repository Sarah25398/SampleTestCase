package Page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

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












}
