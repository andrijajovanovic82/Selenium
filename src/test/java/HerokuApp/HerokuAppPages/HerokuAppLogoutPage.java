package HerokuApp.HerokuAppPages;

import HerokuApp.HerokuAppBase.HerokuAppBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppLogoutPage extends HerokuAppBaseTest {
    public HerokuAppLogoutPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "flash")
    public WebElement Notification;

    @FindBy( css= ".icon-2x.icon-signout")
    public WebElement LogoutButton;

    public WebElement getLogoutButton() {
        return LogoutButton;
    }

    //-----------------------

    public String getNotificationText() {
        return Notification.getText();
    }

    public void clickOnLogoutButton() { LogoutButton.click(); }

}
