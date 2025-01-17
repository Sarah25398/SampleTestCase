package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankRegister  {
    public WebDriver driver;
    public BankRegister(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath ="//td/input[@type='submit']")
    private WebElement RegisterForm;
    public WebElement RegisterForm(){
        return RegisterForm;
    }
    @FindBy(xpath ="//td/span[@class='error']")
    private List<WebElement> ClassErrors;
    public List <String> ClassErrors(){
        List<String> ClassErrorList = new ArrayList<>();
        for(WebElement ClassError: ClassErrors){
            ClassErrorList.add((ClassError.getText()));
            System.out.println(ClassError.getText());
        }
        return ClassErrorList;
    }
    @FindBy(xpath ="//td/input[@class='input']")
    private List<WebElement> InputRegisters;
    public List<WebElement> getInputRegisters(){
        return InputRegisters;
    }













}
