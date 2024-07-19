import Base.BaseTest;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();

    @Test(description = "Login Succesfull")
    public void loginSuccesfull() throws InterruptedException {

        loginPage.fillUserName(email)
                .fillPassword(password)
                .clickLogin();
        sleep(3000);
        profilePage.manageProfileButtonControl();
    }

    @Test(description = "Negatif Test Senaryo")
    public void loginUnseccesfull() throws InterruptedException {

        loginPage.fillUserName("msbiskin@hotmail.com")
                .fillPassword("Gmz2807197576")
                .clickLogin();
        sleep(3000);
        loginPage.errorMessageControl("Incorrect password for msbiskin@hotmail.com");
    }

    @Test(description = "Maximum Karakter Testi")
    public void maximumCharacter() {

        loginPage.fillUserName("ghgfhdffnnhgdfhgghjdhhdhdghbbhhhhhhhhhhhhhhjhgjh@gmail.com")
                .fillPassword("Gmz2807197jgfjgljflgjflgjfljglfjgfjgfjglkkfjglkjflgflgfjglkfjgljfgfgjflgjkflgflgjlfjglfjglfg576")
                .clickLogin()
                .validEmailMessageControl("Please enter a valid email.")
                .validPasswordControl("Your password must contain between 4 and 60 characters.");
    }

    @Test(description =  "Minimum Karakter Testi")
    public void minimumCharacter() {

        loginPage.fillUserName("gh")
                .fillPassword("Gm")
                .clickLogin()
                .validEmailMessageControl("Your username must contain between 4 and 60 characters.")
                .validPasswordControl("Your password must contain between 4 and 60 characters.");
    }

    @Test(description =  "Bos Karakter Kontrolu")
    public void requiredControl() {

        loginPage.fillUserName("")
                .fillPassword("")
                .clickLogin()
                .validEmailMessageControl("Please enter a valid email.")
                .validPasswordControl("Your password must contain between 4 and 60 characters.");
    }

}
