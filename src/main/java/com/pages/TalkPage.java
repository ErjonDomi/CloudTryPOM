package com.pages;

import com.qa.factory.Driver;
import org.openqa.selenium.support.PageFactory;

public class TalkPage {
    public TalkPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getTalksTitle(){
        return Driver.getDriver().getTitle();
    }
}
