package Pages;

import Base.Data;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ProfilePage extends Data {

    By byManageProfile = By.cssSelector("[data-uia='profile-choices-manage-button']");

    public ProfilePage manageProfileButtonControl() {
        Boolean status = driver.findElement(byManageProfile).isDisplayed();
        Assert.assertTrue(status);
        return this;
    }

}
