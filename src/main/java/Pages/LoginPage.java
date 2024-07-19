package Pages;

import Base.BaseLibrary;
import Base.Data;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BaseLibrary {

    By byEmail = By.name("userLoginId");
    By byPassword = By.name("password");
    By byLogin = By.cssSelector("[data-uia='login-submit-button']");
    By byErrorMessage = By.cssSelector("[data-uia='error-message-container+header']");
    By byErrorMessage3 = By.cssSelector("[data-uia='login-field+validationMessage']");
    By byErrorMessage2 = By.cssSelector("[data-uia='password-field+validationMessage']");

    @Step("Fill username")
    public LoginPage fillUserName(String text){
        driver.findElement(byEmail).sendKeys(text);
        screenshot();
        return this;
    }

    @Step("Fill Password")
    public LoginPage fillPassword(String text){
        driver.findElement(byPassword).sendKeys(text);
        return this;
    }

    @Step("Click Login")
    public LoginPage clickLogin(){
        driver.findElement(byLogin).click();
        return this;
    }

    @Step("Hata Mesaji Kontrolu: {value}")
    public LoginPage errorMessageControl(String value){
        String Text = driver.findElement(byErrorMessage).getText();
        Assert.assertEquals(value, Text);
        Allure.addAttachment("Hata Mesaji Goruntulenmistir","");
        screenshot();
        return this;
    }

    @Step("Gecersiz Email Kontrolu: {value}")
    public LoginPage validEmailMessageControl(String value){
        String errorMessage = driver.findElement(byErrorMessage3).getText();
        Assert.assertEquals(value, errorMessage);
        Allure.addAttachment("Gecersiz Email Goruntulenmistir","");
        screenshot();
        return this;
    }

    @Step("Gecersiz Sifre Kontrolu: {value}")
    public  LoginPage validPasswordControl(String value){
        String errorMessage2 = driver.findElement(byErrorMessage2).getText();
        Assert.assertEquals(value, errorMessage2);
        Allure.addAttachment("Gecersiz Sifre Gorunutulenmistir","");
        screenshot();
        return this;
    }
}
