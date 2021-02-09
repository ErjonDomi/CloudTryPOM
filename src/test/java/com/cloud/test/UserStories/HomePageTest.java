package com.cloud.test.UserStories;


import com.cloud.test.base.TestBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.Driver;
import com.qa.util.ConfigurationReader;
import com.qa.util.Sleep;
import com.qa.util.TakeScreenShots;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePageTest extends TestBase {
    HomePage homePage;

    @BeforeMethod
    public void setUpMethod() {
        homePage=new HomePage();
        super.setUpMethod();



    }

    @Test
    public void TC01() {
        ArrayList<String> modules = new ArrayList<>(Arrays.asList("Dashboard", "Files", "Photos", "Activity", "Talk", "Mail", "Contacts", "Circles", "Calendar", "Deck"));
        List<WebElement> list = homePage.getAllModules();
        Sleep.sleep(3);
        int i = 0;
        for (String each : modules) {
            Assert.assertTrue(list.get(i).getAttribute("innerHTML").contains(each));
            i++;
        }


    }
    @Test
    public void TC02(){
        String actualTitle= homePage.getHomePageTitle();
        String expectedTitle= "Dashboard - Trycloud QA";
        Assert.assertEquals(actualTitle,expectedTitle);
    }



}
