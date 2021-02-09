package com.pages;

import com.qa.factory.Driver;
import org.openqa.selenium.support.PageFactory;

public class MailPage {


    public MailPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getMailTitle(){
        return Driver.getDriver().getTitle();
    }
}
