package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Loginpage;
import utilities.DriverManager;

public class LoginSteps {
    Loginpage loginPage = new Loginpage(DriverManager.getDriver().driver);


    @Given("I set the user name field with {string}")
    public void setUserName(String userName)  {
        loginPage.setUserNameTextBox(userName);
    }

    @And("I set the password field with {string}")
    public void setUserPassword(String password)  {
        loginPage.setPasswordTextBox(password);
    }

    @When("I click on login button")
    public void clickOnLoginButton()  {
        loginPage.clickOnLoginButton();
    }


    @Then("The login page should be displayed")
    public void verifyLoginPageIsDisplayed(){
        Assert.assertTrue(loginPage.loginButtonIsDisplayed());
    }


    @Then("An error message that says {string} is displayed")
    public void verifyLoginErrorMessage(String message){
        Assert.assertEquals(message, loginPage.getLoginErrorMessage());
    }


}