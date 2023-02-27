package HerokuApp.HerokuAppPages;

import HerokuApp.HerokuAppBase.HerokuAppBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppLoginPage extends HerokuAppBaseTest {
    public HerokuAppLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    public WebElement Username;

    @FindBy(id = "password")
    public WebElement Password;

    @FindBy(css = ".fa.fa-2x.fa-sign-in")
    public WebElement LogInButton;

    @FindBy(id = "flash")
    public WebElement Notification;


    public WebElement getLogInButton() {
        return LogInButton;
    }

    public String getNotificationText() {
        return Notification.getText();
    }

    //----------------------

    public void insertUsername(String username) {
        Username.clear();
        Username.sendKeys(username);
    }

    public void insertPassword(String password) {
        Password.clear();
        Password.sendKeys(password);
    }

    public void clickOnLogInButton() {
        LogInButton.click();
    }

    public void clearUsernameField(){ Username.clear();}

    public void clearPasswordField(){ Password.clear();}


}
