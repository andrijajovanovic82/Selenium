package D_28_Andrija_Jovanovic.Base;

import D_28_Andrija_Jovanovic.Pages.D28HomePage;
import D_28_Andrija_Jovanovic.Pages.D28LoginPage;
import D_28_Andrija_Jovanovic.Pages.D28PasswordPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class D28BaseTest {
    public WebDriver driver;
    public WebDriverWait wdwait;

    public D28HomePage homePage;
    public D28LoginPage loginPage;
    public D28PasswordPage passwordPage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new D28HomePage (driver, wdwait);
        loginPage = new D28LoginPage(driver, wdwait);
        passwordPage = new D28PasswordPage(driver, wdwait);

    }
    @AfterClass
    public void tearDown() {
    }

}
