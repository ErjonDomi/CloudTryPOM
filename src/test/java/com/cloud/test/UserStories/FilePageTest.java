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

    @Test(description = "Verify page's title")
    public void TC01() {
        Assert.assertEquals(filePage.FilePageTitle(), "Files - Trycloud QA");
    }

    @Test(description = "Verify user can upload files!")
    public void TC02() {
        Assert.assertTrue(filePage.uploadFiles("C:\\Users\\erjon\\Desktop\\ScreenShots\\erjon.txt", "erjon"));
    }

    @Test(description = "Test case #2 - verify users can select all the files from the page")
    public void TC03() {
        for (WebElement each : filePage.getSelectedCheckBox()) {
            Assert.assertTrue(each.isSelected());
        }
    }
    @Test(description = "Test case #3 - verify users can add a file to favorites.")
    public void TC04() {
        Assert.assertTrue(filePage.addToFavorites("Talk"));

    }
    @Test(description = "Test case #4 - verify users can remove a file from favorites.")
    public void TC05() {
        Assert.assertFalse(filePage.removeFromFavorites());

    }
    @Test(description = "Test case #6 - verify users can create a folder")
    public void TC06() {
        Assert.assertTrue(filePage.createFolder("folder1"));

    }
    @Test(description = "Test case #8 - verify users can write comments to files/folders.")
    public void TC07() {
        Assert.assertTrue(filePage.writeComment("Talk","hello"));

    }

}
