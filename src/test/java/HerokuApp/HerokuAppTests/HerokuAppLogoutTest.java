package HerokuApp.HerokuAppTests;

import HerokuApp.HerokuAppBase.HerokuAppBaseTest;
import HerokuApp.HerokuAppPages.HerokuAppLoginPage;
import HerokuApp.HerokuAppPages.HerokuAppLogoutPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HerokuAppLogoutTest extends HerokuAppBaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(LoginURL);
        herokuAppLoginPage = new HerokuAppLoginPage();
        herokuAppLogoutPage = new HerokuAppLogoutPage();
    }

    @Test
    public void userCanLogOut() {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.insertPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLogoutPage.getNotificationText(), "You logged into a secure area!\n" + "×");
        herokuAppLogoutPage.clickOnLogoutButton();

        Assert.assertTrue(herokuAppLoginPage.getLogInButton().isDisplayed());
        boolean logOut = false;
        try {
            logOut = herokuAppLogoutPage.getLogoutButton().isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(logOut);
        Assert.assertEquals(herokuAppLoginPage.getNotificationText(), "You logged out of the secure area!\n" + "×");
//
    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
