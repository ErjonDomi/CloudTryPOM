package com.cloud.test.UserStories;

import com.cloud.test.base.TestBase;
import com.pages.HomePage;
import com.pages.TalkPage;
import com.qa.util.Sleep;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TalkModuleTest extends TestBase {
    TalkPage talkPage;
    HomePage homePage;

    @BeforeMethod
    @Override
    public void setUpMethod() {
        super.setUpMethod();
        homePage=new HomePage();
        talkPage = homePage.clickTalkLink();
    }

    @Test
    public void tc01(){
        Assert.assertEquals(talkPage.getTalksTitle(),"Talk - Trycloud QA");

    }
    @Test
    public void tc02(){
        talkPage.getNameSearchBox();
        talkPage.clickSearchName();
        talkPage.sendMessage();
        Sleep.sleep(2);
    }

}
