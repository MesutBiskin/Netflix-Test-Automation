package Pages;

import Base.Data;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends Data {

    By byEmail = By.name("userLoginId");
    By byPassword = By.name("password");
    By byLogin = By.cssSelector("[data-uia='login-submit-button']");
    By byErrorMessage = By.cssSelector("[data-uia='error-message-container+header']");
    By byErrorMessage3 = By.cssSelector("[data-uia='login-field+validationMessage']");
    By byErrorMessage2 = By.cssSelector("[data-uia='password-field+validationMessage']");

    public LoginPage fillUserName(String text){
        driver.findElement(byEmail).sendKeys(text);
        return this;
    }
    public LoginPage fillPassword(String text){
        driver.findElement(byPassword).sendKeys(text);
        return this;
    }
    public LoginPage clickLogin(){
        driver.findElement(byLogin).click();
        return this;
    }
    public LoginPage errorMessageControl(String value){
        String Text = driver.findElement(byErrorMessage).getText();
        Assert.assertEquals(value, Text);
        return this;
    }
    public LoginPage validEmailMessageControl(String value){
        String errorMessage = driver.findElement(byErrorMessage3).getText();
        Assert.assertEquals(value, errorMessage);
        return this;
    }
    public  LoginPage validPasswordControl(String value){
        String errorMessage2 = driver.findElement(byErrorMessage2).getText();
        Assert.assertEquals(value, errorMessage2);
        return this;
    }
}
