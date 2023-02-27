package HerokuApp.HerokuAppTests;

import HerokuApp.HerokuAppBase.HerokuAppBaseTest;
import HerokuApp.HerokuAppPages.HerokuAppLoginPage;
import HerokuApp.HerokuAppPages.HerokuAppLogoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HerokuAppLoginTest extends HerokuAppBaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(LoginURL);
        herokuAppLoginPage = new HerokuAppLoginPage();
        herokuAppLogoutPage = new HerokuAppLogoutPage();
    }

    @Test (priority = 10)
    public void userCanLogIn() {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.insertPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();

        Assert.assertEquals(herokuAppLogoutPage.getNotificationText(), "You logged into a secure area!\n" + "×");
    }

    @Test (priority = 20)
    public void userCannotLogInWithInvalidUsername() {
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 2);
            String validPassword = excelReader.getStringData("Login", 1, 1);
            herokuAppLoginPage.insertUsername(invalidUsername);
            herokuAppLoginPage.insertPassword(validPassword);
            herokuAppLoginPage.clickOnLogInButton();

            Assert.assertEquals(herokuAppLoginPage.getNotificationText(), "Your username is invalid!\n" + "×");
            Assert.assertTrue(herokuAppLoginPage.getLogInButton().isDisplayed());
        }
    }

    @Test (priority = 30)
    public void userCannotLogInWithInvalidPassword() {
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String validUsername = excelReader.getStringData("Login", 1, 0);
            String invalidPassword = excelReader.getStringData("Login", i,3);
            herokuAppLoginPage.insertUsername(validUsername);
            herokuAppLoginPage.insertPassword(invalidPassword);
            herokuAppLoginPage.clickOnLogInButton();

            Assert.assertEquals(herokuAppLoginPage.getNotificationText(), "Your password is invalid!\n" + "×");
            Assert.assertTrue(herokuAppLoginPage.getLogInButton().isDisplayed());
        }
    }

    @Test (priority = 40)
    public void userCannotLogInWithInvalidUsernameAndPassword() {
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 2);
            String invalidPassword = excelReader.getStringData("Login", i,3);
            herokuAppLoginPage.insertUsername(invalidUsername);
            herokuAppLoginPage.insertPassword(invalidPassword);
            herokuAppLoginPage.clickOnLogInButton();

            Assert.assertEquals(herokuAppLoginPage.getNotificationText(), "Your username is invalid!\n" + "×");
            Assert.assertTrue(herokuAppLoginPage.getLogInButton().isDisplayed());
        }
    }

    @Test (priority = 50)
    public void userCannotLogInWithEmptyUsernameField() {
        String validPassword = excelReader.getStringData("Login", 1, 1);
        herokuAppLoginPage.clearUsernameField();
        herokuAppLoginPage.insertPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();

        Assert.assertEquals(herokuAppLoginPage.getNotificationText(), "Your username is invalid!\n" + "×");
        Assert.assertTrue(herokuAppLoginPage.getLogInButton().isDisplayed());
    }

    @Test (priority = 60)
    public void userCannotLogInWithEmptyPasswordField() {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.clearPasswordField();
        herokuAppLoginPage.clickOnLogInButton();

        Assert.assertEquals(herokuAppLoginPage.getNotificationText(), "Your password is invalid!\n" + "×");
        Assert.assertTrue(herokuAppLoginPage.getLogInButton().isDisplayed());

    }

    @Test (priority = 70)
    public void userCannotLogInWithEmptyFields() {
        herokuAppLoginPage.clearUsernameField();
        herokuAppLoginPage.clearPasswordField();
        herokuAppLoginPage.clickOnLogInButton();

        Assert.assertEquals(herokuAppLoginPage.getNotificationText(), "Your username is invalid!\n" + "×");
        Assert.assertTrue(herokuAppLoginPage.getLogInButton().isDisplayed());

    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
