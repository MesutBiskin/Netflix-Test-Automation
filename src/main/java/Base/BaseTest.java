package Base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseLibrary{


    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com/login");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterTest(){
        driver.quit();
    }
}
