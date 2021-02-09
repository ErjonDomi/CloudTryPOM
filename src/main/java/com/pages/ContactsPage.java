package com.pages;

import com.qa.factory.Driver;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {



    public ContactsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getContactsTitle(){
        return Driver.getDriver().getTitle();
    }
}
