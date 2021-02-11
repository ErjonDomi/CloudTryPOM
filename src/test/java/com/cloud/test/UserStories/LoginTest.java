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

    @Test(description = "Verify page's title")
    public void TC01_Title() {
        Assert.assertEquals("Trycloud QA",loginPage.getLoginPageTitle());


    }
    @Test(description = "Verify forgot password link is displayed!")
    public void TC02_forgotPasswordLink() {
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());

    }


    @Test(description = "Verify user can login with valid credentials!")
    public void TC0_Login() {
        loginPage.enterUserName("User16");
        loginPage.enterPassword("Userpass123");
        loginPage.clickOnLogin();
    }

    @Test(description = "Verify user can not login with invalid credentials and message is displayed")
    public void tcase01_02() {
        loginPage.enterWrongUserName("123");
        loginPage.enterWrongPassword("459898");
        loginPage.clickOnLogin();
        Assert.assertTrue(loginPage.getMessage().contains("Wrong username or password."));
    }
    @AfterMethod()
    public void tearDown(){
        TakeScreenShots.takeScreenShot();
        Driver.closeDriver();
    }

}
