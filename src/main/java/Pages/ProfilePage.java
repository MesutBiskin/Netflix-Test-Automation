package Pages;

import Base.BaseLibrary;
import Base.Data;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;

public class ProfilePage extends BaseLibrary {

    By byManageProfile = By.cssSelector("[data-uia='profile-choices-manage-button']");

    @Step("Profil Sekmesi Kontrolu")
    public ProfilePage manageProfileButtonControl() {
        Boolean status = driver.findElement(byManageProfile).isDisplayed();
        Assert.assertTrue(status);
        screenshot();
        return this;
    }

}
