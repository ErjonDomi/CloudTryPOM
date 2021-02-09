package com.cloud.test.UserStories;

import com.cloud.test.base.TestBase;
import com.pages.FilePage;
import com.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FilePageTest extends TestBase {
    FilePage filePage;
    HomePage homePage;

    @Override
    @BeforeMethod
    public void setUpMethod() {
        super.setUpMethod();
        homePage=new HomePage();
        filePage = homePage.clickFileModule();
    }

    @Test
    public void TC01() {
        Assert.assertEquals(filePage.FilePageTitle(), "Files - Trycloud QA");
    }


}
