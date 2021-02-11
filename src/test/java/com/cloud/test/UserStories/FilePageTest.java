package com.cloud.test.UserStories;

import com.cloud.test.base.TestBase;
import com.pages.FilePage;
import com.pages.HomePage;
import org.openqa.selenium.WebElement;
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
        homePage = new HomePage();
        filePage = homePage.clickFileModule();
    }

    @Test
    public void TC01() {
        Assert.assertEquals(filePage.FilePageTitle(), "Files - Trycloud QA");
    }

    @Test
    public void TC02() {
        Assert.assertTrue(filePage.uploadFiles("C:\\Users\\erjon\\Desktop\\ScreenShots\\erjon.txt", "erjon"));
    }

    @Test
    public void TC03() {
        for (WebElement each : filePage.getSelectedCheckBox()) {
            Assert.assertTrue(each.isSelected());
        }
    }
    @Test
    public void TC04() {
        Assert.assertTrue(filePage.addToFavorites("Talk"));

    }
    @Test
    public void TC05() {
        Assert.assertFalse(filePage.removeFromFavorites());

    }
    @Test
    public void TC06() {
        Assert.assertTrue(filePage.createFolder("folder1"));

    }
    @Test
    public void TC07() {
        Assert.assertTrue(filePage.writeComment("Talk","hello"));

    }

}
