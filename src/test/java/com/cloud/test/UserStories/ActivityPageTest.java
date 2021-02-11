package com.cloud.test.UserStories;

import com.cloud.test.base.TestBase;
import com.pages.ActivityPage;
import com.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActivityPageTest extends TestBase {
    HomePage homePage;
    ActivityPage activityPage;

    @BeforeMethod
    @Override
    public void setUpMethod() {
        super.setUpMethod();
        homePage=new HomePage();
        activityPage= homePage.clickActivityLink();
    }

    @Test(description = "Verify page's title")
    public void TC01_verifyPageTitle(){
        Assert.assertEquals(activityPage.getActivityTitle(),"Activity - Trycloud QA");
    }

    @Test(description ="Verify all activity page modules are displayed")
    public void TC02_verifyAllModules(){
        for (WebElement each: activityPage.getAllActivityModules()){
            Assert.assertTrue(each.isDisplayed());
        }
    }


}
