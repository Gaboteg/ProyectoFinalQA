package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyInfoPage {
    WebDriver driver;

    public MyInfoPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath= "//a[@href=\"/web/index.php/pim/viewPersonalDetails/empNumber/7\"]")
    WebElement personalDetailsLink;

    public boolean personalDetailsIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(personalDetailsLink));

        boolean loginButtonIsDisplayed = personalDetailsLink.isDisplayed();
        return loginButtonIsDisplayed;
    }


}
