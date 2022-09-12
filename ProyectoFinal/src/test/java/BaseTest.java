import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import utilities.DriverManager;

public class BaseTest {

    @Before
    public void setup() {
        DriverManager.getDriver().driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
        DriverManager.getDriver().driver.manage().window().maximize();

    }

    @AfterClass
    public static void cleanUp() {
        //DriverManager.getDriver().driver.close();

    }
}
