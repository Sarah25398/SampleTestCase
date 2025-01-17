package TestCase;

import Utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class LoginPage extends BaseTest {
    private static final String Title_Expect = "Sign In";
    private static final String Title_Email = "Email";
    private static final String Title_PassWord = "Password";
    private static final String Title_Account = "Don't have an account yet?";
    private static final String LinkSignUps = "https://supplier-dev2.vela.com.vn/account/register";
    private static final String Link_Logo = "https://vela.com.vn/";
    private static final String Link_ForgetPassWord = "https://supplier-dev2.vela.com.vn/account/forgot-password";

    @Test
    public void ValidHeader() {
        String TextHeader = loginPage.GetTitlePage();
        Assert.assertTrue(TextHeader.startsWith(Title_Expect));
        String TextAccount = loginPage.TextAccount();
        Assert.assertTrue(TextAccount.startsWith(Title_Account));
        String[] TextTests = {Title_Email, Title_PassWord};
        List<String> TextUser = loginPage.GetTitle();
        for (String TextTest : TextTests) {
            Assert.assertTrue(TextUser.contains(TextTest));
        }
    }
   @Test
   public void TestCase() {
       List<String> ActualLinks = bankPageAdmin.TitlePageAttributes();
       String[] ExpectedLinks = {"https://parabank.parasoft.com/parabank/about.htm", "https://parabank.parasoft.com/parabank/services.htm", "https://parabank.parasoft.com/parabank/admin.htm"};
       for (String ActualLink : ActualLinks) {
           if (ActualLinks.equals(ExpectedLinks)) {
               driver.navigate().to(ActualLink);
           }
           System.out.println(ActualLinks);
       }
   }
    @Test
    public void TestInputPassWord() {
        String InputData = "123456";
        Assert.assertTrue((loginPage.TestInputPassWord(InputData)).equals(InputData));
    }
    @Test
    public void ValidLinkRedirect() {
        String[] LinkItems = {Link_Logo, Link_ForgetPassWord, LinkSignUps};
        List<String> LinkLists = loginPage.LinkSignUp();
        for (String LinkItem : LinkItems) {
            Assert.assertTrue(LinkLists.contains(LinkItem));
        }
    }
    @Test
    public void RedirectLinkToPage() {
        String[] LinkItems = {Link_Logo, Link_ForgetPassWord, LinkSignUps};
        // Click and verify each link
        for (String LinkItem : LinkItems) {
            loginPage.VerifyClickLink(LinkItem);
        }
    }
    @Test
    public void InputDataEmailAndPassWord() throws InterruptedException {
        List<String> credentials = new ArrayList<>();
        credentials.add("leo.huy@vela.com.vn1,Huyvela1!@#1");
        credentials.add("leo.huy@vela.com.vn,Huyvela1!@#1");
        credentials.add(",Huyvela1!@#");
        credentials.add("leo.huy@vela.com.vn,");
        credentials.add(",");
        credentials.add("leo.huy@vela.com.vn,Huyvela1!@#");

        for (String credential : credentials) {
            String[] parts = credential.split(",", -1);
            String userName = parts.length > 0 ? parts[0] : "";
            String passWord = parts.length > 1 ? parts[1] : "";
            loginPage.InputEmailAndPassWord(userName, passWord);
            try {
                boolean emailRequired = loginPage.EmailRequired();
                boolean passwordRequired = loginPage.PassWordRequired();
                boolean incorrectCredentials = loginPage.IncorrectEmailAndPassWord();
                if (emailRequired && passwordRequired) {
                    Assert.assertEquals((loginPage.EmailRequiredText()), "Please input email!");
                    Assert.assertEquals((loginPage.PassWordRequiredText()), "Please input password!");
                    System.out.println("Missing PassWord And Email");

                } else if (passwordRequired) {
                    Assert.assertEquals((loginPage.PassWordRequiredText()), "Please input password!");
                    System.out.println("Login missing password ");

                } else if (incorrectCredentials) {
                    Assert.assertEquals((loginPage.IncorrectText()), "Incorrect account or password");
                    System.out.println("Incorrect account or password");
                } else if (emailRequired) {
                    Assert.assertEquals((loginPage.EmailRequiredText()), "Please input email!");
                    System.out.println("Login missing email ");
                } else if (driver.getCurrentUrl().equals("https://supplier-dev2.vela.com.vn/rfi")) {
                    System.out.println("Login Successfully");
                } else {
                    System.out.println("Unexpected scenario encountered");
                }
            } catch (Exception e) {
                System.out.println("Exception occurred: " + e.getMessage());
            }
        }
    }
    @Test
    public void GetShadowRoot() throws InterruptedException {
        WebElement Email = driver.findElement(By.xpath("//input[@id='username']"));
        Email.sendKeys("423424234");
        Thread.sleep(2000);
        WebElement InputFieldUserData = driver.findElement(By.xpath("//input[@id='username']")).getShadowRoot().findElement(By.tagName("div")).findElement(By.tagName("div"));
        String shadowRootGetText = InputFieldUserData.getText();
        System.out.println(shadowRootGetText);
    }
}
