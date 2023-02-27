import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class D_27_Andrija_Jovanovic {

    //Prethodni zadatak za dodavanje knjiga uraditi koristeci Anotacije. Da jedan test bude sa dodavanjem jedne knjige, drugi test sa dodavanjem dve knjige, treci sa tri itd.

    WebDriver driver;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void logIn() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
        Cookie username = new Cookie("userName", "Andrija82");
        Cookie userID = new Cookie("userID", "33d97979-0db6-4bc2-a7db-190de95e1e42");
        Cookie expires = new Cookie("expires", "2023-01-22T15%3A48%3A57.017Z");
        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkFuZHJpamE4MiIsInBhc3N3b3JkIjoiQW5kcmlqYTIzISIsImlhdCI6MTY3Mzc5NzczN30.CLIpeCc5rZY0dwj-WcSmDKOfC9t_Ghdz1HxTNdjq6yI");

        driver.manage().addCookie(username);
        driver.manage().addCookie(userID);
        driver.manage().addCookie(expires);
        driver.manage().addCookie(token);

        driver.navigate().refresh();

        WebElement profileLinkText = driver.findElement(By.linkText("profile"));
        profileLinkText.click();

        WebElement check = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[4]/div/div[3]"));
        Assert.assertTrue(check.isDisplayed());
    }


    @Test
    public void addOneBook() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement bookStoreButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[2]/span"));
        js.executeScript("arguments[0].scrollIntoView();", bookStoreButton);
        bookStoreButton.click();
        driver.navigate().refresh();
        WebElement book1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/span"));
//        WebElement book1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
//        Thread.sleep(1000);
        book1.click();
        List<WebElement> addButton = driver.findElements(By.id("addNewRecordButton"));
        addButton.get(1).click();
        driver.navigate().back();
        WebElement profileButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]/span"));
        js.executeScript("arguments[0].scrollIntoView();", profileButton);
        profileButton.click();

        Thread.sleep(1000);

        WebElement book1OnTheAccount = driver.findElement(By.linkText("Git Pocket Guide"));
        Assert.assertTrue(book1OnTheAccount.isDisplayed());

    }

    @Test
    public void addTwoBooks() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement bookStoreButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[2]/span"));
        js.executeScript("arguments[0].scrollIntoView();", bookStoreButton);
        bookStoreButton.click();
        driver.navigate().refresh();
        WebElement book1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/span"));
        book1.click();
        List<WebElement> addButton = driver.findElements(By.id("addNewRecordButton"));
        addButton.get(1).click();
        driver.navigate().back();
        WebElement book2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div/div[2]/div/span/a"));
        book2.click();
        List<WebElement> addButton1 = driver.findElements(By.id("addNewRecordButton"));
        addButton1.get(1).click();
        driver.navigate().back();
        WebElement profileButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]/span"));
        js.executeScript("arguments[0].scrollIntoView();", profileButton);
        profileButton.click();

        Thread.sleep(1000);

        WebElement book1OnTheAccount = driver.findElement(By.linkText("Git Pocket Guide"));
        Assert.assertTrue(book1OnTheAccount.isDisplayed());

        WebElement book2OnTheAccount = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        Assert.assertTrue(book2OnTheAccount.isDisplayed());

    }

    @Test
    public void addThreeBooks() throws InterruptedException {

    JavascriptExecutor js = (JavascriptExecutor) driver;
    WebElement bookStoreButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[2]/span"));
    js.executeScript("arguments[0].scrollIntoView();", bookStoreButton);
    bookStoreButton.click();
    driver.navigate().refresh();
    WebElement book1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/span"));
    book1.click();
    List<WebElement> addButton = driver.findElements(By.id("addNewRecordButton"));
    addButton.get(1).click();
    driver.navigate().back();

    WebElement book2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div/div[2]/div/span/a"));
    book2.click();
    List<WebElement> addButton1 = driver.findElements(By.id("addNewRecordButton"));
    addButton1.get(1).click();
    driver.navigate().back();

    WebElement book3 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[2]/div/span/a"));
    book3.click();
    List<WebElement> addButton2 = driver.findElements(By.id("addNewRecordButton"));
    addButton2.get(1).click();
    driver.navigate().back();

    WebElement profileButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]/span"));
    js.executeScript("arguments[0].scrollIntoView();", profileButton);
    profileButton.click();

    Thread.sleep(1000);

    WebElement book1OnTheAccount = driver.findElement(By.linkText("Git Pocket Guide"));
    Assert.assertTrue(book1OnTheAccount.isDisplayed());

    WebElement book2OnTheAccount = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
    Assert.assertTrue(book2OnTheAccount.isDisplayed());

    WebElement book3OnTheAccount = driver.findElement(By.linkText("Designing Evolvable Web APIs with ASP.NET"));
    Assert.assertTrue(book3OnTheAccount.isDisplayed());

    }

    @AfterMethod
    public void deleteAndLogOut(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement deleteAllBooksButton = driver.findElement(By.cssSelector(".text-right.button.di"));
        js.executeScript("arguments[0].scrollIntoView();", deleteAllBooksButton);
        deleteAllBooksButton.click();
        WebElement confirmationButton = driver.findElement(By.id("closeSmallModal-ok"));
        confirmationButton.click();
        driver.navigate().refresh();

        driver.manage().deleteCookieNamed("username");
        driver.manage().deleteCookieNamed("userID");
        driver.manage().deleteCookieNamed("expires");
        driver.manage().deleteCookieNamed("token");

        driver.navigate().refresh();

    }

}




