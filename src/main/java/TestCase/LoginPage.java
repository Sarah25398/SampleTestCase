package TestCase;

import Utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage extends BaseTest {
    private static final String Title_Expect ="Sign In";
    private static final String Title_Email ="Email";
    private static final String Title_PassWord ="Password";
    private static final String Title_Account ="Don't have an account yet?";
    private static final String LinkSignUp ="https://supplier-dev2.vela.com.vn/account/register";

    @Test
    public void ValidHeader() {
        String TextHeader = loginPage.GetTitlePage();
        Assert.assertTrue(TextHeader.startsWith(Title_Expect));
        String TextEmail = loginPage.GetTitleEmail();
        Assert.assertTrue(TextEmail.startsWith(Title_Email));
        String TextPassWord = loginPage.GetTitlePassWord();
        Assert.assertTrue(TextPassWord.startsWith(Title_PassWord));
        String TextAccount = loginPage.TextAccount();
        Assert.assertTrue(TextAccount.startsWith(Title_Account));

    }
    @Test
    public void ValidLink(){
        String LinkSignUpTest = loginPage.LinkSignUp();
        Assert.assertTrue(LinkSignUpTest.startsWith(LinkSignUp));
        new Page.LoginPage(driver).ClickSignUpLink();
        boolean isCurrentUrlCorrect = (driver.getCurrentUrl()).equals(LinkSignUp);
        System.out.println(isCurrentUrlCorrect);
    }





}
