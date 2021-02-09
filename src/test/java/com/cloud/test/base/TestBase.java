package com.cloud.test.base;

import com.pages.LoginPage;
import com.qa.factory.Driver;
import com.qa.util.ConfigurationReader;
import com.qa.util.TakeScreenShots;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public abstract class TestBase {

    LoginPage login;
    @BeforeMethod
    public void setUpMethod(){
        login =new LoginPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        login.doLogin(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));

    }

    @AfterMethod()
    public void tearDown(){
        TakeScreenShots.takeScreenShot();
        Driver.closeDriver();
    }
}
