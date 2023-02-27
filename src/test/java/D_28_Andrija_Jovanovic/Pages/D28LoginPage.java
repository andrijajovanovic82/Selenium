package D_28_Andrija_Jovanovic.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D28LoginPage {
    public WebDriver driver;
    public WebDriverWait wdwait;

    WebElement emailField;
    WebElement continueButton;

    public D28LoginPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getEmailField() {
        return driver.findElement(By.id("usernameOrEmail"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.cssSelector(".button.form-button.is-primary"));
    }

    public void insertUsername(String username) {
       getEmailField().clear();
       getEmailField().sendKeys(username);
    }
    public void clickContinueButton() {
        getContinueButton().click();
    }

    public void clearUsernameField(){ getEmailField().clear();}

}
