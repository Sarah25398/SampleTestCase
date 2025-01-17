package TestCase;

import Utils.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankRegister extends BaseTest {
    @Test
    public void ValidateInputField(){
      bankRegister.RegisterForm().click();
       List <String>  TextCompares = Arrays.asList("First name is required.",
               "Last name is required.","Address is required.",
               "City is required.","State is required.",
               "Zip Code is required.",
               "Social Security Number is required.",
               "Username is required.",
               "Password is required.",
               "Password confirmation is required.");
        List<String> CompareErrors = bankRegister.ClassErrors();
        if(CompareErrors.size() != TextCompares.size()){
            System.out.println("The lists are not equal in size.");
        }
        else {
            boolean areEqual = true;
            for (int i =0; i < CompareErrors.size(); i++){
                if(!TextCompares.get(i).equals(CompareErrors.get(i))){
                    areEqual = false;
                    break;
                }
            }
            if(areEqual){
                System.out.println("The lists are equal and the elements match.");
            } else {
                System.out.println("The lists are not equal or the elements do not match.");
            }
        }
    }
    @Test
    public void VerifyInputRegister(){
         List <String> InputDatas = Arrays.asList(Utils.RandomData.RandomNumber(),
                 Utils.RandomData.generateRandomText(),
                 Utils.RandomData.RandomNumber(),
                 Utils.RandomData.generateRandomText(),
                 Utils.RandomData.RandomNumber(),
                 Utils.RandomData.generateRandomText(),
                 Utils.RandomData.RandomNumber(),
                 Utils.RandomData.generateRandomText(),
                 Utils.RandomData.RandomNumber(),
                 Utils.RandomData.generateRandomText(),
                 Utils.RandomData.RandomNumber()
         );
         List < WebElement> ListElementRegisters = bankRegister.getInputRegisters();
         if( ListElementRegisters.size() != InputDatas.size()){
             throw new IllegalStateException("Mismatch between data size");
         }
         for( int i=0; i < ListElementRegisters.size(); i++ ){
             String InputField = InputDatas.get(i);
             WebElement RegisterField = ListElementRegisters.get(i);
             RegisterField.clear();
             RegisterField.sendKeys(InputField);
         }

    }
}
