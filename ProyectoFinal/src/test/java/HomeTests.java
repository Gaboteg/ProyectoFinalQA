import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pages.Homepage;
import pages.Loginpage;
import pages.MyInfoPage;
import utilities.DriverManager;

public class HomeTests extends BaseTest {

    @Test
    public void searchEmployeeByName() throws InterruptedException {
        Loginpage loginPage = new Loginpage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("Admin");
        loginPage.setPasswordTextBox("admin123");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        Assert.assertTrue(homepage.userImgIsDisplayed());

        homepage.setNameTextBox("Paul");
        homepage.clickOnAutoUsr();
        homepage.clickOnSearchButton();
        Assert.assertEquals("0024",
                homepage.getID());

    }

    @Test
    public void loadMyInfoPage() throws InterruptedException {
        Loginpage loginPage = new Loginpage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("Admin");
        loginPage.setPasswordTextBox("admin123");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        Assert.assertTrue(homepage.userImgIsDisplayed());

        homepage.clickOnMyInfoButton();
        MyInfoPage myinfopage= new MyInfoPage(DriverManager.getDriver().driver);
        Assert.assertTrue(myinfopage.personalDetailsIsDisplayed());


    }

    @Test
    public void searchByID() throws InterruptedException {
        Loginpage loginPage = new Loginpage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("Admin");
        loginPage.setPasswordTextBox("admin123");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        Assert.assertTrue(homepage.userImgIsDisplayed());

        homepage.setIDTextBox("0024");
        homepage.clickOnSearchButton();
        Assert.assertEquals("0024",
                homepage.getID());

    }

}
