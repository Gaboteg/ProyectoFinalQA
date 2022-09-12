import org.junit.Assert;
import org.junit.Test;
import pages.Homepage;
import pages.Loginpage;
import utilities.DriverManager;


public class LogoutTests extends BaseTest {
    @Test
    public void verifyLogoutTest() throws InterruptedException {
        Loginpage loginPage = new Loginpage(DriverManager.getDriver().driver);
        //Thread.sleep(5000);
        //.assertTrue(loginPage.loginButtonIsDisplayed());
        loginPage.setUserNameTextBox("Admin");
        loginPage.setPasswordTextBox("admin123");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        //Thread.sleep(5000);
        Assert.assertTrue(homepage.userImgIsDisplayed());

        homepage.clickOnUserTab();
        homepage.clickOnLogout();
        //Thread.sleep(5000);
        Assert.assertTrue(loginPage.loginButtonIsDisplayed());
    }
}
