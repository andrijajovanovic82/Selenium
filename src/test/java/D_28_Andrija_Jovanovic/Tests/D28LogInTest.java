package D_28_Andrija_Jovanovic.Tests;

import D_28_Andrija_Jovanovic.Base.D28BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class D28LogInTest extends D28BaseTest {

    String validUsername = "andrijajovanovic82";
    String validPassword = "Andrija23!";

    String invalidUsername = "username";
    String invalidPassword = "password";

    @BeforeMethod
    public void pageSetUp() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://wordpress.com/");
        homePage.clickOnLoginRedcirect();
        Thread.sleep(1000);
    }

    @Test
    public void userCanLogIn() throws InterruptedException {
        loginPage.insertUsername(validUsername);
        loginPage.clickContinueButton();
        Thread.sleep(1000);
        passwordPage.insertPassword(validPassword);
        passwordPage.clickLoginButton();
        Thread.sleep(3000);

        WebElement profileName = driver.findElement(By.className("site__domain"));
        Assert.assertEquals(profileName.getText(), "com4320.wordpress.com");
    }

    @Test
    public void userCannotLogInWithInvalidUsername() throws InterruptedException {
        loginPage.insertUsername(invalidUsername);
        loginPage.clickContinueButton();
        Thread.sleep(1000);
        passwordPage.insertPassword(validPassword);
        passwordPage.clickLoginButton();
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.className("login__form-action"));
        Assert.assertTrue(loginButton.isDisplayed());

        WebElement loginTitle = driver.findElement(By.className("login__form-header"));
        Assert.assertTrue(loginTitle.isDisplayed());
    }

    @Test
    public void userCannotLogInWithInvalidPassword() throws InterruptedException {
        loginPage.insertUsername(validUsername);
        loginPage.clickContinueButton();
        Thread.sleep(1000);
        passwordPage.insertPassword(invalidPassword);
        passwordPage.clickLoginButton();
        Thread.sleep(2000);

        WebElement profileName = driver.findElement(By.cssSelector(".form-input-validation.is-error"));
        Assert.assertEquals(profileName.getText(), "Oops, that's not the right password. Please try again!");

        WebElement loginButton = driver.findElement(By.className("login__form-action"));
        Assert.assertTrue(loginButton.isDisplayed());

        WebElement loginTitle = driver.findElement(By.className("login__form-header"));
        Assert.assertTrue(loginTitle.isDisplayed());
    }

    @Test
    public void userCannotLogInWithEmptyUsernameField() throws InterruptedException {
        loginPage.clearUsernameField();
        loginPage.clickContinueButton();
        Thread.sleep(2000);

        WebElement profileName = driver.findElement(By.cssSelector(".form-input-validation.is-error"));
        Assert.assertEquals(profileName.getText(), "Please enter a username or email address.");

        WebElement continueButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        Assert.assertTrue(continueButton.isDisplayed());

        WebElement loginTitle = driver.findElement(By.className("login__form-header"));
        Assert.assertTrue(loginTitle.isDisplayed());

    }

    @Test
    public void userCannotLogInWithEmptyPasswordField() throws InterruptedException {
        loginPage.insertUsername(validUsername);
        loginPage.clickContinueButton();
        Thread.sleep(1000);
        passwordPage.clearPasswordField();
        passwordPage.clickLoginButton();
        Thread.sleep(2000);

        WebElement profileName = driver.findElement(By.cssSelector(".form-input-validation.is-error"));
        Assert.assertEquals(profileName.getText(), "Don't forget to enter your password.");

        WebElement loginButton = driver.findElement(By.className("login__form-action"));
        Assert.assertTrue(loginButton.isDisplayed());

        WebElement loginTitle = driver.findElement(By.className("login__form-header"));
        Assert.assertTrue(loginTitle.isDisplayed());


    }


}
