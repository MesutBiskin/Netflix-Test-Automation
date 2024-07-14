package Pages;

import Base.Data;
import org.openqa.selenium.By;

public class LoginPage extends Data {

    By byEmail = By.name("userLoginId");
    By byPassword = By.name("password");
    By byLogin = By.cssSelector("[data-uia='login-submit-button']");

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
}
