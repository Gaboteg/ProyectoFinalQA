import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pages.Homepage;
import pages.Loginpage;
import utilities.DriverManager;

public class LoginTests extends BaseTest {

    @Test
    public void loginSuccessTest() throws InterruptedException {
        Loginpage loginPage = new Loginpage(DriverManager.getDriver().driver);
        //Thread.sleep(5000);
        //Assert.assertTrue(loginPage.loginButtonIsDisplayed());
        loginPage.setUserNameTextBox("Admin");
        loginPage.setPasswordTextBox("admin123");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        //Thread.sleep(5000);
        Assert.assertTrue(homepage.userImgIsDisplayed());
    }

    @Test
    public void loginFailTest() throws InterruptedException {
        Loginpage loginPage = new Loginpage(DriverManager.getDriver().driver);
        //Thread.sleep(5000);
        //Assert.assertTrue(loginPage.loginButtonIsDisplayed());
        loginPage.setUserNameTextBox("Admn");
        loginPage.setPasswordTextBox("admin321");
        loginPage.clickOnLoginButton();
        //Thread.sleep(2000);
        Assert.assertEquals("Invalid credentials",
                loginPage.getLoginErrorMessage());

    }


}
