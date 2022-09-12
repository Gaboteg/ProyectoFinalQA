package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Homepage {

    WebDriver driver;

    public Homepage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@ src= \"/web/images/orangehrm-logo.png?1660914792648\"]")
    WebElement userImg;
    @FindBy(className= "oxd-userdropdown-tab")
    WebElement userTab;

    @FindBy(xpath= "//a[@href=\"/web/index.php/auth/logout\"]")
    WebElement logoutLink;

    @FindBy(xpath="//input[@placeholder='Type for hints...']")
    WebElement nameTextBox;

    @FindBy(xpath="//input[not(@placeholder) and not(@type)]")
    WebElement idTextBox;

    @FindBy(xpath= "//*[contains(text(), 'Alice  Duval')]")//Cambiar si se borra el usuario
    WebElement usrAutocomplete;

    @FindBy(xpath= "//button[@type='submit']")
    WebElement searchButton;

    @FindBy(xpath= "//a[@href=\"/web/index.php/pim/viewMyDetails\"]")
    WebElement myInfoLink;

    @FindBy(xpath= "//*[contains(text(), '0221')]")//Cambiar junto con el usuario
    WebElement idResult;

    public void clickOnSearchButton(){
        searchButton.click();
    }

    public void clickOnMyInfoButton(){
        myInfoLink.click();
    }


    public String getID(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(idResult));

        String id = idResult.getText();
        return id;
    }
    public void setNameTextBox(String name){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(userImg));

        nameTextBox.sendKeys(name);
    }

    public void setIDTextBox(String id){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(userImg));

        idTextBox.sendKeys(id);
    }

    public boolean userImgIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(userImg));

        boolean userimgIsDisplayed = userImg.isDisplayed();
        return userimgIsDisplayed;
    }

    public void clickOnUserTab(){
        userTab.click();
    }

    public void clickOnLogout(){
        logoutLink.click();
    }

    public void clickOnAutoUsr(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(usrAutocomplete));

        usrAutocomplete.click();
    }


}
