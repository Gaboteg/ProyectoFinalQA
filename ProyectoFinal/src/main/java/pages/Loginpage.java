package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Loginpage {

    WebDriver driver;

    public Loginpage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@placeholder='Username']")
    WebElement userNameTextBox;

    @FindBy(xpath="//input[@placeholder='Password']")
    WebElement passwordTextBox;

    @FindBy(css= "button.oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button")
    WebElement loginButton;

    @FindBy(css = "p.oxd-text.oxd-text--p.oxd-alert-content-text")
    WebElement loginError;

    public void setUserNameTextBox(String userName){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        userNameTextBox.sendKeys(userName);
    }

    public void setPasswordTextBox(String password){
        passwordTextBox.sendKeys(password);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public String getLoginErrorMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        String errorMessage = loginError.getText();
        return errorMessage;
    }

    public boolean loginButtonIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        boolean loginButtonIsDisplayed = loginButton.isDisplayed();
        return loginButtonIsDisplayed;
    }


}
