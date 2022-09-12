package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Loginpage;
import pages.MyInfoPage;
import utilities.DriverManager;


public class MyInfoSteps {
    MyInfoPage myinfopage= new MyInfoPage(DriverManager.getDriver().driver);

    @Then("My Info menu should be displayed")
    public void verifymyInfoPageIsDisplayed(){
        Assert.assertTrue(myinfopage.personalDetailsIsDisplayed());
    }

}
