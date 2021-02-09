package com.pages;

import com.qa.factory.Driver;
import org.openqa.selenium.support.PageFactory;

public class ActivityPage {
    public ActivityPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getActivityTitle(){
        return Driver.getDriver().getTitle();
    }
}
