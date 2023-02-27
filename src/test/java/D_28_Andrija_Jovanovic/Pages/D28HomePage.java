package D_28_Andrija_Jovanovic.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D28HomePage {

    public WebDriver driver;
    public WebDriverWait wdwait;

    WebElement loginRedirect;

    public D28HomePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }
    public WebElement getLoginRedirect() { return driver.findElement(By.linkText("Log In"));
    }

    public void clickOnLoginRedcirect(){ getLoginRedirect().click();}


}
