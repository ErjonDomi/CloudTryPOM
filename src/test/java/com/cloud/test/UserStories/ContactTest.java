package com.cloud.test.UserStories;

import com.cloud.test.base.TestBase;
import com.pages.ContactsPage;
import com.pages.HomePage;
import com.pages.TalkPage;
import com.qa.util.Sleep;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactTest extends TestBase {

    ContactsPage contactsPage;
    HomePage homePage;

    @BeforeMethod
    @Override
    public void setUpMethod() {
        super.setUpMethod();
        homePage = new HomePage();
        contactsPage = homePage.clickContactsLink();
    }


    @Test
    public void tc01() {
        Assert.assertEquals(contactsPage.getContactsTitle(), "Contacts - Trycloud QA");
    }


    @Test
    public void tc02() {

        Assert.assertTrue(contactsPage.CreateNewContact("Batch 21"));

        Sleep.sleep(5);

    }

}