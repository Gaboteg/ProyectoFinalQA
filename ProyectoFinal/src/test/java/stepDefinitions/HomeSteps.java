package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Homepage;
import utilities.DriverManager;

public class HomeSteps {
    Homepage homepage = new Homepage(DriverManager.getDriver().driver);


    @Then("The home page should be displayed")
    public void verifyHomePageIsDisplayed(){ Assert.assertTrue(homepage.userImgIsDisplayed()); }


    @Given("I click in the user banner")
    public void clickUserBanner(){ homepage.clickOnUserTab(); }


    @When("I click o the logout option")
    public void clickLogout(){ homepage.clickOnLogout(); }

    @When ("I click on the My Info menu")
    public void clickMyInfo(){ homepage.clickOnMyInfoButton(); }


    @Given ("I put {string} in the name field")
    public void setNameSearch(String name){ homepage.setNameTextBox(name); }

    @Given ("I set the id field to {string}")
    public void setIDSearch(String id){ homepage.setIDTextBox(id); }

    @And ("I click in the autocomplete suggestion")
    public void autoCompClick(){ homepage.clickOnAutoUsr(); }

    @When ("I click on the search button")
    public void searchClick(){ homepage.clickOnSearchButton(); }

    @Then ("The ID {string} should be the first result")
    public void AssertID(String id){ Assert.assertEquals(id,
            homepage.getID()); }



}
