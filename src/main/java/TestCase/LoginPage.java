package TestCase;

import Utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class LoginPage extends BaseTest {
    private static final String Title_Expect ="Sign In";
    private static final String Title_Email ="Email";
    private static final String Title_PassWord ="Password";
    private static final String Title_Account ="Don't have an account yet?";
    private static final String LinkSignUps ="https://supplier-dev2.vela.com.vn/account/register";
    private static final String Link_Logo ="https://vela.com.vn/";
    private static final String Link_ForgetPassWord ="https://supplier-dev2.vela.com.vn/account/forgot-password";

    @Test
    public void ValidHeader() {
        String TextHeader = loginPage.GetTitlePage();
        Assert.assertTrue(TextHeader.startsWith(Title_Expect));
        String TextAccount = loginPage.TextAccount();
        Assert.assertTrue(TextAccount.startsWith(Title_Account));
        String[] TextTests ={Title_Email,Title_PassWord};
        List <String> TextUser = loginPage.GetTitle();
        for(String TextTest:  TextTests){
            Assert.assertTrue(TextUser.contains(TextTest));
        }

    }
    @Test
    public void TestInputPassWord(){
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
        String[] LinkItems = {Link_Logo,Link_ForgetPassWord, LinkSignUps};
        // Click and verify each link
        for (String LinkItem : LinkItems) {
            loginPage.VerifyClickLink(LinkItem);
        }


    }


}
