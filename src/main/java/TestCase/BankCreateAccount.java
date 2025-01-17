package TestCase;
import Utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class BankCreateAccount extends BaseTest {
    @Test
    public void VerifyLoginRedirect(){
        bankCreateAccount.Login();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://parabank.parasoft.com/parabank/overview.htm");
    }
    @Test
    public void CreateAccount() throws InterruptedException {
        bankCreateAccount.Login();
        bankCreateAccount.ClickOpenAccount();
        bankCreateAccount.OpenNewAccount();
        Assert.assertEquals(bankCreateAccount.NewAccountText(),bankCreateAccount.NewAccountId());
    }

}
