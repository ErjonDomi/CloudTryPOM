package com.cloud.test.UserStories;

import com.cloud.test.base.TestBase;
import com.pages.HomePage;
import com.pages.LoginPage;

import com.qa.factory.Driver;
import com.qa.util.ConfigurationReader;
import com.qa.util.TakeScreenShots;
import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest  {
    LoginPage loginPage;

    @BeforeMethod
    public void setUpMethod() {

        loginPage =new LoginPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @Test
    public void TC01_Title() {
        String actualTitle = loginPage.getLoginPageTitle();
        String expectedTitle = "Trycloud QA";
        Assert.assertEquals(expectedTitle, actualTitle);

        Assert.assertTrue(loginPage.isForgotPwdLinkExist());

    }


    @Test
    public void TC0_Login() {
        loginPage.enterUserName("User16");
        loginPage.enterPassword("Userpass123");
        loginPage.clickOnLogin();
    }

    @Test()
    public void tcase01_02() {
        String expectedMessage = "Wrong username or password.";
        loginPage.enterWrongUserName("123");
        loginPage.enterWrongPassword("459898");
        loginPage.clickOnLogin();
        String actualMessage= loginPage.getMessage();
       Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
    @AfterMethod()
    public void tearDown(){
        TakeScreenShots.takeScreenShot();
        Driver.closeDriver();
    }

}
