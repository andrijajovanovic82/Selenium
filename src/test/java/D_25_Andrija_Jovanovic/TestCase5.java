package D_25_Andrija_Jovanovic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestCase5 {
    public static void main(String[] args) {
        //Negative login test - No password

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://practicetestautomation.com/");

        WebElement practicePage = driver.findElement(By.id("menu-item-20"));
        practicePage.click();

        WebElement loginPage = driver.findElement(By.cssSelector("#loop-container > div > article > div.post-content > div.is-layout-flex.wp-container-3.wp-block-columns > div:nth-child(1) > p > a"));
        loginPage.click();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        //-------------------------------------

        WebElement submitButton1 = driver.findElement(By.id("submit"));
        Assert.assertTrue(submitButton1.isDisplayed());

        WebElement username1 = driver.findElement(By.id("username"));
        Assert.assertTrue(username1.isDisplayed());

        WebElement password1 = driver.findElement(By.id("password"));
        Assert.assertTrue(password1.isDisplayed());

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL );

    }
}