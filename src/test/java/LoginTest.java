import Base.BaseTest;
import Pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    By byManageProfile = By.cssSelector("[data-uia='profile-choices-manage-button']");
    By byErrorMessage = By.cssSelector("[data-uia='error-message-container+header']");
    By byErrorMessage3 = By.cssSelector("[data-uia='login-field+validationMessage']");
    By byErrorMessage2 = By.cssSelector("[data-uia='password-field+validationMessage']");


    @Test
    public void loginSuccesfull() throws InterruptedException {

        loginPage.fillUserName(email)
                .fillPassword(password)
                .clickLogin();
       sleep(3000);
        Boolean status = driver.findElement(byManageProfile).isDisplayed();
        Assert.assertTrue(status);
        driver.quit();
    }

    @Test
    public void loginUnseccesfull() throws InterruptedException {

        loginPage.fillUserName("msbiskin@hotmail.com")
                .fillPassword("Gmz2807197576")
                .clickLogin();
      sleep(3000);
        String Text = driver.findElement(byErrorMessage).getText();
        Assert.assertEquals(Text, "Incorrect password for msbiskin@hotmail.com");
        driver.quit();
        System.out.println(Text);
    }

    @Test
    public void maximumCharacter() {

        loginPage.fillUserName("ghgfhdffnnhgdfhgghjdhhdhdghbbhhhhhhhhhhhhhhjhgjh@gmail.com")
                .fillPassword("Gmz2807197jgfjgljflgjflgjfljglfjgfjgfjglkkfjglkjflgflgfjglkfjgljfgfgjflgjkflgflgjlfjglfjglfg576")
                .clickLogin();
        String errorMessage = driver.findElement(byErrorMessage3).getText();
        Assert.assertEquals("Please enter a valid email.", errorMessage);
        String errorMessage2 = driver.findElement(byErrorMessage2).getText();
        Assert.assertEquals("Your password must contain between 4 and 60 characters.", errorMessage2);


    }

}
