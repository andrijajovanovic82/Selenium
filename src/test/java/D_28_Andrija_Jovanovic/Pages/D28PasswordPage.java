package D_28_Andrija_Jovanovic.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D28PasswordPage {
    public WebDriver driver;
    public WebDriverWait wdwait;

    WebElement passwordField;
    WebElement loginButton;

    public D28PasswordPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.className("login__form-action"));
    }

    public void insertPassword(String password) {
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    public void clearPasswordField(){ getPasswordField().clear(); }



}
