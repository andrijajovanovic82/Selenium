import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class D_26_Andrija_Jovanovic {
    public static void main(String[] args) throws InterruptedException {

        //Ulogujte se na demoqa preko cookies-a, dodati dve knjige na svoj nalog, zatim se izlogovati brisanjem cookies-a.
        //Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");

        Cookie username = new Cookie("userName","Andrija82");
        Cookie userID = new Cookie("userID","33d97979-0db6-4bc2-a7db-190de95e1e42");
        Cookie expires = new Cookie("expires","2023-01-19T19%3A42%3A35.157Z");
        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkFuZHJpamE4MiIsInBhc3N3b3JkIjoiQW5kcmlqYTIzISIsImlhdCI6MTY3MzU1MjU1NX0.Dp_nxFDgVTNmyh9xcFElLrnSc-_O5KnfXDMyKLvdVw8");

        driver.manage().addCookie(username);
        driver.manage().addCookie(userID);
        driver.manage().addCookie(expires);
        driver.manage().addCookie(token);

        driver.navigate().refresh();

        //------------------------------------------------

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement bookStoreButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[2]/span"));

        js.executeScript("arguments[0].scrollIntoView();", bookStoreButton);

        bookStoreButton.click();

        //-------------------------------------------------

        driver.navigate().refresh();

        WebElement book1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/span"));

//        WebElement book1 = driver.findElement(By.id("see-book-Git Pocket Guide"));

        Thread.sleep(1000);
        book1.click();

        List<WebElement> addButton = driver.findElements(By.id("addNewRecordButton"));
        addButton.get(1).click();

        driver.navigate().back();

        WebElement book2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div/div[2]/div/span/a"));

//        WebElement book2 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));

        Thread.sleep(1000);
        book2.click();

        List<WebElement> addButton1 = driver.findElements(By.id("addNewRecordButton"));
        addButton1.get(1).click();

        driver.navigate().back();

        driver.navigate().refresh();

        //-----------------------------------------------

        driver.manage().deleteCookieNamed("username");
        driver.manage().deleteCookieNamed("userID");
        driver.manage().deleteCookieNamed("expires");
        driver.manage().deleteCookieNamed("token");

        driver.navigate().refresh();

        //--------------------------------------------

        WebElement loginTab = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]/span"));
        loginTab.click();

        WebElement usernameField = driver.findElement(By.id("userName"));
        usernameField.sendKeys("Andrija82");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Andrija23!");

        Thread.sleep(1000);

        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        //--------------------------------------------

        Thread.sleep(1000);

//        WebElement deleteAllBooks = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[3]/button"));
//        Assert.assertTrue(deleteAllBooks.isDisplayed());

        WebElement book1OnAccount = driver.findElement(By.linkText("Git Pocket Guide"));
        Assert.assertTrue(book1OnAccount.isDisplayed());

        WebElement book2OnAccount = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        Assert.assertTrue(book2OnAccount.isDisplayed());



    }
}
